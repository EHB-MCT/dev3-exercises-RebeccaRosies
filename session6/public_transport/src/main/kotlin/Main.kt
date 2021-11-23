import java.sql.*
import java.util.*
import Credentials.*

fun main() {
    Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance()

    // Create the connection: this will allow us to run queries on it later
    val connection =  DriverManager.getConnection(
        "jdbc:" + "mysql" + "://" +
                "your host" +
                ":" + "3306 (this is your port, this is de default)" + "/" +
                Credentials.databaseName,
        connectionProps)
}
