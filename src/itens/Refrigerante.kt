package itens

class Refrigerante:Item {
    override fun getCode(): String {
        return "003"
    }

    override fun getName(): String {
        return "Refrigerante"
    }

    override fun getValue(): Double {
        return 8.0
    }
}