/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg;

import com.wadiembarki.Utils.FxmlLoader;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Wadie Mbarki
 */
public class MenuController implements Initializable {
    @FXML BorderPane menuPane;
    @FXML  MenuItem nouveauClient;
    @FXML  MenuItem listeClient;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   //  heureCourante();
   //  dateCourante();
    // agent();
    } 
     @FXML Label lblDate;
     @FXML Label lblHeure;
     @FXML Label lblAgent;
     
      @FXML
     public void heureCourante()
       {
          Thread clock = new Thread(){
              public void run(){
                  for(;;){
                      Calendar cal = new GregorianCalendar();
                      int seconde = cal.get(Calendar.SECOND);
                      int minute = cal.get(Calendar.MINUTE);
                      int heure = cal.get(Calendar.HOUR);
                      lblHeure.setText("Heure : "+heure+" : "+minute+" : "+seconde);
                      try {
                          sleep(1000);
                      } catch (InterruptedException e) {
                         e.getMessage();
                      }
                  }
              }
          }; 
          clock.start();
       }
     
     @FXML
    public void dateCourante() {
        Thread clock = new Thread() {
            public void run() {
                for (;;) {
                    Calendar cal = new GregorianCalendar();
                    int jour = cal.get(Calendar.DAY_OF_MONTH);
                    int mois = cal.get(Calendar.MONTH);
                    int annee = cal.get(Calendar.YEAR);
                    lblDate.setText("Date : " + jour + " / " + (mois+1) + " / " + annee);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.getMessage();
                    }
                }
            }
        };
        clock.start();
    }
    /*
    @FXML
    public void agent()
    {
       LoginController log = new LoginController();
       String name;
        name = log.txtUserName.getText();
        lblAgent.setText("Agent : "+name);
    }
    */
   @FXML
      private void nClient(ActionEvent event)
      {
          FxmlLoader object = new FxmlLoader();
          Pane view = object.getPage("NouveauClient");
          menuPane.setCenter(view);
      }
   
     @FXML
      private void listeClient(ActionEvent event)
      {
          FxmlLoader object = new FxmlLoader();
          Pane view = object.getPage("ListeClient");
          menuPane.setCenter(view);
      }         
     
      
}
