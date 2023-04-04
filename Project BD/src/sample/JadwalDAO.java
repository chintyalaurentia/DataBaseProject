package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JadwalDAO implements DAO<Jadwal, String>{
    private static final Logger LOGGER = Logger.getLogger(JadwalDAO.class.getName());

    private final Optional<Connection> connection;
    private static JdbcConnection con;

    public JadwalDAO(){
        this.connection = con.getConnection();
    }


    public Collection<Jadwal> getAll() {
        ObservableList<Jadwal> customers = FXCollections.observableArrayList();
        String sql = "SELECT * FROM jadwal j JOIN nama_dokter d ON j.id_dokter = d.id_dokter";

        connection.ifPresent(conn ->{
            try (Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                while (resultSet.next()) {
                    String name = resultSet.getString("nama_dokter");


                    Jadwal jadwal = new Jadwal(name);

                    customers.add(jadwal);

                    LOGGER.log(Level.INFO, "Found {0} in database", jadwal);
                }

            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        });
        return customers;

    }

//    public Collection<Jadwal> getDokter() {
//        Collection<Jadwal> dokter = new ArrayList<>();
//        ObservableList dr = FXCollections.observableArrayList();
//        String sql = "SELECT nama_dokter FROM jadwal j JOIN nama_dokter d ON j.id_dokter = d.id_dokter";
//
//        connection.ifPresent(conn ->{
//            try (Statement statement = conn.createStatement();
//                 ResultSet resultSet = statement.executeQuery(sql)) {
//
//
//                while (resultSet.next()) {
//                    dr.add(new String(resultSet.getString(1)));
//
//
//                    LOGGER.log(Level.INFO, "Found {0} in database", dr);
//                }
//
//            } catch (SQLException ex) {
//                LOGGER.log(Level.SEVERE, null, ex);
//            }
//        });
//        return dr;
//    }


}
