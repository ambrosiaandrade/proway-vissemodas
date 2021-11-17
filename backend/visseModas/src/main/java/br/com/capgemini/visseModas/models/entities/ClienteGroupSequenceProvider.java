package br.com.capgemini.visseModas.models.entities;

import br.com.capgemini.visseModas.models.dtos.form.ClienteForm;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class ClienteGroupSequenceProvider implements DefaultGroupSequenceProvider<ClienteForm> {

    @Override
    public List<Class<?>> getValidationGroups(ClienteForm clienteForm) {
        List<Class<?>> groups = new ArrayList<>();
        groups.add(ClienteForm.class);

        if(isPessoaSelecionada(clienteForm)){
            groups.add(clienteForm.getTipoCliente().getGroup());
        }
        return groups;
    }

    protected boolean isPessoaSelecionada(ClienteForm clienteForm){
        return clienteForm != null && clienteForm.getTipoCliente()!= null;
    }

}
