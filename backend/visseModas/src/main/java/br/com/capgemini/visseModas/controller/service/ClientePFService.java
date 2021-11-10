
package br.com.capgemini.visseModas.controller.service;

import br.com.capgemini.visseModas.model.dto.ClientePFDTO;
import br.com.capgemini.visseModas.model.entity.ClientePF;
import br.com.capgemini.visseModas.model.repository.ClientePFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientePFService {

    @Autowired //injecao de dependencia
    private ClientePFRepository repository;

    public void salvar(ClientePF clientePF) {
        repository.save(clientePF);
    }

    private void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<ClientePF> listarTudo() {
        return repository.findAll();
    }

    //find com DTO
    public List<ClientePFDTO> listarTudoDTO(){
        List<ClientePF> listaClientesPF = repository.findAll();
        return ClientePFDTO.converter(listaClientesPF);
    }

    public ClientePF alterar(Long id){

        //recebe do banco de dados
        Optional<ClientePF> clientePFBuscado = repository.findById(id);

        if(!clientePFBuscado.isPresent()){
            return null;
        }

        //converte o Option
        ClientePF clientePF = clientePFBuscado.get();

        ClientePF clientePFNovo = new ClientePF();
        clientePFNovo.setNome(clientePF.getNome());
        clientePFNovo.setCpf(clientePF.getCpf());

        repository.save(clientePF);

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

