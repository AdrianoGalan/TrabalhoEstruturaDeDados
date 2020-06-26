/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewController;

import controller.ArquivoAtual;
import controller.Busca;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import model.Peca;

/**
 * FXML Controller class
 *
 * @author drico
 */
public class BuscaController implements Initializable {

    @FXML
    private TextField tfBusca;
    @FXML
    private TextField tfReturnHash;
    @FXML
    private TextField tfTempOrdHash;
    @FXML
    private TextField tfTempBuscaHash;
    @FXML
    private ProgressBar pbHash;
    @FXML
    private ProgressBar pbDinamica;
    @FXML
    private TextField tfTempBuscaLinear;
    @FXML
    private TextField tfTempOrdLinear;
    @FXML
    private TextField tfReturnLinear;
    @FXML
    private TextField tfReturnBinaria;
    @FXML
    private TextField tfTempOrdBinaria;
    @FXML
    private TextField tfTempBuscaBinaria;
    @FXML
    private ProgressBar pbBinaria;
    private double i = 0;
    private Busca busca;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        busca = new Busca();

    }

    @FXML
    private void btnBusca(ActionEvent event) {

        pbHash.setProgress(-1);
        pbDinamica.setProgress(-1);
        pbBinaria.setProgress(-1);

        int id;

        String nome = tfBusca.getText();

        if (validaTfBusca()) {

            try {
                id = Integer.parseInt(nome);

                buscaHash(id);
                buscaLinear(id);
                buscaBinaria(id);

            } catch (Exception e) {

                buscaHash(nome);
                buscaLinear(nome);
                buscaBinaria(nome);

            }

        }
    }

    private void buscaHash(String nome) {

        Peca peca = ArquivoAtual.getHashAtual().search(nome);
        tfTempOrdHash.setText("0");
        tfTempBuscaHash.setText(String.valueOf(ArquivoAtual.getHashAtual().getTempoBusca()));
        pbHash.setProgress(1);

        if (peca != null) {

            tfReturnHash.setText(peca.toString());

        } else {
            tfReturnHash.setText("valor não encontrado");
        }
    }

    private void buscaHash(int id) {
        
         Peca peca = ArquivoAtual.getHashAtual().search(id);
        tfTempOrdHash.setText("0");
        tfTempBuscaHash.setText(String.valueOf(ArquivoAtual.getHashAtual().getTempoBusca()));
        pbHash.setProgress(1);

        if (peca != null) {

            tfReturnHash.setText(peca.toString());

        } else {
            tfReturnHash.setText("valor não encontrado");
        }

    }

    private void buscaLinear(String nome) {

        Peca peca = busca.buscaLinear(ArquivoAtual.getPecas(), nome);

        tfTempOrdLinear.setText("0");
        tfTempBuscaLinear.setText(String.valueOf((busca.getTempoBusca())));
        pbDinamica.setProgress(1);

        if (peca != null) {

            tfReturnLinear.setText(peca.toString());

        } else {
            tfReturnLinear.setText("valor não encontrado");
        }

    }
    
    private void buscaLinear(int id) {

        Peca peca = busca.buscaLinear(ArquivoAtual.getPecas(), id);

        tfTempOrdLinear.setText("0");
        tfTempBuscaLinear.setText(String.valueOf((busca.getTempoBusca())));
        pbDinamica.setProgress(1);

        if (peca != null) {

            tfReturnLinear.setText(peca.toString());

        } else {
            tfReturnLinear.setText("valor não encontrado");
        }

    }

    private void buscaBinaria(String nome) {

        Peca peca = busca.buscaBinaria(ArquivoAtual.getPecas(), nome);

        tfTempBuscaBinaria.setText(String.valueOf(busca.getTempoBusca()));
        tfTempOrdBinaria.setText(String.valueOf(busca.getTempoOrdenar()));
        pbBinaria.setProgress(1);

        if (peca != null) {
            tfReturnBinaria.setText(peca.toString());

        } else {

            tfReturnBinaria.setText("valor não encontrado");

        }

    }
    
    private void buscaBinaria(int id) {

        Peca peca = busca.buscaBinaria(ArquivoAtual.getPecas(), id);

        tfTempBuscaBinaria.setText(String.valueOf(busca.getTempoBusca()));
        tfTempOrdBinaria.setText(String.valueOf(busca.getTempoOrdenar()));
        pbBinaria.setProgress(1);

        if (peca != null) {
            tfReturnBinaria.setText(peca.toString());

        } else {

            tfReturnBinaria.setText("valor não encontrado");

        }

    }

    private boolean validaTfBusca() {

        if (ArquivoAtual.getHashAtual() != null) {
            if (!tfBusca.getText().equalsIgnoreCase("")) {

                return true;

            } else {

                JOptionPane.showMessageDialog(null, "Digite um nome ou id");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Carregar um arquivo");
        }

        return false;
    }

}
