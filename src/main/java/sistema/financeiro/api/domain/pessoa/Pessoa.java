package sistema.financeiro.api.domain.pessoa;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sistema.financeiro.api.domain.endereco.Endereco;
import sistema.financeiro.api.domain.lancamento.Lancamento;

import java.util.ArrayList;
import java.util.List;

@Table(name = "pessoas")
@Entity(name = "Pessoa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    // relacionamento com lançamento
    @OneToMany(mappedBy = "pessoa")
    private List<Lancamento> lancamento = new ArrayList<>();

    public Pessoa(DadosCadastroPessoa dados) {
        this.nome = dados.nome();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoPessoa dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }

    // gets

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public List<Lancamento> getLancamento() {
        return lancamento;
    }
}
