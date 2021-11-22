package br.com.capgemini.visseModas.services;

import br.com.capgemini.visseModas.models.dtos.dtos.EnderecoDTO;
import br.com.capgemini.visseModas.models.dtos.dtos.ProdutoDTO;
import br.com.capgemini.visseModas.models.entities.Endereco;
import br.com.capgemini.visseModas.models.entities.Produto;
import br.com.capgemini.visseModas.models.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired // injeção de dependência
    private EnderecoRepository enderecoRepository;


    public void salvar(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public ResponseEntity<EnderecoDTO> alterar(Long id, EnderecoDTO form) {

        Optional<Endereco> optional = enderecoRepository.findById(id);
        if (optional.isPresent()) {
            Endereco endereco = form.atualizar(id, enderecoRepository);
            enderecoRepository.save(endereco);
            return ResponseEntity.ok(new EnderecoDTO(endereco));
        }

        return ResponseEntity.notFound().build();
    }


    public Endereco buscarPorId(Long id) {
        Optional<Endereco> optional = enderecoRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }

        return null;
    }


    public ResponseEntity<EnderecoDTO> detalhar(Long id) {
        Optional<Endereco> optional = enderecoRepository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(new EnderecoDTO(optional.get()));
        }

        return ResponseEntity.notFound().build();
    }


    public List<EnderecoDTO> listarTudoDTO() {
        List<Endereco> listaEndereco = enderecoRepository.findAll();
        return EnderecoDTO.converter(listaEndereco);
    }

    public Page<EnderecoDTO> listarTudoDTOPaginacao(Pageable paginacao) {
        //devolve um page ao invés de uma lista
        Page<Endereco> listaEndereco = enderecoRepository.findAll(paginacao);
        return EnderecoDTO.converterPaginacao(listaEndereco);
    }
}
