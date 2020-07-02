/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewController;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author drico
 */
public class InicioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnTrabalho(ActionEvent event) throws IOException {

        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI("https://drive.google.com/file/d/1dMKPxERah1yiqLtjRY9vZsnpWKQkTGd3/view?usp=sharing"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void btnGit(ActionEvent event) throws IOException {

        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI("https://github.com/AdrianoGalan/TrabalhoEstruturaDeDados"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
