class Student(override var name: String): Person(name){
    override fun talk(){
        gossip()
    }

    fun gossip(){
        println("I want to gossip")
    }
}