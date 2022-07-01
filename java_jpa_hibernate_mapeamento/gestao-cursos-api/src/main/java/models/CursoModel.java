package models;

import entities.Aluno;
import entities.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class CursoModel {

    public void create(Curso curso) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
    EntityManager em = emf.createEntityManager();

        try {
        System.out.println("Iniciando a transação");
        em.getTransaction().begin();
        em.persist(curso);
        em.getTransaction().commit();
        System.out.println("Curso criado com sucesso !!!");
    } catch (Exception e) {
        em.close();
        System.err.println("Erro ao criar um Curso !!!" + e.getMessage());
    } finally {
        em.close();
        System.out.println("Finalizando a transação");
    }
}

    public Curso findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager(); //conexao banco de dados hibernate

        return em.find(Curso.class, id);
    }

    public List<Curso> findAll() {
        List<Curso> cursos = new ArrayList<Curso>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager(); //conexao banco de dados hibernate

        try {
            System.out.println("Iniciando a transação");
            cursos = em.createQuery("from Curso curso", Curso.class).getResultList();

        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao achar o Curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return cursos;
    }

    public void update(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager(); //conexao banco de dados hibernate

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
            System.out.println("Curso editado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao editar curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager(); //conexao banco de dados hibernate

        try {
            System.out.println("Iniciando a transação");
            Curso cursoRemove = em.find(Curso.class, curso.getId());
            em.getTransaction().begin();
            em.remove(cursoRemove);
            em.getTransaction().commit();
            System.out.println("Curso deletado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao deletar aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }


}
