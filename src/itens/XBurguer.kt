package itens

class XBurguer: Item {
    override fun getCode(): String {
        return "001"
    }

    override fun getName(): String {
        return "X-Burguer"
    }

    override fun getValue(): Double {
        return 10.0
    }


}