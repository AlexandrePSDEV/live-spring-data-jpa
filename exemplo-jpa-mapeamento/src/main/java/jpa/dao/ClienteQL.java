package jpa.dao;

import jpa.dto.ClienteParcialDto;
import jpa.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
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
        for(Cliente cli: clientes){
            System.out.println(cli.getNome());
            System.out.println(cli.getEmails());
            System.out.println(cli.getTelefones());
            System.out.println(cli.getProfissao().getNome());
        }
    }
    public void listarClientesPorNome(String nome){
        Query query = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.nome LIKE :nome");

        //query.setParameter("nome",nome);
        query.setParameter("nome","%"+nome+"%");

        List<Cliente> clientes = query.getResultList();
        System.out.println("listando os clientes que possuem o nome " + nome);

        //tentem refatorar o código acima usando Criteria
    }
    public void listarClientesParcialDto(){
        TypedQuery<ClienteParcialDto> q = entityManager.createQuery("SELECT new jpa.dto.ClienteParcialDto(c.nome, c.endereco.logradouro) FROM Cliente c", ClienteParcialDto.class);
        List<ClienteParcialDto> clientes = q.getResultList();
        for(ClienteParcialDto c: clientes){
            System.out.println(c);
        }
    }
    public void listarClientesDto(){
        StringBuilder select = new StringBuilder();
        select.append(" SELECT c.id as id, c.nome as nome, c.dataNascimento as dataNascimento,");
        select.append(" concat(c.endereco.logradouro, ', ',c.endereco.numero,' - ', c.endereco.cep) as enderecoCompleto, "); //apelidando um expressão jpql
        select.append(" c.profissao.nome as profissao ");
        select.append(" FROM Cliente c");
        TypedQuery<Tuple> query = entityManager.createQuery(select.toString(), Tuple.class);
        List<Tuple> registros = query.getResultList();
        for (Tuple r : registros) {
            System.out.println("** - registro - ** ");
            System.out.println(r.get("id"));
            System.out.println(r.get("nome"));
            System.out.println(r.get("dataNascimento"));
            System.out.println(r.get("enderecoCompleto"));
            System.out.println(r.get("profissao"));
        }

        /** DESAFIO Native Query

            //https://thorben-janssen.com/dto-projections/

            Query nativeQuery = entityManager.createNativeQuery(select.toString(), Tuple.class);

            List<Tuple> registros = query.getResultList();
            for (Tuple r : registros) {
                System.out.println("** - registro - ** ");
                System.out.println(r.get("id"));
                System.out.println(r.get("nome"));
                System.out.println(r.get("dataNascimento"));
                System.out.println(r.get("enderecoCompleto"));
                System.out.println(r.get("profissao"));
            }

         **/
    }
}
