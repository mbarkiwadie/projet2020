/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AncienClientController implements Initializable {

    @FXML ComboBox cmbRechercher;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initialisation de la combobox rechercher client
       ObservableList list1 = FXCollections.observableArrayList("Carte fidelité","Tel","CIN");
       cmbRechercher.setItems(list1);
    }    
    
}
