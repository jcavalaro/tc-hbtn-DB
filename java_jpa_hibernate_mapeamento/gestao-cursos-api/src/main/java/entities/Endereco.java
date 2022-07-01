package entities;

import javax.persistence.*;

@Entity
@Table(name="endereco")
public class Endereco {

    //Aluno tem um ou mais endereço (oneToMany)
    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno alun;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //o ID irá gerar identidade
    protected Long id;

    @Column
    protected String logradouro;

    @Column
    protected String endereco;

    @Column
    protected String numero;

    @Column
    protected String bairro;

    @Column
    protected String cidade;

    @Column
    protected String estado;

    @Column
    protected Integer cep;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }
}
