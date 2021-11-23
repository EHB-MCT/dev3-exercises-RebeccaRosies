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

    println("Hi! What city are you going to?")
    val destination = readLine()
    println("This is the first train leaving in the direction of $destination")

    val statement = connection.prepareStatement("SELECT * FROM trains " +
            "INNER JOIN rides ON trains.id = train " +
            "WHERE destination_city = '$destination'" +
            "ORDER BY date ASC\n, departure_time ASC\n" +
            "LIMIT 1")

    // Replace the var without allowing full queries to be entered
    val result = statement.executeQuery()
    while(result.next()){
        println("type:" + result.getString("type"))
        println("speed in km/h:" + result.getString("max_speed"))
        println("max passengers:" + result.getString("max_passengers"))
        println("date:" + result.getString("date"))
        println("departure time:" + result.getString("departure_time"))
    }

}

