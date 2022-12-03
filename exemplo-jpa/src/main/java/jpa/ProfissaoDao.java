package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfissaoDao {
    private static EntityManager entityManager;
    public ProfissaoDao(){
        /**
          isso só deve acontecer uma vez ao longo da aplicação
          Se algum dia precisar, estude sobre padrão singleton
         */
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("MY_PU");
            entityManager = factory.createEntityManager();
            System.out.println("conexao realizada com sucesso");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void save (Profissao profissao){
        entityManager.getTransaction().begin();;
        entityManager.persist(profissao);
        entityManager.getTransaction().commit();
    }
    public void update(Profissao profissao){
        entityManager.getTransaction().begin();;
        entityManager.merge(profissao);
        entityManager.getTransaction().commit();
    }
    public int delete(Integer id){
        Profissao profissao = findById(id);
        if(profissao!=null){
            entityManager.getTransaction().begin();;
            entityManager.remove(profissao);
            entityManager.getTransaction().commit();
            return id;
        }else
            return 0;

    }
    //buscar um profissao na base atraves do seu id ?
    public Profissao findById(Integer id){
       return entityManager.find(Profissao.class,id);
    }
    public List<Profissao> findAll(){
        //JPQL x CRITERIA
        Query query = entityManager.createQuery("SELECT p FROM Profissao p",Profissao.class);//SELECT sobre a Entidade
        //entityManager.createNativeQuery("SELECT * FROM tab_profissao");

        //query.setParameter();
        return query.getResultList();
    }

}
