class Duolingo (
    val roundSize: Int = 5,
    var Language: String = "english"
        ){
    val e_hallo = EnglishWord("hallo", "hello")
    val e_naam = EnglishWord("naam", "name")
    val e_huis = EnglishWord("huis", "house")
    val e_tuin = EnglishWord( "tuin", "garden")
    val e_strand = EnglishWord( "strand", "beach")
    val e_zee = EnglishWord("zee", "sea")
    val e_zomer = EnglishWord("zomer", "summer")
    val e_lente = EnglishWord( "lente", "spring")
    val e_spel = EnglishWord ("spel", "game")
    val e_feest = EnglishWord ("feest","party")

    val f_hallo = FrenchWord("hallo", "bonjour")
    val f_naam = FrenchWord("naam", "nom")
    val f_huis = FrenchWord("huis", "maison")
    val f_tuin = FrenchWord( "tuin", "jardin")
    val f_strand = FrenchWord( "strand", "plage")
    val f_zee = FrenchWord("zee", "mer")
    val f_zomer = FrenchWord("zomer", "l'été")
    val f_lente = FrenchWord( "lente", "printemps")
    val f_spel = FrenchWord ("spel", "jeu")
    val f_feest = FrenchWord ("feest","fete")

    var words = mutableListOf<Word>(e_hallo,e_naam, e_huis, e_tuin, e_strand, e_zee, e_zomer, e_lente, e_spel, e_feest, f_hallo, f_naam, f_huis, f_tuin, f_strand, f_zee, f_zomer, f_lente, f_spel, f_feest,)

    init{
        words = words.filter{ it.language == Language }.toMutableList()
    }

    fun play(){
       // val filteredWords = words.filter{ it.language == Language }

        // get an array of 5 random words
        val numberOfWords = roundSize
        var randomElements = words.asSequence().shuffled().take(numberOfWords).toMutableList()
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
                    }
                else -> {
                    var amountLeft = (randomElements.count())
                    println("that was wrong")
                    println("the right answer is ${currentWord.translated}")
                    println("don't worry, you get to try again later :) there's now still $amountLeft left")
                }
            }
        }
        println("you're done, good job!")
    }
}