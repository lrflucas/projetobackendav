package sistema.financeiro.api.domain.categoria;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sistema.financeiro.api.domain.lancamento.Lancamento;

import java.util.ArrayList;
import java.util.List;

@Table(name = "categorias")
@Entity(name = "Categoria")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    // relacionamento com lançamento
    @OneToMany(mappedBy = "categoria")
    private List<Lancamento> lancamento = new ArrayList<>();

    public Categoria(DadosCadastroCategoria dados) {
        this.nome = dados.nome();
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoCategoria dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
    }

    // gets

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Lancamento> getLancamento() {
        return lancamento;
    }
}
