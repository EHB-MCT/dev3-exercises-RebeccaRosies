class Comedian(override var name: String): Person(name),ChatPartner {
    override fun talk(){
        joke()
    }

    fun joke(){
        println("joke")
    }
}
