fun main (){
    println("It's january 1st 2022, the Zombie apocalypse has just begun. Will you be able to survive?")
    challengeOne()
}

fun challengeOne() {
    println("How many times per week did you work out on average in 2021?")
    var numberOfWorkouts = readLine()
    val notEnoughWorkouts = setOf("one", "zero", "none", "once")
    if (notEnoughWorkouts.contains(numberOfWorkouts)){
        println("sorry, you're dead")
    } else  {
        println("congrats you survive")
    }
}
