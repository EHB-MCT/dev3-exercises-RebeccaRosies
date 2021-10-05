fun main(){
    println("Make your choice:")
    val userchoice = readLine()
    println("You have entered this: $userchoice")

    println("The computer chose:")
    var options = arrayOf("Rock", "Paper", "Scissors")
    var computerchoice = options[(0..2).random()]
    println(computerchoice)

    
}