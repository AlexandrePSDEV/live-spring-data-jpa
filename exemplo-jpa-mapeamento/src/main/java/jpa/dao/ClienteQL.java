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
        for(Cliente c: clientes){
            System.out.println(c.getNome());
            if(c.getEmails()!=null){
                System.out.println("Este cliente possui e-mails");
                for(String e: c.getEmails()){
                    System.out.println(e);
                }
            }
            if(c.getTelefones()!=null){
                System.out.println("Este cliente possui telefones");
                for(Telefone t: c.getTelefones()){
                    System.out.println(t.getNumero() + "-" + t.getTipo());
                }
            }
        }
    }
}
