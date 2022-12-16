package springdatajpa.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springdatajpa.dto.ProfissaoDto;
import springdatajpa.dto.ProfissaoView;
import springdatajpa.model.Cliente;
import springdatajpa.model.Profissao;
import springdatajpa.model.cliente.Endereco;
import springdatajpa.model.cliente.Telefone;
import springdatajpa.model.cliente.TelefoneTipo;
import springdatajpa.repository.ClienteRepository;
import springdatajpa.repository.ProfissaoDao;
import springdatajpa.repository.ProfissaoRepository;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Component
public class StartProjections implements CommandLineRunner {
    @Autowired
    private ProfissaoRepository profissaoCrud;

    @Autowired
    private ClienteRepository clienteRepository;

    //https://thorben-janssen.com/spring-data-jpa-query-projections/
    @Override
    public void run(String... args) throws Exception {
        //listarProfissoesProjection();
        listarProfissoesViewProjection();
    }
    //Projections Dtos
    private void listarProfissoesProjection(){
        List<ProfissaoDto>  dtos = profissaoCrud.findByNome("PROGRAMADOR");
        for(ProfissaoDto d: dtos){
            System.out.println(d);
        }
    }
    //Projections View
    private void listarProfissoesViewProjection(){
        List<ProfissaoView>  views = profissaoCrud.findViewByNome("PROGRAMADOR");
        for(ProfissaoView v: views){
            System.out.println(v.getId() + "-"+v.getNome());
        }
    }

}
