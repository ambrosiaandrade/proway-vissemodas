package br.com.capgemini.visseModas.services;

import br.com.capgemini.visseModas.models.dtos.dtos.ClienteDTO;
import br.com.capgemini.visseModas.models.dtos.update.ClienteUpdate;
import br.com.capgemini.visseModas.models.entities.Cliente;
import br.com.capgemini.visseModas.models.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void salvar(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public ResponseEntity<ClienteUpdate> alterar(Long id, ClienteUpdate form) {

        Optional<Cliente> optional = clienteRepository.findById(id);
        if (optional.isPresent()) {
            Cliente cliente = form.atualizar(id, clienteRepository);
            clienteRepository.save(cliente);
            return ResponseEntity.ok(new ClienteUpdate(cliente));
        }

        return ResponseEntity.notFound().build();
    }

//    public ResponseEntity<Cliente> inativar(Long id) {
//
//        Optional<Cliente> optional = clienteRepository.findById(id);
//
//        if (optional.isPresent()) {
//
//            Cliente cliente = optional.get();
//            cliente.setStatus(false);
//            clienteRepository.save(cliente);
//            return ResponseEntity.ok().build();
//
//        }
//
//        return ResponseEntity.notFound().build();
//    }

    public Cliente buscarPorNome(String nome) {
        Optional<Cliente> clienteOptional = clienteRepository.findByNome(nome);
        if (clienteOptional.isPresent()) {
            return clienteOptional.get();
        }

        return null;
    }

    public ResponseEntity<ClienteDTO> detalhar(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            return ResponseEntity.ok(new ClienteDTO(clienteOptional.get()));
        }

        return ResponseEntity.notFound().build();
    }

    public List<ClienteDTO> listarTudoDTO() {
        List<Cliente> listaClientes = clienteRepository.findAll();
        return ClienteDTO.converter(listaClientes);
    }

    public Page<ClienteDTO> listarTudoDTOPaginacao(Pageable paginacao) {
        //devolve um page ao invés de uma lista
        Page<Cliente> listaClientes = clienteRepository.findAll(paginacao);
        return ClienteDTO.converterPaginacao(listaClientes);
    }

}