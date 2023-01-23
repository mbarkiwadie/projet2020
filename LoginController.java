/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg;

import com.wadiembarki.database.DB;
import com.wadiembarki.models.Admin;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author Wadie Mbarki
 */
public class LoginController implements Initializable {
    @FXML
    Image image = new Image("/images/exitt.jpg");
    ImageView im = new ImageView(image);
    @FXML
    private void quitter()
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure, You want to exit?");
        alert.getButtonTypes().removeAll(ButtonType.CANCEL, ButtonType.OK);
        ButtonType btnCancel = new ButtonType("NO");
        ButtonType btnOk = new ButtonType("YES");
        alert.getButtonTypes().addAll(btnCancel, btnOk);
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == btnOk)
        {
           Platform.exit();
        }
    }
    
    @FXML TextField txtUserName;
    @FXML PasswordField password;
    @FXML Label lblStatus;
    @FXML Label lblDB;
    @FXML
    private void login(ActionEvent event) throws SQLException, IOException
    {
        if(txtUserName.getText().matches("[a-zA-Z0-9_]{4,}"))
        {
          lblStatus.setText("le nom ou le mot de passe est incorrect");
        }
          if(txtUserName.getText().isEmpty() || password.getText().isEmpty())
        {
            lblStatus.setText("Veuillez remplir tous les champs");
        }
          int status = DB.statusDB(txtUserName.getText().trim().toLowerCase(), password.getText());
         switch(status)
         {
             case 0:
             {
                 lblDB.setText("connected"); 
                 Stage stage = (Stage) txtUserName.getScene().getWindow();

                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.setScene(new Scene(root));
                 
             }
             break;
             
             case -1 :
             {
                 lblDB.setText("disconnected");
             }
             break;
             
             case  1:
             {
                 lblDB.setText("connected");
                 lblStatus.setText("le nom ou le mot de passe est incorrect");
             }
             break;
         }

    }  
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
