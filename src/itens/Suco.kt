package itens

class Suco: Item {
    override fun getCode(): String {
        return "004"
    }

    override fun getName(): String {
        return "Suco"
    }

    override fun getValue(): Double {
        return 6.0
    }

}