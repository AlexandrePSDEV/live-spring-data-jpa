package springdatajpa.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springdatajpa.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query("SELECT c FROM Cliente c WHERE id = ?1")
    @EntityGraph(attributePaths={"profissao"})
    Cliente findClienteWithProfissao(Integer id);

    @Query("SELECT c FROM Cliente c WHERE id = ?1")
    @EntityGraph(attributePaths={"profissao","emails","telefones"})
    Cliente findFullCliente(Integer id);
}
