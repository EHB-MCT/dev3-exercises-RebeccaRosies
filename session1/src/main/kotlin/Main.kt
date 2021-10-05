fun main(){
    var students = arrayOf("Liese", "Britt", "Jasmien", "Hannelore", "Jens")

    for (student in students){
        printStudent(student)
    }
    println("hello world")
}

fun printStudent (name:String){
    println( "Hello $name!")
}