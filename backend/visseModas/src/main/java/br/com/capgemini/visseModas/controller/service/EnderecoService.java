package main.java.br.com.capgemini.visseModas.controller.service;

import br.com.capgemini.visseModas.model.repository.EnderecoRepository;
import main.java.br.com.capgemini.visseModas.model.dto.EnderecoDTO;
import main.java.br.com.capgemini.visseModas.model.entity.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired // injeção de dependência
    private EnderecoRepository repository;

    public void salvar(Endereco endereco) {
        repository.save(endereco);
    }

    private void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<Endereco> listarTudo() {
        return repository.findAll();
    }

    // com DTO
    public List<EnderecoDTO> listarTudoDTO() {
        List<Endereco> listaEndereco = repository.findAll();
        return EnderecoDTO.converter(listaEndereco);
    }

    public Endereco alterar(Long id) {
        Optional<Endereco> enderecoBuscado = repository.findById(id);
        if (!enderecoBuscado.isPresent()) {
            return null;
        }
        Endereco endereco = enderecoBuscado.get();
        Endereco enderecoNovo = new Endereco();

        enderecoNovo.setCep(endereco.getCep());
        enderecoNovo.setCidade(endereco.getCidade());
        enderecoNovo.setBairro(endereco.getBairro());
        enderecoNovo.setRua(endereco.getRua());
        repository.save(endereco);
        return endereco;
    }

}
