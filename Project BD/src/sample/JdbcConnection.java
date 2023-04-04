package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcConnection{
    private static final Logger LOGGER = Logger.getLogger(JdbcConnection.class.getName());

    private static Optional<Connection> connection = Optional.empty();

    public static Optional<Connection> getConnection(){
        if(connection.isEmpty()){
            String dbType = "jdbc:postgresql:";
            String dbUrl = "//localhost:";
            String dbPort = "5432/";
            String dbName = "Project_BD";
            String dbUser = "postgres";
            String dbPass = "bieber94";

            try{
                connection = Optional.ofNullable(DriverManager.getConnection(dbType+dbUrl+dbPort+dbName,dbUser,dbPass));
                if(connection != null){
                    System.out.println("Connection OK!");
                }
                else{
                    System.out.println("Connection Failed!");
                }
            }
            catch (SQLException ex){
                LOGGER.log(Level.SEVERE,null,ex);
            }
        }
        return connection;
    }
}
