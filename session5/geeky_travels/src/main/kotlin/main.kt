import java.sql.*
import java.util.*

var offset = 0
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
    //bigger tag system: println("Hi, how would you like to find your travel destination? Based on 'MovieFranchise', 'country', 'Main activity','weather' or 'Main Character'")
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
        println("   Destination:"+ result2.getString("country"))
        println("   more specifically:"+ result2.getString("city"))
        println("   The price (in euro) for this destination is only:"+ result2.getString("price_in _euro"))
        println("   The weather in this period is generally "+ result2.getString("weather"))
        println("   you will be staying for "+ result2.getString("number_of_days") + " days")
        println("   the departure date is on "+ result2.getString("departure_date") + " and the return date on "+ result2.getString("departure_date") )
        println("   a median of the reviews for this destination has a result of " + result2.getString("review") +" out of 10")
    }

    //userInteraction 2---------------------------------------------------------
    println("type 'next' to see the next destination, type 'select' to choose this destination")
    nextPreviousOrSelect(connection, chosenCategory)
}

fun doNext (connection: Connection, chosenCategory: String?) {
    //----GET THE INFORMATION OF THE FIRST DESTINATION -------(where id > vorig id )-----------------------------------------------
    offset += 1
    val statement3 = connection.prepareStatement(
        "SELECT * FROM TravelInfo " +
                "WHERE Category = ? " +
                "LIMIT 1 OFFSET $offset"
    )
    // Replace the var (?) without allowing other (full) queries to be entered by adding ';'

    statement3.setString(1, chosenCategory)
    val result3 = statement3.executeQuery()

    while (result3.next()) {
        println("this is the next option:" + result3.getString("subcategory"))
        println("   Destination:" + result3.getString("country"))
        println("   more specifically:" + result3.getString("city"))
        println("   The price (in euro) for this destination is only:" + result3.getString("price_in _euro"))
        println("   The weather in this period is generally " + result3.getString("weather"))
        println("   you will be staying for " + result3.getString("number_of_days") + " days")
        println(
            "   the departure date is on " + result3.getString("departure_date") + " and the return date on " + result3.getString(
                "departure_date"
            )
        )
        println("   a median of the reviews for this destination has a result of " + result3.getString("review") + " out of 10")
    }

    //userInteraction 2---------------------------------------------------------
    println("type 'next' to see the next destination, type 'previous' to see the previous destination, type 'select' to choose this destination")
    nextPreviousOrSelect(connection, chosenCategory)
}

fun doPrevious (connection: Connection, chosenCategory: String?){
    //----GET THE INFORMATION OF THE FIRST DESTINATION -------(where id > vorig id )-----------------------------------------------
    offset -= 1
    val statement3 = connection.prepareStatement("SELECT * FROM TravelInfo " +
            "WHERE Category = ? " +
            "LIMIT 1 OFFSET $offset")
    // Replace the var (?) without allowing other (full) queries to be entered by adding ';'

    statement3.setString(1, chosenCategory)
    val result3 = statement3.executeQuery()

    while(result3.next()){
        println("this is the next option:" + result3.getString("subcategory"))
        println("   Destination:"+ result3.getString("country"))
        println("   more specifically:"+ result3.getString("city"))
        println("   The price (in euro) for this destination is only:"+ result3.getString("price_in _euro"))
        println("   The weather in this period is generally "+ result3.getString("weather"))
        println("   you will be staying for "+ result3.getString("number_of_days") + " days")
        println("   the departure date is on "+ result3.getString("departure_date") + " and the return date on "+ result3.getString("departure_date") )
        println("   a median of the reviews for this destination has a result of " + result3.getString("review") +" out of 10")
    }

    //userInteraction 2---------------------------------------------------------
    println("type 'next' to see the next destination, type 'previous' to see the previous destination, type 'select' to choose this destination")
    nextPreviousOrSelect(connection, chosenCategory)
}

fun doSelect(connection: Connection, chosenCategory: String?){
    println("to register for this trip we will need some of your information")
    println("are you sure you want to register? yes / no ")
    when (readLine()){
        "yes" -> println(" ok, let's go!")
        "no" -> { println("type 'next' to see the next destination, type 'previous' to see the previous destination, type 'select' to choose this destination")
            nextPreviousOrSelect(connection, chosenCategory)
        }
    }

    println("What is your name?")
    var name = readLine()
    println("what is your surname?")
    var surname =  readLine()
    println("what is your age?")
    var age = readLine()
    println("what is your email?")
    var email = readLine()
    println("what is your nationality?")
    var nationality = readLine()
    println("What is your id registration number?")
    var personid = readLine()


    val statement3 = connection.prepareStatement("SELECT * FROM TravelInfo " +
            "WHERE Category = ? " +
            "LIMIT 1 OFFSET $offset")
    // Replace the var (?) without allowing other (full) queries to be entered by adding ';'

    statement3.setString(1, chosenCategory)
    val result3 = statement3.executeQuery()

    while(result3.next()){
        val registration1 = Registration( personid, name, surname, age, nationality, email, result3.getString("id"), result3.getString("Category"), result3.getString("subcategory"), result3.getString("country"), result3.getString("city"),
            result3.getString("price_in _euro"), result3.getString("weather"), result3.getString("number_of_days"), result3.getString("review"),
            result3.getString("departure_date"),  result3.getString("return_date"),result3.getString("mode_of_transport"))
        println("Registration complete!")
    }

    println("type 'next' to see the next destination, type 'previous' to see the previous destination, type 'select' to choose this destination")
    nextPreviousOrSelect(connection, chosenCategory)
}

fun nextPreviousOrSelect(connection: Connection, chosenCategory: String?){
    when (readLine()){
        "next" -> {doNext(connection, chosenCategory)}
        "previous" -> {doPrevious(connection, chosenCategory)}
        "select" -> {doSelect(connection, chosenCategory)}
        else -> {println("please type: 'next', 'previous', or 'select'")
            nextPreviousOrSelect(connection, chosenCategory)
        }
    }
}
