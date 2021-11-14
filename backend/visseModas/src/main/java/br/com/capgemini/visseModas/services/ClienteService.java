package br.com.capgemini.visseModas.services;

import br.com.capgemini.visseModas.models.dtos.dtos.ClienteDTOSaida;
import br.com.capgemini.visseModas.models.entities.Cliente;
import br.com.capgemini.visseModas.models.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    //TODO validar cpf e cnpj

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
    public List<ClienteDTOSaida> listarTudoDTO() {
        List<Cliente> listaClientes = repository.findAll();
        return ClienteDTOSaida.converter(listaClientes);
    }

    public void alterar(Cliente cliente) {

        //recebe do banco de dados
        Cliente clientePesquisado = repository.findById(cliente.getId()).get();

        if (clientePesquisado != null) {
            clientePesquisado.setNome(cliente.getNome());
            //clientePesquisado.setDocumento(cliente.getDocumento());
            //clientePesquisado.setTipoCliente(cliente.getTipoCliente());
            clientePesquisado.setEmail(cliente.getEmail());
            clientePesquisado.setSenha(cliente.getSenha());

            repository.save(clientePesquisado);
        }
    }




}





