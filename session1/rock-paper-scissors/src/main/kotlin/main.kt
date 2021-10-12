fun main(){
    println("Make your choice:")
    var userchoice = userChooses()

    println("The computer chose:")
    var options = arrayOf("rock", "paper", "scissors")
    var computerchoice = options[(0..2).random()]
    println(computerchoice)

   message(userchoice, computerchoice)
}

fun userChooses(userchoice:String?){
    val userchoice = readLine()
    println("You have entered this: $userchoice")
    return userchoice:String?
}

fun message (x:String,y:String){
    if (userchoice == computerchoice){
        println("it's a tie!")
        return
    }}
