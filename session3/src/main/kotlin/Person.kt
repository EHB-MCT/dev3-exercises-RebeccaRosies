open abstract class Person (open val name: String) {
    open fun eat(){
        println("want to go for lunch with me?")
    }
}