package totem

import MenuOpcao
import Pedido

class Totem {
    private val pedido = Pedido()

    init {
        showMenuPrincipal()
    }

    private fun showMenuPrincipal(){
        while (true) {
            println("Qual opcão vc quer comprar")
            println("[1] Lanche")
            println("[2] Bebida")
            println("[0] Sair ")
            val opc = readln().toIntOrNull()
            when (opc) {
                1 -> {
                    showMenuComida()
                    return
                }
                2 -> {
                    return showMenuBebida()
                }
                0 -> {
                    pedido.showItens()
                    println("Pedido cancelado!")
                    return
                }
                else -> {
                    println("Opção inválida, tente novamente!")
                }
            }
        }
    }

    private fun showMenuComida(){
        while (true) {
            println("Qual opção de Lanche")
            println("[1] X-Burguer R$ 10,00")
            println("[2] X-Salada RS 12,00")
            println("[0] Sair")
            val opc = readln().toIntOrNull()
            when (opc) {
                1 -> {
                    solicitaPedido(MenuOpcao.XBurguerOpcao)
                    return
                }
                2 -> {
                    solicitaPedido(MenuOpcao.XSaladaOpcao)
                    return
                }
                0 -> {
                    pedido.showItens()
                    println("Pedido cancelado!")
                    return
                }
                else -> {
                    println("Opção inválida, tente novamente!")
                }
            }
        }
    }

    private fun showMenuBebida(){
        while (true) {
            println("Qual opção de Bebida")
            println("[1] Refrigerante R$ 8,00")
            println("[2] Suco RS 6,00")
            println("[0] Sair")
            val opc = readln().toIntOrNull()
            when (opc) {
                1 -> {
                    solicitaPedido(MenuOpcao.RefrigeranteOpcao)
                    return
                }
                2 -> {
                    solicitaPedido(MenuOpcao.SucoOpcao)
                    return
                }
                0 -> {
                    pedido.showItens()
                    println("Pedido cancelado!")
                    return
                }
                else -> {
                    println("Opção inválida, tente novamente!")
                }
            }
        }
    }

    private fun solicitaPedido(menuOpcao : MenuOpcao){
        val qtd = getQtd()
        pedido.adicionarItem(menuOpcao, qtd)
        showMenuFinal()
    }

    private fun showMenuFinal(){
        while (true) {
            println("Selecione a opçao desejada")
            println("[1] Comprar mais itens")
            println("[2] Editar itens")
            println("[3] Remover itens")
            println("[4] Finalizar pedido")
            println("[0] Sair")
            val opc = readln().toIntOrNull()
            when(opc){
                1 -> {
                    showMenuPrincipal()
                    return
                }
                2 -> {
                    editarItens()
                }
                3 -> {
                    removerItens()
                }
                4 -> {
                    pedido.showItens()
                    pedido.showTotalValues()
                    showOpcoesPagamento()
                    return
                }
                0 -> {
                    pedido.showItens()
                    println("Pedido cancelado!")
                    return
                }
                else -> {
                    println("Opção inválida, tente novamente!")
                }
            }
        }
    }

    private fun removerItens() {
        while (true) {
            println("Digite o código do produto")
            val cod = readln()
            val item = MenuOpcao.getMenuOpcaoByCod(cod)
            if (item == null) {
                println("Código do produto inválido")
                continue
            }
            pedido.removerItem(item)
            return
        }
    }

    private fun editarItens() {
        while (true) {
            println("Digite o código do produto")
            val cod = readln()
            val item = MenuOpcao.getMenuOpcaoByCod(cod)
            if (item == null) {
                println("Código do produto inválido")
                continue
            }
            val qtd = getQtd()
            pedido.editarItem(item, qtd)
            return
        }
    }
    private fun getQtd(): Int{
        while(true){
            println("Digite a quantidade do produto")
            val qtd = readln().toIntOrNull()?:-1
            if(qtd < 0){
                println("Quantidade inválida")
                continue
            }
            return qtd
        }
    }

    private fun showOpcoesPagamento(){
        while (true) {
            println("Selecione a opçao de pagamento")
            println("[1] cartão de crédito")
            println("[2] cartão de débito")
            println("[3] vale alimentação")
            println("[4] dinheiro")
            val opc = readln().toIntOrNull()
            when(opc){
                1 , 2 , 3 -> {
                    println("Compra finalizada com sucesso, boa refeição")
                    return
                }
                4 -> {
                    pagamentoDinheiro()
                    println("Compra finalizada com sucesso, boa refeição")
                    return
                }
                else -> {
                    println("Opção inválida")
                }
            }
        }

    }

    private fun pagamentoDinheiro(){
        while (true){
            println("Digite o valor do pagamento em dinheiro")
            val dinheiro = readln().toDoubleOrNull()
            if (dinheiro == null) {
                println("Valor inválido")
                continue
            }
            val totalPedido = pedido.getValorTotal()
            if (dinheiro < totalPedido){
                println("Valor insuficiente para pagamento")
                continue
            }
            val troco = dinheiro - totalPedido
            println("Valor troco R$ $troco")
            return
        }
    }
}