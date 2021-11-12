package br.com.capgemini.visseModas.controller.service;

import br.com.capgemini.visseModas.model.dtoSaida.ClienteDTOSaida;
import br.com.capgemini.visseModas.model.entity.Cliente;
import br.com.capgemini.visseModas.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired //injecao de dependencia
    private ClienteRepository repository;

    //save
    public void salvar(Cliente cliente) {
        repository.save(cliente);
    }

    //delete
    public void inativar(Long id) {
        Cliente cliente = repository.getById(id);
        cliente.setStatus(false);
        repository.save(cliente);
    }

    //find com DTO
    public List<ClienteDTOSaida> listarTudoDTO(){
        List<Cliente> listaClientes = repository.findAll();
        return ClienteDTOSaida.converter(listaClientes);
    }

    public Cliente alterar(Long id){

        //recebe do banco de dados
        Optional<Cliente> clienteOptional = repository.findById(id);

        if(!clienteOptional.isPresent()){
            return null;
        }

        //converte o Option
        Cliente cliente = clienteOptional.get();

        Cliente clienteNovo = new Cliente();
        clienteNovo.setNome(cliente.getNome());
        clienteNovo.setCpf(cliente.getCpf());
        //clienteNovo.getCnpj(cliente.getCnpj());


        repository.save(cliente);

        return clienteNovo;

    }



}

