package entities;

import javax.persistence.*;

@Entity
@Table(name="telefone")
public class Telefone {

    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno alunTel;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //o ID irá gerar identidade
    protected Long id;

    @Column
    protected String DDD;

    @Column
    protected String numero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDDD() {
        return DDD;
    }

    public void setDDD(String DDD) {
        this.DDD = DDD;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
