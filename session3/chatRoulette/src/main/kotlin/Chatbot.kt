class Chatbot (val name: String): Person(name){
    fun talk(){
        println("hi, my name is $name")
    }
}