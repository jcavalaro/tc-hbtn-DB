package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
@Table(name="aluno")
public class Aluno {

    //Aluno tem um ou mais endereço (oneToMany)
    @OneToMany(mappedBy = "alun", targetEntity = Endereco.class, cascade = CascadeType.ALL)
    private Collection endereco;

    //Aluno pode ter um ou mais telefones (oneToMany)
    @OneToMany(mappedBy = "alunTel", targetEntity = Telefone.class, cascade = CascadeType.ALL)
    private Collection telefone;

    //Um curso pode ter um ou mais alunos (OneToMany)
    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Aluno alu;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //o ID irá gerar identidade
    protected Long id;

    @Column
    protected String nomeCompleto;


    @Temporal(TemporalType.DATE)
    protected Date nascimento;

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

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
