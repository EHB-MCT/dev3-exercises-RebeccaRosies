class Teacher(override var name: String): Person(name), ChatPartner {
    override fun talk(){
        funFact()
    }

    fun funFact(){
        println("did you you kotlin was named after an island")
    }
}
