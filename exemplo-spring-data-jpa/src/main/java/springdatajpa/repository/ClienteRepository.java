package springdatajpa.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springdatajpa.dto.response.ClienteResponse;
import springdatajpa.dto.view.ClienteView;
import springdatajpa.dto.view.ProfissaoView;
import springdatajpa.model.Cliente;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query("SELECT c FROM Cliente c WHERE id = ?1")
    @EntityGraph(attributePaths={"profissao"})
    Cliente findClienteWithProfissao(Integer id);

    @Query("SELECT c FROM Cliente c WHERE id = ?1")
    @EntityGraph(attributePaths={"profissao","emails","telefones"})
    Cliente findFullCliente(Integer id);


    List<ClienteView> findByNome(String nome);
    List<ClienteResponse> findByNomeContaining(String nome);
}
