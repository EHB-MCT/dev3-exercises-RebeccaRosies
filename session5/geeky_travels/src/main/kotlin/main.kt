import java.sql.*
import java.util.*

fun main(){
    // Create a driver: the library/class that will create the connection
    Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance()

    // haal klasse op maaar je hoeft niks mee te geven want zijn default settings
    val credentials = Credentials()

    // Prepare credentials
    val connectionProps = Properties()
    connectionProps["user"] = credentials.databaseUser
    connectionProps["password"] = credentials.databasePassword

    // Create the connection: this will allow us to run queries on it later
    val connection =  DriverManager.getConnection(
        "jdbc:" + "mysql" + "://" +
                "dt5.ehb.be" +
                ":" + "3306" + "/" +
                credentials.databaseName,
        connectionProps)

    //userInteraction---------------------------------------------------------
    println("Hi!, Choose one of the following categories: Disney - Pixar - The Lord of the Rings - Narnia - Pirates of the Caribbean")
    val chosenCategory = readLine()

    //-----GET THE NUMBER OF SUBCATEGORIES ----------------------------------------------------------------------
    val statement = connection.prepareStatement("SELECT Category, subcategory FROM TravelInfo " +
            "WHERE Category = ? ")
    // Replace the var (?) without allowing other (full) queries to be entered by adding ';'
    statement.setString(1, chosenCategory)
    val result = statement.executeQuery()

    val resultList: MutableList<String> = ArrayList()

    // Show results -------------------------------------------
    var count = 0
    while(result.next()){
        resultList.add(result.getString("subcategory"))
        count = resultList.count()
    }
    println(count)

    println("There are $count travel destinations for this category")
    //----GET THE INFORMATION OF THE FIRST DESTINATION ------------------------------------------------------
    val statement2 = connection.prepareStatement("SELECT * FROM TravelInfo " +
            "WHERE Category = ? " +
            "LIMIT 1")
    // Replace the var (?) without allowing other (full) queries to be entered by adding ';'
    statement2.setString(1, chosenCategory)
    val result2 = statement2.executeQuery()

    while(result2.next()){
        println("this is the first option:" + result2.getString("subcategory"))
        println("Destination:"+ result2.getString("country"))
        println("more specifically:"+ result2.getString("city"))
        println("The price (in euro) for this destination is only:"+ result2.getString("price_in _euro"))
        println("The weather in this period is generally "+ result2.getString("weather"))
        println("you will be staying for "+ result2.getString("number_of_days") + " days")
        println("the departure date is on "+ result2.getString("departure_date") + " and the return date on "+ result2.getString("departure_date") )
        println("a median of the reviews for this destination has a result of " + result2.getString("review") +" out of 10")
    }
    
    //userInteraction 2---------------------------------------------------------
    println("type 'next' to see the next destination, type 'previous' to see the previous destination, type 'select' to choose this destination")
    when (readLine()){
            "next" -> println("do next")
            "previous" -> println("do previous")
            "select" -> println("do select")
            else -> println("please type: 'next', 'previous', or 'select'")
    }

}