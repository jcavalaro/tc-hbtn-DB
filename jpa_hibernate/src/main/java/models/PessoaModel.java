package models;

import entities.Pessoa;
import entities.Produto;
import org.hibernate.SessionFactory;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class PessoaModel {

    //private SessionFactory sessionFactory = persistence.getSessionFactory();
    //protected EntityManager entityManager;

    public void create(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p); //cria um registro novo
            em.getTransaction().commit();
            System.out.println("Pessoa criada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar o pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Pessoa p) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager(); //conexao banco de dados hibernate

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("Pessoa editado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }


    }

    public void delete(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager(); //conexao banco de dados hibernate

        try {
            System.out.println("Iniciando a transação");
            Pessoa pessoaRemove = em.find(Pessoa.class, p.getId());
            em.getTransaction().begin();
            em.remove(pessoaRemove);
            em.getTransaction().commit();
            System.out.println("Pessoa deletada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao deletar pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Pessoa findByIdPessoa(Long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager(); //conexao banco de dados hibernate

        return em.find(Pessoa.class, id);
    }

    public Pessoa findById(Pessoa p) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager(); //conexao banco de dados hibernate

        try {
            System.out.println("Iniciando a transação");
            Pessoa pessoas = em.find(Pessoa.class, p.getId());
            System.out.println("Pessoa " + pessoas.getId() + " encontrado com sucesso !!!");
            return pessoas;
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao achar a pessoa pelo id !!!" + e.getMessage());
            return null;
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }

    }

    public List<Pessoa> findAll() {

        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager(); //conexao banco de dados hibernate

        try {
            System.out.println("Iniciando a transação");
            pessoas = em.createQuery("from Pessoa pessoa", Pessoa.class).getResultList();

        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao achar a Pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return pessoas;
    }
}
