class WordDeck
{
    var originalWords = mutableSetOf<Word>(
        EnglishWord( "suiker", "sugar"),
        EnglishWord("boter", "butter"),
        EnglishWord("melk", "milk"),
        EnglishWord( "kaas", "cheese"),
        EnglishWord( "ham", "ham"),
        EnglishWord("vis", "fish"),
        EnglishWord("soep", "soup"),
        EnglishWord( "banaan", "banana"),
        EnglishWord ("appel", "apple"),
        EnglishWord ("peer","pear"),

        FrenchWord("suiker", "sucre"),
        FrenchWord("boter", "beurre"),
        FrenchWord("melk", "lait"),
        FrenchWord( "kaas", "fromage"),
        FrenchWord( "ham", "jambon"),
        FrenchWord("vis", "poisson"),
        FrenchWord("soep", "soupe"),
        FrenchWord( "banaan", "banane"),
        FrenchWord ("appel", "pomme"),
        FrenchWord ("peer","poire")
    )
    var words = originalWords

    fun filterByLanguage(language: String){
        words = words.filter {it.language == language}.toMutableSet()
    }

    fun reset(){
        words = originalWords
    }

}