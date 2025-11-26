package sistema.financeiro.api.domain.lancamento;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sistema.financeiro.api.domain.categoria.Categoria;
import sistema.financeiro.api.domain.pessoa.Pessoa;

import java.math.BigDecimal;
import java.util.Date;

@Table(name = "lancamentos")
@Entity(name = "Lancamento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Date dataVencimento;
    private Date dataPagamento;
    private BigDecimal valor;
    private String observacao;

    @Enumerated(EnumType.STRING)
    private TipoLancamento tipo;

    // relacionamento com categoria
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    // relacionamento com pessoa
    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    public Lancamento(DadosCadastroLancamento dados) {
        this.descricao = dados.descricao();
        this.dataVencimento = dados.dataVencimento();
        this.dataPagamento = dados.dataPagamento();
        this.valor = dados.valor();
        this.observacao = dados.observacao();
        this.tipo = dados.tipo();
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoLancamento dados) {
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.dataVencimento() != null) {
            this.dataVencimento = dados.dataVencimento();
        }
        if (dados.dataPagamento() != null) {
            this.dataPagamento = dados.dataPagamento();
        }
        if (dados.valor() != null) {
            this.valor = dados.valor();
        }
        if (dados.observacao() != null) {
            this.observacao = dados.observacao();
        }
        if (dados.tipo() != null) {
            this.tipo = dados.tipo();
        }
    }

    // gets

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public TipoLancamento getTipo() {
        return tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
}
