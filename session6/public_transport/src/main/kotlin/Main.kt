import java.sql.*
import java.util.*

fun main() {
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

    println("succes!")


    val statement = connection.prepareStatement("SELECT * FROM trains")
    // Replace the var without allowing full queries to be entered
    val result = statement.executeQuery()
    while(result.next()){
        println(result.getString("id"))
        println(result.getString("type"))
        println(result.getString("max_speed"))
        println(result.getString("max_passengers"))
    }

}

