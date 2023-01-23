
package mg;

import com.wadiembarki.database.DB;
import com.wadiembarki.models.Client;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javax.swing.JOptionPane;


public class ListeClientController implements Initializable
{

    @FXML private TableView <Client> table;
    @FXML private TableColumn<Client, Integer> numCarte;
     @FXML private TableColumn<Client, String> prenom;
     @FXML private TableColumn<Client, String> nom;
     @FXML private TableColumn<Client, Integer> cin;
     @FXML private TableColumn<Client, Integer> tel;
     @FXML private TableColumn<Client, String> mail;
     @FXML private TableColumn<Client, String> profession;
      @FXML private TableColumn<Client, String> dateNaissance;
      @FXML private TableColumn<Client, String> adresse;
     @FXML private TableColumn<Client, String> date_Entree;
     @FXML private TableColumn<Client, Double> montantAchat;
     @FXML private TableColumn<Client, Integer> points_Merci;
     
     public ObservableList<Client> data = FXCollections.observableArrayList();
     @FXML
     public void viewData()
     {
         try {
             Connection con = DB.connect();
             String sql = "SELECT *FROM client";
             PreparedStatement stat = con.prepareStatement(sql);
             ResultSet rs = stat.executeQuery();
             while(rs.next())
             {
                 data.add(new Client(
                         rs.getInt(1),
                         rs.getString(2), 
                         rs.getString(3), 
                         rs.getInt(4), 
                         rs.getInt(5), 
                         rs.getString(6), 
                         rs.getString(7),  
                         rs.getString(8),
                         rs.getString(9),  
                         rs.getString(10),
                         rs.getDouble(11),
                         rs.getInt(12)));
             }
             con.close();
         } catch (Exception e) {
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Erreur");
         }
         
       //  numCarte.setCellValueFactory(new PropertyValueFactory<Client, Integer>("numCarte"));
         prenom.setCellValueFactory(new PropertyValueFactory<Client, String>("prenom"));
         nom.setCellValueFactory(new PropertyValueFactory<Client, String>("nom"));
         cin.setCellValueFactory(new PropertyValueFactory<Client, Integer>("cin"));
         tel.setCellValueFactory(new PropertyValueFactory<Client, Integer>("tel"));
         mail.setCellValueFactory(new PropertyValueFactory<Client, String>("mail"));
         profession.setCellValueFactory(new PropertyValueFactory<Client, String>("profession"));
         dateNaissance.setCellValueFactory(new PropertyValueFactory<Client, String>("dateNaissance"));
         adresse.setCellValueFactory(new PropertyValueFactory<Client, String>("adresse"));
         date_Entree.setCellValueFactory(new PropertyValueFactory<Client, String>("date_Entree"));
         montantAchat.setCellValueFactory(new PropertyValueFactory<Client, Double>("montantAchat"));
         points_Merci.setCellValueFactory(new PropertyValueFactory<Client, Integer>("points_Merci"));
         
         table.setItems(data);
         
     }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
       
    }    
    
}
