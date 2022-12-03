package springdatajpa.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springdatajpa.model.Profissao;
import springdatajpa.repository.ProfissaoRepository;

import java.util.List;

@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private ProfissaoRepository profissaoCrud;

    @Override
    public void run(String... args) throws Exception {
        incluirProfissao();
        alterarProfissao();
        listarProfissoes();
        excluirProfissao();
    }
    private  void incluirProfissao(){
        Profissao profissao  =new Profissao();
        profissao.setNome("PROGRAMADOR");
        profissaoCrud.save(profissao);
    }
    private  void alterarProfissao(){
        Profissao profissao  = profissaoCrud.findById(1).orElse(null);
        if(profissao!=null){
            profissao.setNome("PROGRAMADOR / INSTRUTOR");
            profissaoCrud.save(profissao);
        }else {
            System.out.println("Não existe a profissão com o id informado");
        }
    }
    private  void listarProfissoes(){
        List<Profissao> profissoes = profissaoCrud.findAll();
        for(Profissao p:profissoes){
            System.out.println(p.getId() + "--" + p.getNome());
        }
    }
    private  void excluirProfissao(){
       profissaoCrud.deleteById(1);
    }
}
