package springdatajpawebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springdatajpawebapi.model.Profissao;

public interface ProfissaoRepository extends JpaRepository<Profissao,Integer> { }
