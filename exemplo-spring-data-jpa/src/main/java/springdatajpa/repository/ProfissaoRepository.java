package springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springdatajpa.model.Profissao;

public interface ProfissaoRepository extends JpaRepository<Profissao,Integer> { }
