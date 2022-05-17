import itens.*

class Pedido {
    private val listaItens = mutableMapOf<MenuOpcao, Int>()

    fun adicionarItem(menuOpcao: MenuOpcao, moreQtd : Int){
        val qtd = listaItens[menuOpcao] ?:0
        listaItens[menuOpcao] = qtd+moreQtd
        showItens()
    }

    fun editarItem(menuOpcao: MenuOpcao , qtd: Int){
        listaItens[menuOpcao] = qtd
        showItens()
    }

    fun removerItem(menuOpcao: MenuOpcao){
        listaItens[menuOpcao] = 0
        showItens()
    }

    fun showItens(){
        println("------ SimCity Fastfood ------")
        listaItens.forEach {
            if (it.value > 0){
                val code = it.key.item.getCode()
                val qtd = it.value
                val name = it.key.item.getName()
                val totalValue = qtd * it.key.item.getValue()
                println("$code - $qtd $name - $totalValue")
            }
        }
    }

    fun showTotalValues() {
        println("Valor total do pedido R$ ${getValorTotal()}")
    }

    fun getValorTotal(): Double {
        var totalValues = 0.0
        listaItens.forEach {
            val qtd = it.value
            val valor = it.key.item.getValue()
            val totalItem = qtd*valor
            totalValues += totalItem
        }
        return totalValues
    }

}
enum class MenuOpcao(val item: Item) {

    XBurguerOpcao(XBurguer()), XSaladaOpcao(XSalada()), RefrigeranteOpcao(Refrigerante()), SucoOpcao(Suco());

    companion object{
        fun getMenuOpcaoByCod(cod: String):MenuOpcao?{
            return values().firstOrNull { it.item.getCode() == cod }

        }
    }
}