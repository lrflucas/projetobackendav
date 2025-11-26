package sistema.financeiro.api.domain.lancamento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public record DadosCadastroLancamento(@NotBlank String descricao, @NotNull Date dataVencimento, Date dataPagamento, @NotNull BigDecimal valor, String observacao, @NotNull TipoLancamento tipo) {
}
