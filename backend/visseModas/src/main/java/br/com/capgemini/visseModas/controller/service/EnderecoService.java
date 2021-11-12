package br.com.capgemini.visseModas.controller.service;

import br.com.capgemini.visseModas.model.dtoSaida.EnderecoDTOSaida;
import br.com.capgemini.visseModas.model.entity.Cliente;
import br.com.capgemini.visseModas.model.entity.Endereco;
import br.com.capgemini.visseModas.model.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired // injeção de dependência
    private EnderecoRepository repository;

    public void salvar(Endereco endereco) {
        repository.save(endereco);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }


    public List<EnderecoDTOSaida> listarTudoDTO() {
        List<Endereco> listaEndereco = repository.findAll();
        return EnderecoDTOSaida.converter(listaEndereco);
    }

    public Endereco alterar(Endereco endereco) {

        //recebe do banco de dados
        Endereco enderecoPesquisado = repository.findById(endereco.getId()).get();

        if (enderecoPesquisado != null) {
            enderecoPesquisado.setRua(endereco.getRua());
            enderecoPesquisado.setBairro(endereco.getBairro());
            enderecoPesquisado.setCidade(endereco.getCidade());
            enderecoPesquisado.setCep(endereco.getCep());

            repository.save(enderecoPesquisado);
        }

        return enderecoPesquisado;
    }










}
