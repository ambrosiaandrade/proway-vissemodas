package br.com.capgemini.visseModas.controller;

import br.com.capgemini.visseModas.controller.service.ClienteService;
import br.com.capgemini.visseModas.controller.service.EnderecoService;
import br.com.capgemini.visseModas.model.dtoEntrada.ClienteDTOEntrada;
import br.com.capgemini.visseModas.model.dtoEntrada.EnderecoDTOEntrada;
import br.com.capgemini.visseModas.model.dtoSaida.ClienteDTOSaida;
import br.com.capgemini.visseModas.model.dtoSaida.EnderecoDTOSaida;
import br.com.capgemini.visseModas.model.entity.Cliente;
import br.com.capgemini.visseModas.model.entity.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map.Entry;

@RestController
@RequestMapping("/endereco")
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


