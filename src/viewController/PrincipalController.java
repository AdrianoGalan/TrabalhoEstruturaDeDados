/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewController;

import controller.ArquivoAtual;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author drico
 */
public class PrincipalController implements Initializable {

    @FXML
    private Button btnMenuGerar;
    @FXML
    private Pane paneTrabalho;
    @FXML
    private Label lbArquivoAtual;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ArquivoAtual.setNome("Selecione um arquivo");

        KeyFrame frame = new KeyFrame(Duration.millis(1000), e -> atualizaArquivo());
        Timeline timeline = new Timeline(frame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        
        carregaTela("/view/Inicio.fxml");

    }

    @FXML
    private void menuGerar(ActionEvent event) {

        carregaTela("/view/Gerar.fxml");
    }

    @FXML
    private void btnBID(ActionEvent event) {

        carregaTela("/view/Busca.fxml");
    }
    
    @FXML
    private void btnOrdenar(ActionEvent event) {
        
        carregaTela("/view/Ordenar.fxml");
    }
    
     @FXML
    private void btnInserirDeletar(ActionEvent event) {
        
        carregaTela("/view/InserirDeletar.fxml");
    }

    @FXML
    private void btnRelatorio(ActionEvent event) {
    }

    @FXML
    private void btnVerCod(ActionEvent event) {
    }
    
     @FXML
    private void btnInicio(ActionEvent event) {
        
        carregaTela("/view/Inicio.fxml");
    }

    public void carregaTela(String nomeTela) {

        //carrega tela
        AnchorPane a;
        try {
            a = (AnchorPane) FXMLLoader.load(getClass().getResource(nomeTela));

            AnchorPane.setTopAnchor(a, 0.0);
            AnchorPane.setLeftAnchor(a, 0.0);
            AnchorPane.setRightAnchor(a, 0.0);
            AnchorPane.setBottomAnchor(a, 0.0);

            paneTrabalho.getChildren().setAll(a);
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Label getLbArquivoAtual() {
        return lbArquivoAtual;
    }

    public void setLbArquivoAtual(Label lbArquivoAtual) {
        this.lbArquivoAtual = lbArquivoAtual;
    }

    private void atualizaArquivo() {
        lbArquivoAtual.setText(ArquivoAtual.getNome());
    }

   

   

    

}
