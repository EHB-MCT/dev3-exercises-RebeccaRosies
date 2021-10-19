import kotlin.random.Random

var Timmie = Person("Timmie")
var Marie =  Person("Marie")

var people = arrayOf(Timmie,Marie)

var randomPerson = people.random()
fun main(){
    println(randomPerson.introduce())}