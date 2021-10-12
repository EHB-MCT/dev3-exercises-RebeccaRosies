fun main (){
    println("It's january 1st 2022, the Zombie apocalypse has just begun. Will you be able to survive?")
    challengeOne()
}

fun challengeOne() {
    println("How many times per week did you work out on average in 2021?")
    var numberOfWorkouts = readLine()?.toInt()
    val notEnoughWorkouts = setOf(0,1)
    if (notEnoughWorkouts.contains(numberOfWorkouts)){
        println("sorry, you're dead")
    } else  {
        println("congrats you might survive")
        challengeTwo()
    }
}

fun challengeTwo(){
    println("You and a stranger are running from the zombies. You manage to hide for a bit. Will you stick together or will you go your separate ways ")
    println("You aren't sure and roll the dice on it. Choose low or high. if your guess matches the dice you'll stick together")
    var Challenge2Guess = readLine()
    rollDice(Challenge2Guess)
}

fun rollDice(Challenge2Guess:String?){
    val randomNumber = (1..6).random()
    val dice = "";
    when(randomNumber){
        1 -> {println("you rolled 1")
            dice == "low" }
        2 -> {println("you rolled 2")
            dice == "low" }
        3 -> {println("you rolled 3")
            dice == "low" }
        4 -> {println("you rolled 4")
            dice == "high" }
        5 -> {println("you rolled 5")
            dice == "high" }
        6 -> {println("you rolled 6")
            dice == "high" } }

    if (dice == Challenge2Guess ){
        println("you chose to stick together")
        println("congrats you might survive")
        challengeThree()
    } else {
        println("you chose to go your separate ways")
        println("sorry, you're dead")
    }
}

fun challengeThree(){
    println("You pass by a hardware store. Choose a weapon!")
    var weaponChoice = readLine()
    println("You chose a $weaponChoice")
    if(weaponChoice!!.length()<4){
        println("you the moment you reach for the $weaponChoice a zombie emerges and starts to chase you")
        challengeTwo()
    } else if (weaponChoice!!.length()>5 ){
        println("you take the $weaponChoice when a zombie emerges. Luckily you manage to kill it with your $weaponChoice")
    }   else {
        println("you reach for the $weaponChoice but a zombie emerges and eats your brains")
        println("sorry you're dead")

    }
}