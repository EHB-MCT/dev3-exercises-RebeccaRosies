class Villain(override val name: String):Person(name) {
    fun talk(){
        println("Muhahaha")
    }
}