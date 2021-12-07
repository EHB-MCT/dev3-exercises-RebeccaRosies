class Duolingo {

    //second constructor
    var roundSize: Int = 5
    var language: String = "english"

    constructor(
    roundSize: Int = 5,
    language: String = "english"
    ){
        this.roundSize = roundSize
        this.language = language
    }

    //first constructor
    var level: String = "easy"
    constructor(
    level: String = "easy"
    ){
        this.level = level

        if (level != "easy" && level != "hard" && level != null){
            throw Exception ("assign difficulty as 'easy' or 'hard'")}
    }

    val wordDeck = WordDeck()
    
    init{
        wordDeck.filterByLanguage(language)

    }

    fun play(){
       // val filteredWords = words.filter{ it.language == Language }

        // get an array of 5 random words
        val numberOfWords = roundSize
        var randomElements = wordDeck.words.asSequence().shuffled().take(numberOfWords).toMutableList()
        println("let's start learning!")
        var i = randomElements.count()

        // like a foreach loop but still adjustable in size
        while (randomElements.isNotEmpty()) {
            val currentWord  = randomElements.random()
            println("translate the following word to ${currentWord.language}")
            println(currentWord.original)
            var studentTranslation = readln()



            when (studentTranslation) {
                "${currentWord.translated}" ->
                    {   randomElements.remove(currentWord)
                        var amountLeft = (randomElements.count())
                        println("good job! only  $amountLeft left")

                        currentWord.difficulty -= 1

                        println("the current difficulty of this word is:" + currentWord.difficulty)
                    }
                else -> {
                    var amountLeft = (randomElements.count())
                    println("that was wrong")
                    println("the right answer is ${currentWord.translated}")
                    println("don't worry, you get to try again later :) there's now still $amountLeft left")

                    currentWord.difficulty += 2
                    println("the current difficulty of this word is:" + currentWord.difficulty)
                }
            }
        }
        println("you're done, good job!")
    }
}