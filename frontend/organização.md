Started: ⌛
To do: 📌
Done: ✅

📁 views
    - home ⌛
        // visualização dos produtos ativos - visão cliente
		// paginação
	- carrinho
		// onde ficam os produtos adicionados pelo cliente
    📁 produto ⌛
        - add-produto ✅
        ** Serviço: Get, Add, Edit e Delete
        - list-produto ✅ 
		- edit-produto 
		// delete --> inativar
    📁 endereco ⌛ (Amanda)
        - add-endereco
        ** Serviço: Get, Add e Delete  
        // ?? Método para buscar o id do cliente
    📁 cliente ⌛ (Rebeca)
        - add-cliente
        ** Serviço: Get, Add e Delete(inativa)
        - choose-cliente // Quem é o cliente? Antes de fazer a compra escolher qual é o cliente.
		// ?? Método para buscar o id do endereco
    - carrinho ⌛
		// Adicionar itens no carrinho
		// Editar a quantidade
		// Excluir
		// Desconto
		// Enviar a lista dos produtos para o backend
		// Prosseguir para fechar o pedido
    - pedido 📌
        - last-pedido
			// quem é o cliente ?
			// Puxar o último id do pedido
        - history-pedido
			// listar todos os pedidos
    📁 shared
        - footer ✅
        - navbar ✅
            // Configuração do cliente   // altera senha e e-mail
📁 models
    - produto ✅
    - endereco ✅
    - cliente ✅
    - itemPedido 📌 (?) // vamos mandar uma lista com os produtos para o backend
    - pedido 📌 (?)
📁 services
    - produto ⌛
    - endereco ✅
    - cliente ✅
	- itemPedido
    - pedido 📌 (?)