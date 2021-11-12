package br.com.capgemini.visseModas.controller;

import br.com.capgemini.visseModas.controller.service.ClienteService;
import br.com.capgemini.visseModas.model.dtoEntrada.ClienteDTOEntrada;
import br.com.capgemini.visseModas.model.dtoSaida.ClienteDTOSaida;
import br.com.capgemini.visseModas.model.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<ClienteDTOSaida> listarTudo() {
        return service.listarTudoDTO();
    }

    @PostMapping
    public void salvar(@RequestBody ClienteDTOEntrada clienteDTO) {

          //converte o DTO para Cliente
          Cliente cliente = clienteDTO.dtoToCliente();
          service.salvar(cliente);
    }

    @DeleteMapping("/{id}") //delete
    public void deletar(@PathVariable Long id) {
        service.inativar(id);
    }

    @PatchMapping("/{id}") //merge
    public Cliente alterar(@PathVariable Long id, @RequestBody ClienteDTOSaida clienteDTO) {

//        //converte o DTO para Cliente
//        Cliente cliente = clienteDTO.dtoToCliente();

        Cliente clienteAlterado = service.alterar(id);
        return clienteAlterado;

    }





}


