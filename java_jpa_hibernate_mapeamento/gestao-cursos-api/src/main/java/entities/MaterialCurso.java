package entities;

import javax.persistence.*;

@Entity
@Table(name="materialCurso")
public class MaterialCurso {

    //um curso tem apenas um material (OneToOne)
    @OneToOne (mappedBy = "mat")
    private Curso curso;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //o ID irá gerar identidade
    protected Long id;

    @Column
    protected String url;

}
