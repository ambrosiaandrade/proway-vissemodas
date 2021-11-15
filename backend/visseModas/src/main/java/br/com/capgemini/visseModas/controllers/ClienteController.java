package br.com.capgemini.visseModas.controllers;

import br.com.capgemini.visseModas.services.ClienteService;
import br.com.capgemini.visseModas.models.dtos.form.ClienteForm;
import br.com.capgemini.visseModas.models.dtos.dtos.ClienteDTOSaida;
import br.com.capgemini.visseModas.models.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes") //TODO paths plural OK
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<ClienteDTOSaida> listarTudo() {
        return service.listarTudoDTO();
    }

//    @PostMapping
//    public void salvar(@RequestBody ClienteForm ClienteDTOSaida) {
//
//          //converte o DTO para Cliente
//          Cliente cliente = clienteDTO.dtoToCliente();
//          service.salvar(cliente);
//    }

    @DeleteMapping("/{id}") //delete
    public void deletar(@PathVariable Long id) {
        service.inativar(id);
    }

    @PatchMapping("/{id}") //merge
    public void alterar(@PathVariable Long id, @RequestBody ClienteDTOSaida clienteDTOSaida) {

        //converte o DTO para Cliente
        //Cliente cliente = clienteDTOSaida.dtoToCliente();
       // cliente.setId(id);
        //service.alterar(cliente);
    }





}


