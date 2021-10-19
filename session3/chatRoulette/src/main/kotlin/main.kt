import kotlin.random.Random
fun main(){
    var Noor = Student("Noor")
    var Maaike = Teacher("Maaike")
    var Bob = Comedian( "Bob")

    var people = arrayOf(Noor, Maaike, Bob)

    var chatPartner = people.random()

    chatPartner.introduce()
    chatPartner.talk()
}