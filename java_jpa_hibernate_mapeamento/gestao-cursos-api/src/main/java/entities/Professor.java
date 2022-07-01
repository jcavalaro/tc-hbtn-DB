package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="professor")
public class Professor {

    //Um professor pode ter um ou mais cursos.(OneToMany)
    @OneToMany(mappedBy = "prof", targetEntity = Curso.class, cascade = CascadeType.ALL)
    private Collection curso;


    /*
 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(name="ALUNO_TELEFONE",
             joinColumns={@JoinColumn(name = "ALUNO_ID")},
             inverseJoinColumns={@JoinColumn(name = "TELEFONE_ID")})
  private List<Telefone> telefones;*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //o ID irá gerar identidade
    protected Long id;

    @Column
    protected String nomeCompleto;

    @Column
    protected String matricula;

    @Column
    protected String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
