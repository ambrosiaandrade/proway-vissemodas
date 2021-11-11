package br.com.capgemini.visseModas.controller.service;

import br.com.capgemini.visseModas.model.dto.ClienteDTO;
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

    public void salvar(Cliente cliente) {
        repository.save(cliente);
    }

    private void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<Cliente> listarTudo() {
        return repository.findAll();
    }

    //find com DTO
    public List<ClienteDTO> listarTudoDTO(){
        List<Cliente> listaClientes = repository.findAll();
        return ClienteDTO.converter(listaClientes);
    }

    public Cliente alterar(Long id){

        //recebe do banco de dados
        Optional<Cliente> clientePFBuscado = repository.findById(id);

        if(!clientePFBuscado.isPresent()){
            return null;
        }

        //converte o Option
        Cliente cliente = clientePFBuscado.get();

        Cliente clientePFNovo = new Cliente();
        clientePFNovo.setNome(cliente.getNome());
        clientePFNovo.setCpf(cliente.getCpf());

        repository.save(cliente);

        return clientePFNovo;

    }

//    public void merge(Long id, ClientePF clientePF){
//
//        ClientePF clientePFPesquisado = repository.getOne(id);
//
//        if(clientePFPesquisado != null){
//            clientePFPesquisado.setNome(clientePF.getNome());
//            clientePFPesquisado.setCpf(clientePF.getCpf());
//            repository.save(clientePFPesquisado);
//        }
//
//    }


}

