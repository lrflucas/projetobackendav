package sistema.financeiro.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import sistema.financeiro.api.domain.lancamento.*;

@RestController
@RequestMapping("lancamentos")
@SecurityRequirement(name = "bearer-key")
public class LancamentoController {

    @Autowired
    private LancamentoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroLancamento dados, UriComponentsBuilder uriBuilder){
        var lancamento = new Lancamento(dados);
        repository.save(lancamento);

        var uri = uriBuilder.path("/lancamentos/{id}").buildAndExpand(lancamento.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoLancamento(lancamento));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemLancamento>> listar(@PageableDefault(size = 10, sort = {"descricao"}) Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosListagemLancamento::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoLancamento dados){
        var lancamento = repository.getReferenceById(dados.id());
        lancamento.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoLancamento(lancamento));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var lancamento = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoLancamento(lancamento));
    }
}
