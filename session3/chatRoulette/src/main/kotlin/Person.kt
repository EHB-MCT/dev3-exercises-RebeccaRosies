open class Person(internal open var name:String) {
    fun introduce() {
        println("hi, my name is $name")
    }
    open fun talk (){
       println("I'm a random person")
    }


}