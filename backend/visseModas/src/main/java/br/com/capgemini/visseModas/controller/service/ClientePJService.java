package br.com.capgemini.visseModas.controller.service;

import br.com.capgemini.visseModas.model.dto.ClientePJDTO;
import br.com.capgemini.visseModas.model.entity.ClientePJ;
import br.com.capgemini.visseModas.model.repository.ClientePJRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientePJService {

    @Autowired //injecao de dependencia
    private ClientePJRepository repository;

    public void salvar(ClientePJ clientePJ) {
        repository.save(clientePJ);
    }

    private void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<ClientePJ> listarTudo() {
        return repository.findAll();
    }

    //find com DTO
    public List<ClientePJDTO> listarTudoDTO(){
        List<ClientePJ> listaClientesPJ = repository.findAll();
        return ClientePJDTO.converter(listaClientesPJ);
    }

    public ClientePJ alterar(Long id){

        //recebe do banco de dados
        Optional<ClientePJ> clientePJBuscado = repository.findById(id);

        if(!clientePJBuscado.isPresent()){
            return null;
        }

        //converte o Option
        ClientePJ clientePJ = clientePJBuscado.get();

        ClientePJ clientePJNovo = new ClientePJ();
        clientePJNovo.setNome(clientePJ.getNome());
        clientePJNovo.setCnpj(clientePJ.getCnpj());

        repository.save(clientePJ);

        return clientePJNovo;

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
