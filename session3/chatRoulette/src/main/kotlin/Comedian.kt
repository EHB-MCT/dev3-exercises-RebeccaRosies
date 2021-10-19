class Comedian(override var name: String): Person(name) {
    override fun talk(){
        joke()
    }

    fun joke(){
        println("joke")
    }
}
