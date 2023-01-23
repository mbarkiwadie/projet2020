
package mg;

import com.wadiembarki.database.DB;
import com.wadiembarki.models.Client;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class NouveauClientController implements Initializable {

     @FXML TextField txtnumCarte;
     @FXML TextField txtprenom;
     @FXML TextField txtnom;
     @FXML TextField txtcin;
     @FXML TextField txttel;
     @FXML TextField txtmail;
     @FXML TextField txtprofession;
     @FXML DatePicker txtnaissance;
     @FXML TextField txtadresse;
    @FXML
    private void valider(ActionEvent event)
    {
       LocalDate dateBirt = txtnaissance.getValue();
         String numCarte = txtnumCarte.getText();
         String prenom = txtprenom.getText();
         String nom = txtnom.getText();
         String cin = txtcin.getText();
         String tel = txttel.getText();
         String mail = txtmail.getText();
         String profession = txtprofession.getText();
         String dateNaissance = ((TextField) txtnaissance.getEditor()).getText();
         String adresse = txtadresse.getText();
         
         Client client = new Client();
         client.setNumCarte(0);
         client.setPrenom(prenom);
         client.setNom(nom);
         client.setCin(0);
         client.setTel(0);
         client.setMail(mail);
         client.setProfession(profession);
         client.setDateNaissance(dateNaissance);
         client.setAdresse(adresse);
          
         int status = DB.save(client);
         if(status > 0)
         {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Ajout client");
             alert.setHeaderText("information");
             alert.setContentText("Succes de l'ajout du client");
             alert.showAndWait();
             txtnumCarte.clear();
     txtprenom.clear();
     txtnom.clear();
     txtcin.clear();
     txttel.clear();
     txtmail.clear();
     txtprofession.clear();
     txtnaissance.setValue(null);
     txtadresse.clear();
          }
         else
         {
             Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setTitle("Ajout client");
             alert.setHeaderText("information");
             alert.setContentText("Echec de l'ajout du client");
             alert.showAndWait(); 
         }
       
    }
    public void vider()
    {
     txtnumCarte.clear();
     txtprenom.clear();
     txtnom.clear();
     txtcin.clear();
     txttel.clear();
     txtmail.clear();
     txtprofession.clear();
     txtnaissance.setValue(null);
     txtadresse.clear();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
    
}
