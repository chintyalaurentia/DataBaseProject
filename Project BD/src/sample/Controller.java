package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Initializable {
    @FXML
    private ComboBox<Jadwal> dokter;

    @FXML
    private ComboBox<?> tgl;

    @FXML
    private ComboBox<?> jam;

    private static final DAO<Jadwal, String> cust = new JadwalDAO();

    void viewAllRecord() {
        // Set all data from getAll into ObservableList<Customer>
        dokter.setItems(cust.getAll());
        dokter.setItems(customers);
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Jadwal> list = FXCollections.observableArrayList();
        dokter.setItems(list);
    }

}
