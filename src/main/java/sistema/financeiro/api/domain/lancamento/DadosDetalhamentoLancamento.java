package sistema.financeiro.api.domain.lancamento;

import java.math.BigDecimal;
import java.util.Date;

public record DadosDetalhamentoLancamento(Long id, String descricao, Date dataVencimento, Date dataPagamento, BigDecimal valor, String observacao, TipoLancamento tipo) {

    public DadosDetalhamentoLancamento (Lancamento lancamento) {
        this(lancamento.getId(), lancamento.getDescricao(), lancamento.getDataVencimento(), lancamento.getDataPagamento(), lancamento.getValor(), lancamento.getObservacao(), lancamento.getTipo());
    }
}
