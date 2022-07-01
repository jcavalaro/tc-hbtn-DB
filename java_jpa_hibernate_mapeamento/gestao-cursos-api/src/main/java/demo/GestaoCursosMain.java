package demo;

import entities.Aluno;
import entities.Curso;
import models.AlunoModel;
import models.CursoModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class GestaoCursosMain {

    public static void main(String[] args) throws ParseException {

        CursoModel cursoModels = new CursoModel();
        AlunoModel alunoModels = new AlunoModel();

        //1A creat alunoModel
        Aluno a1 = new Aluno();
        a1.setNomeCompleto("Sara Lindinha");
        a1.setEmail("sara.lindinha@teste.com");
        a1.setNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("22/03/1922"));

        alunoModels.create(a1);

        //1B creat cursoModel
        Curso c1 = new Curso();
        c1.setNome("Matematica");
        c1.setSigla("MTC");
        
        cursoModels.create(c1);



    }

}
