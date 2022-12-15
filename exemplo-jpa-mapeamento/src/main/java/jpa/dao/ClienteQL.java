package jpa.dao;

import jpa.model.Cliente;
import jpa.model.cliente.Telefone;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ClienteQL {
    private EntityManager entityManager;
    public ClienteQL(){
        entityManager = FabricaConexao.getEntityManager();
    }
    public void listarClientes(){
        Query query = entityManager.createQuery("SELECT c FROM Cliente c");
        List<Cliente> clientes = query.getResultList();
        System.out.println("listando os clientes");
    }
    public void listarClientesPorNome(String nome){
        Query query = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.nome LIKE :nome");

        //query.setParameter("nome",nome);
        query.setParameter("nome","%"+nome+"%");

        List<Cliente> clientes = query.getResultList();
        System.out.println("listando os clientes que possuem o nome " + nome);
    }
}
