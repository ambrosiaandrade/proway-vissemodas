package br.com.capgemini.visseModas.controllers;

import br.com.capgemini.visseModas.services.EnderecoService;
import br.com.capgemini.visseModas.models.dtos.form.EnderecoDTOEntrada;
import br.com.capgemini.visseModas.models.dtos.dtos.EnderecoDTOSaida;
import br.com.capgemini.visseModas.models.entities.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping
    public List<EnderecoDTOSaida> listarTudo() {
        return service.listarTudoDTO();
    }

    @PostMapping
    public void salvar(@RequestBody EnderecoDTOEntrada enderecoDTO) {

          //converte o DTO para Cliente
          Endereco endereco = enderecoDTO.dtoToEndereco();
          service.salvar(endereco);
    }

    @DeleteMapping("/{id}") //delete
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @PatchMapping("/{id}") //merge
    public void alterar(@PathVariable Long id, @RequestBody EnderecoDTOSaida enderecoDTOSaida) {

        //converte o DTO para Cliente
        Endereco endereco = enderecoDTOSaida.dtoToEndereco();
        endereco.setId(id);
        service.alterar(endereco);




    }





}


