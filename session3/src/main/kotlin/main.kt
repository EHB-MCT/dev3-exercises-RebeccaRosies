fun main(){
    val design1 = Course(
        "design 1",
        1,
        5,
        "Je maakt in dit opleidingsonderdeel kennis met de basisprincipes van grafische vormgeving: typografie, kleur, beeld, compositie en de werkprocessen van een grafisch vormgever. We leren deze principes toepassen en maken daarvoor gebruik van de software uit de professionele wereld (Adobe Illustrator en Photoshop).",
        "Maaike Beutens",
        1,
        "Design",
        true)

    val development1 = Course(
        "development",
        1,
        5,
        "Je leert procedureel programmeren met behulp van Javascript. Door gebruik te maken van de grafische mogelijkheden van HTML 5 Canvas leer je op een visuele en intuïtieve manier programmeren. Alle basisconcepten van programmeren komen aan bod: variabelen en objecten, functies en methodes, variatie door middel van iteratiestructuren en selectiestructuren, events en lijst-structuren. Met behulp van de aangeleerde vaardigheden genereer je abstracte afbeeldingen en interactieve animaties.",
        "Peter Dickx",
        1,
        "Development",
        true
    )


    val dries = Hero("Dries")
    val jens = Villain ("Jens")
    val matthias = Villain ("Matthias")

    dries.talk()
    jens.talk()
    matthias.talk()
    jens.eat()


}