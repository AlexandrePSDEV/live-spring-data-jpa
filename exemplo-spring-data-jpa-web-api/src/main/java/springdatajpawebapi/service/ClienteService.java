package springdatajpawebapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdatajpawebapi.model.Cliente;
import springdatajpawebapi.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    public void save(Cliente entity){
        //sua logica de negocio
        repository.save(entity);
    }
}
