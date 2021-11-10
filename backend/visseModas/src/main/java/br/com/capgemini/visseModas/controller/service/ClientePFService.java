
package br.com.capgemini.visseModas.controller.service;

import br.com.capgemini.visseModas.model.entity.ClientePF;
import br.com.capgemini.visseModas.model.repository.ClientePFRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class ClienteServicePF {

    private ClientePFRepository repository;


    public void salvar(ClientePF clientePF) {
        repository.save(clientePF);
    }

    private void atualizar(Scanner scan) {
        System.out.println("Digite o ID que deseja alterar");
        int id = scan.nextInt();

        System.out.println("Descrição do Cargo");
        String descricao = scan.next();

        Cargo cargo = new Cargo();

        cargo.setId(id);
        cargo.setDescricao(descricao);

        cargoRepository.save(cargo);
        System.out.println("Cargo Atualizado!");
    }

    public Categoria alterar(@PathVariable Long id, @RequestBody Categoria categoria){

        //recebe do banco de dados
        Optional<Categoria> categoriaBuscada = repository.findById(id);

        if(!categoriaBuscada.isPresent()){
            return null;
        }

        //converte o Option
        Categoria categoriaNew = categoriaBuscada.get();
        categoriaNew.setDescricao(categoria.getDescricao());
        repository.save(categoriaNew);

        System.out.println(categoria);

        return categoria;

    }

    //    @PutMapping("/{id}")
//    public void merge(@PathVariable Long id, @RequestBody Categoria categoria){
//        Categoria categoriaPesquisada = repository.getOne(id);
//        if(categoriaPesquisada != null){
//            categoriaPesquisada.setDataCadastro(categoria.getDataCadastro());
//            repository.save(categoriaPesquisada);
//        }
//
//    }



//    private void visualizar() {
//        Iterable<Cargo> cargos = cargoRepository.findAll();
//        cargos.forEach(cargo -> System.out.println(cargo));
//
//    }

    //    @GetMapping //find
    //    public List<Categoria> listarTudo(){
    //        return repository.findAll();
    //    }

    //find com DTO

/*   public List<ClienteDTO> listarTudo(){
        List<ClientePF> listaClientesPF = repository.findAll();
        return ClienteDTO.converter(listaClientesPF);
    }*//*



    private void deletar(Long id) {
        repository.deleteById(id);
    }










}
*/
