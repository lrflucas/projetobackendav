package sistema.financeiro.api.domain.pessoa;

import sistema.financeiro.api.domain.endereco.Endereco;

public record DadosListagemPessoa(Long id, String nome, Endereco endereco) {

    public DadosListagemPessoa(Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getEndereco());
    }
}
