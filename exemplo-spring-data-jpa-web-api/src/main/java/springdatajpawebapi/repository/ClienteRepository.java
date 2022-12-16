package springdatajpawebapi.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springdatajpawebapi.dto.response.ClienteResponse;
import springdatajpawebapi.model.Cliente;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query("SELECT c FROM Cliente c WHERE id = ?1")
    //@EntityGraph(attributePaths={"profissao"})
    //@EntityGraph(value = "cliente-full", type = EntityGraph.EntityGraphType.LOAD)
    @EntityGraph(attributePaths={"profissao","emails","telefones"})
    Cliente getFull(Integer id);

    List<ClienteResponse> findByNomeContaining(String nome);
}
