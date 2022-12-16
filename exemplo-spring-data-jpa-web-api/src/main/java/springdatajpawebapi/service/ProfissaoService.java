package springdatajpawebapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdatajpawebapi.model.Profissao;
import springdatajpawebapi.repository.ProfissaoRepository;

@Service
public class ProfissaoService {
    @Autowired
    private ProfissaoRepository repository;
    public void save(Profissao request){
        //deveria ser um dto
        repository.save(request);
    }
    public void update(Integer id, Profissao request){
        //deveria ser um dto e tratar algumas regras
        Profissao entity = repository.findById(id).orElse(null);
        //existem outras maneiras de implementar isso
        entity.setNome(request.getNome());
        repository.save(entity);
    }
}
