import kotlin.random.Random
fun main(){
    var noor = Student("Noor")
    var maaike = Teacher("Maaike")
    var bob = Comedian( "Bob")
    var clippy = Chatbot()

    var people = arrayOf(noor, maaike, bob, clippy)

    var chatPartner = people.random()

    chatPartner.introduce()
    chatPartner.talk()
}