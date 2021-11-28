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

    //------------------------------------------------------------------------
    // put queries in here
    val statement = connection.prepareStatement("SELECT * FROM TravelInfo " +
            "WHERE Category = ? ")
    // Replace the var (?) without allowing other (full) queries to be entered by adding ';'
    statement.setString(1, chosenCategory)
    val result = statement.executeQuery()

    // Show results -----------------------------------------------------------
    while(result.next()){
        println("type:" + result.getString("subcategory"))
    }





}