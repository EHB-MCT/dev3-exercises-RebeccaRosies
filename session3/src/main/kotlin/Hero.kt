class Hero(override val name: String):Person(name) {
    fun talk(){
        println("How can I help you?")
    }
}