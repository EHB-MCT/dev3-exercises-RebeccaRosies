import java.sql.*
import java.time.LocalDate
import java.util.*

fun main() {
    Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance()

    // haal klasse op maaar je hoeft niks mee te geven want zijn default settings
    val credentials = Credentials()
    val data = Data()

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

    val today = LocalDate.now()
    println(today)
    println("Hi! What city are you going to?")
    val destination = readLine()
    println("These are the first 3 trains leaving in the direction of $destination today ($today)")

    val statement = connection.prepareStatement("SELECT * FROM trains " +
            "INNER JOIN rides ON trains.id = train " +
            "WHERE destination_city = ? AND date ='$today'" +
            "ORDER BY departure_time ASC\n" +
            "LIMIT 3")



    // Replace the var (?) without allowing other (full) queries to be entered by adding ';'
    statement.setString(1, "'$destination'")
    val result = statement.executeQuery()

    while(result.next()){
        println("type:" + result.getString("type"))
        println("speed in km/h:" + result.getString("max_speed"))
        println("max passengers:" + result.getString("max_passengers"))
        println("date:" + result.getString("date"))
        println("departure time:" + result.getString("departure_time"))
        println("departure platform:" + result.getString("departure_Platform"))
        println("")
        // pas de data van de klasse Data aan aan de ingekomen data
        data.maxSpeed = result.getString("max_speed");
    }

    //controle of de variabelen zijn aangepast in de klasse
    var maxSpeed = data.maxSpeed
    println("your max speed is now $maxSpeed")


}

