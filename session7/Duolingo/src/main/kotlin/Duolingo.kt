class Duolingo {
    val e_hallo = Word("hallo", "hello", "english")
    val e_naam = Word("naam", "name", "english" )
    val e_huis = Word("huis", "house", "english")
    val e_tuin = Word( "tuin", "garden", "english")
    val e_strand = Word( "strand", "beach", "english")
    val e_zee = Word("zee", "sea", "english")
    val e_zomer = Word("zomer", "summer", "english")
    val e_lente = Word( "lente", "spring", "english")
    val e_spel = Word ("spel", "game", "english")
    val e_feest = Word ("feest","party", "english")

    val f_hallo = Word("hallo", "bonjour", "francais")
    val f_naam = Word("naam", "nom", "francais")
    val f_huis = Word("huis", "maison", "francais")
    val f_tuin = Word( "tuin", "jardin", "francais")
    val f_strand = Word( "strand", "plage", "francais")
    val f_zee = Word("zee", "mer", "francais")
    val f_zomer = Word("zomer", "l'été", "francais")
    val f_lente = Word( "lente", "printemps", "francais")
    val f_spel = Word ("spel", "jeu", "francais")
    val f_feest = Word ("feest","fete", "francais")

    var words = mutableListOf<Word>(e_hallo,e_naam, e_huis, e_tuin, e_strand, e_zee, e_zomer, e_lente, e_spel, e_feest, f_hallo, f_naam, f_huis, f_tuin, f_strand, f_zee, f_zomer, f_lente, f_spel, f_feest,)


    fun play(){
        val numberOfWords = 5
        var randomElements = words.asSequence().shuffled().take(numberOfWords).toMutableList()
        println("let's start learning!")
        var i = randomElements.count()

        while (i != 0) {
            i -= 1
            println("translate the following word to ${randomElements[i].language}")
            println(randomElements[i].original)
            var studentTranslation = readln()

            var amountLeft = (i)

            when (studentTranslation) {
                "${randomElements[i].translated}" -> println("good job! only  $amountLeft left")
                else -> {
                    randomElements.add(randomElements[i])
                    println("that was wrong")
                    println("the right answer is ${randomElements[i].translated}")
                    i += 1
                    amountLeft = (i)
                    println("don't worry, you get to try again at the end :) there's now still $amountLeft left")
                }
            }
        }


        var remaining = randomElements.remove(randomElements[0])








    }
}