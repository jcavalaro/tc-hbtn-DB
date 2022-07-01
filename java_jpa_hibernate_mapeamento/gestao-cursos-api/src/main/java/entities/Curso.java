package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="curso")
public class Curso {

    //um curso tem apenas um material (OneToOne)
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_material")
    private MaterialCurso mat;

    //um curso tem apenas um professor (OneToOne) //duvida ness parte
    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor prof;

    //Um curso pode ter um ou mais alunos (OneToMany)
    @OneToMany(mappedBy = "alu", targetEntity = Aluno.class, cascade = CascadeType.ALL)
    private Collection aluno;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //o ID irá gerar identidade
    protected Long id;

    @Column
    protected String nome;

    @Column
    protected String sigla;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
