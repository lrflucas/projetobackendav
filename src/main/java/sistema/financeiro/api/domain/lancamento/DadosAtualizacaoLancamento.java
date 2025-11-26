package sistema.financeiro.api.domain.lancamento;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public record DadosAtualizacaoLancamento(@NotNull Long id, String descricao, Date dataVencimento, Date dataPagamento, BigDecimal valor, String observacao, TipoLancamento tipo) {
}
