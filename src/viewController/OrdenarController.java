/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewController;

import controller.ArquivoAtual;
import controller.Ordenar;
import dao.ReadWrite;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import model.Peca;

/**
 * FXML Controller class
 *
 * @author drico
 */
public class OrdenarController implements Initializable {

    @FXML
    private TextField tfTempBublle;
    @FXML
    private TextField tfTempSelection;
    @FXML
    private TextField tfTempInsertion;
    @FXML
    private TextField tfTempQuick;
    @FXML
    private TableView<Peca> tbPeca;
    @FXML
    private TableColumn<Peca, Integer> tbPecaId;
    @FXML
    private TableColumn<Peca, String> tbPecaNome;
    @FXML
    private TableColumn<Peca, String> tbPecaMarca;
    @FXML
    private TableColumn<Peca, String> tbPecaModelo;
    @FXML
    private TableColumn<Peca, Double> tbPecaPreco;
    @FXML
    private RadioButton radioNome;
    @FXML
    private RadioButton radioId;
    @FXML
    private ToggleGroup radio;

    private Peca[] pecas;
    private Ordenar ordena;
    private ReadWrite rw;

    @FXML
    private TextField tfNomeArquivo;
    @FXML
    private TextField tfTempMerge;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        rw = new ReadWrite();

        pecas = rw.readVetor(ArquivoAtual.getNome());
        ordena = new Ordenar();

        if (pecas != null) {
            iniciaTablela(pecas);
        }

    }

    @FXML
    private void btnOrdenarBubble(ActionEvent event) {

        if (pecas != null) {
            tfTempBublle.setText("");
            if (radioNome.isSelected()) {
                pecas = ordena.bubbleSortNome(pecas);
            } else {
                pecas = ordena.bubbleSortId(pecas);
            }
            iniciaTablela(pecas);
            tfTempBublle.setText(String.valueOf(ordena.getTempoOrdenar()));
            rw.writeReport("Ordena Bubble Sort", ArquivoAtual.getHashAtual().getNumeroElementos(), ordena.getTempoOrdenar());
        }

    }

    @FXML
    private void btnOrdenarSelection(ActionEvent event) {

        if (pecas != null) {
            tfTempSelection.setText("");
            if (radioNome.isSelected()) {
                pecas = ordena.selectionSortNome(pecas);
            } else {
                pecas = ordena.selectionSortId(pecas);
            }
            iniciaTablela(pecas);
            tfTempSelection.setText(String.valueOf(ordena.getTempoOrdenar()));
            rw.writeReport("Ordena Selection Sort", ArquivoAtual.getHashAtual().getNumeroElementos(), ordena.getTempoOrdenar());

        }

    }

    @FXML
    private void btnOrdenarInsertion(ActionEvent event) {

        if (pecas != null) {
            tfTempInsertion.setText("");
            if (radioNome.isSelected()) {
                pecas = ordena.insertionSortName(pecas);
            } else {
                pecas = ordena.insertionSortId(pecas);
            }
            iniciaTablela(pecas);
            tfTempInsertion.setText(String.valueOf(ordena.getTempoOrdenar()));
            rw.writeReport("Ordena Insertion Sort", ArquivoAtual.getHashAtual().getNumeroElementos(), ordena.getTempoOrdenar());
        }
    }

    @FXML
    private void btnOrdenarMerge(ActionEvent event) {

        long temp, inicio = System.currentTimeMillis();

        if (pecas != null) {
            tfTempMerge.setText("");
            if (radioNome.isSelected()) {
                pecas = ordena.mergeSortByName(pecas);
            } else {
                pecas = ordena.mergeSortById(pecas);
            }
            iniciaTablela(pecas);
            temp = System.currentTimeMillis() - inicio;
            tfTempMerge.setText(String.valueOf(temp));
            rw.writeReport("Ordena Merge Sort", ArquivoAtual.getHashAtual().getNumeroElementos(), temp);
        }

    }

    @FXML
    private void btnOrdenarQuick(ActionEvent event) {

        long inicio, temp;

        if (pecas != null) {
            tfTempQuick.setText("");
            if (radioNome.isSelected()) {
                pecas = rw.readVetor(ArquivoAtual.getNome());
                inicio = System.currentTimeMillis();
                pecas = ordena.quickSort(pecas, 0, (pecas.length - 1), 0);
            } else {
                pecas = rw.readVetor(ArquivoAtual.getNome());
                pecas = ordena.quickSort(pecas, 0, (pecas.length - 1), 0);
                inicio = System.currentTimeMillis();
                pecas = ordena.quickSort(pecas, 0, (pecas.length - 1), 1);
            }
            iniciaTablela(pecas);
            temp = System.currentTimeMillis() - inicio;
            tfTempQuick.setText(String.valueOf(temp));
            rw.writeReport("Ordena Quick Sort", ArquivoAtual.getHashAtual().getNumeroElementos(), temp);
        }

    }

    @FXML
    private void btnSalvar(ActionEvent event) {

        if (!tfNomeArquivo.getText().equals("")) {

            rw.write(pecas, tfNomeArquivo.getText());
            tfNomeArquivo.setText("");
            JOptionPane.showMessageDialog(null, "arquivo salvo");

        } else {
            JOptionPane.showMessageDialog(null, "Digite o nome do arquivo");
        }
    }

    @FXML
    private void btnRestTabela(ActionEvent event) {

        if (pecas != null) {
            pecas = rw.readVetor(ArquivoAtual.getNome());
            iniciaTablela(pecas);
        }

    }

    private void iniciaTablela(Peca[] pecasTable) {

        tbPecaId.setCellValueFactory(new PropertyValueFactory("id"));
        tbPecaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        tbPecaMarca.setCellValueFactory(new PropertyValueFactory("marca"));
        tbPecaModelo.setCellValueFactory(new PropertyValueFactory("modelo"));
        tbPecaPreco.setCellValueFactory(new PropertyValueFactory("preco"));

        tbPeca.setItems(atualizaTabela(pecasTable));

    }

    private ObservableList<Peca> atualizaTabela(Peca[] pecasTable) {

        return FXCollections.observableArrayList(carregaTabela(pecasTable));
    }

    //carrega dados da tabela
    private ArrayList<Peca> carregaTabela(Peca[] pecasTable) {

        ArrayList<Peca> tabelas = new ArrayList();

        for (int i = 0; i < pecasTable.length; i++) {

            if (pecasTable[i] != null) {
                Peca tabela = new Peca();
                tabela.setId(pecasTable[i].getId());
                tabela.setNome(pecasTable[i].getNome());
                tabela.setMarca(pecasTable[i].getMarca());
                tabela.setModelo(pecasTable[i].getModelo());
                tabela.setPreco(pecasTable[i].getPreco());
                tabelas.add(tabela);
            }

        }

        return tabelas;
    }

}
