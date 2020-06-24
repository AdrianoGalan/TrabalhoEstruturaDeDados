/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewController;

import controller.ArquivoAtual;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author drico
 */
public class BuscaController implements Initializable {

    @FXML
    private TextField tfBusca;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnBusca(ActionEvent event) {
        
        
        System.out.println(ArquivoAtual.getHashAtual().search(tfBusca.getText()));
//        System.out.println(ArquivoAtual.getPecas()[3].getNome());
        
    }
    
}
