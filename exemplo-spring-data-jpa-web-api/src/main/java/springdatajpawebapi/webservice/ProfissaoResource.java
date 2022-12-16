package springdatajpawebapi.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springdatajpawebapi.dto.response.ClienteResponse;
import springdatajpawebapi.model.Cliente;
import springdatajpawebapi.model.Profissao;
import springdatajpawebapi.repository.ClienteRepository;
import springdatajpawebapi.repository.ProfissaoRepository;
import springdatajpawebapi.service.ClienteService;
import springdatajpawebapi.service.ProfissaoService;

import java.util.List;

@RestController
@RequestMapping("/profissoes")
public class ProfissaoResource {
    @Autowired
    private ProfissaoService service;
    /**
        em alguns casos o repository pode ser acessado direto pelo controller
        mas claro se houver regra de negócio prévia, deverá se encapsulado no service blz
     */
    @Autowired
    private ProfissaoRepository repository;

    @PostMapping
    public void post(@RequestBody Profissao request){//aqui deveria ter o seu DTO
        service.save(request);
    }
    @PutMapping("/{id}")
    public void put(@PathVariable("id") Integer id, @RequestBody Profissao request){//aqui deveria ter o seu DTO
        service.update(id,request);
    }
    @GetMapping
    public List<Profissao> getAll(){
        return repository.findAll();
    }

}
