/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewController;

import controller.ArquivoAtual;
import controller.Hash;
import dao.ReadWrite;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import model.Peca;

/**
 * FXML Controller class
 *
 * @author drico
 */
public class InserirDeletarController implements Initializable {

    @FXML
    private TextField tfId;
    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfPreco;
    @FXML
    private ComboBox<String> comBoxMarca;
    @FXML
    private ComboBox<String> comBoxModelo;
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

    private ObservableList<String> marcas;
    private ObservableList<String> modelos;
    private Hash hashPecas;
    private Peca[] pecas;
    private ReadWrite rw;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        rw = new ReadWrite();

        marcas = FXCollections.observableArrayList("AUDI", "BMW", "CHEVROLET", "FIAT", "FORD", "HONDA", "TOYOTA", "VOLKSWAGEN");
        comBoxMarca.setItems(marcas);

        if (ArquivoAtual.getHashAtual() != null) {
            hashPecas = ArquivoAtual.getHashAtual();
            pecas = hashPecas.getPecas();
            iniciaTablela(pecas);

        }

    }

    @FXML
    private void btnAtualizar(ActionEvent event) {
        
        if (validaCampos()) {

            atualizar();
        }
    }

    @FXML
    private void btnInserir(ActionEvent event) {

        if (validaCampos()) {

            inserir();
        }

    }

    @FXML
    private void btnDeletar(ActionEvent event) {

        if (!tfId.getText().equals("")) {
            Peca peca = tbPeca.getSelectionModel().getSelectedItem();
            hashPecas.remove(peca);
            ArquivoAtual.setHashAtual(hashPecas);
            pecas = hashPecas.getPecas();
                       
            rw.write(hashPecas, nomeArquivo());

            limparCampos();
            iniciaTablela(pecas);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um item");
        }
    }

    @FXML
    private void acaoCBMarca(ActionEvent event) {

        listarMdelo();

    }

    @FXML
    private void btnGravarTxt(ActionEvent event) {
    }

    @FXML
    private void btnSelecionar(ActionEvent event) {

        selecionarItem();
    }

    private void selecionarItem() {

        Peca peca = tbPeca.getSelectionModel().getSelectedItem();

        if (peca != null) {

            tfId.setText(String.valueOf(peca.getId()));
            tfPreco.setText(String.valueOf(peca.getPreco()));
            tfNome.setText(peca.getNome());
            comBoxMarca.setValue(peca.getMarca());
            comBoxModelo.setValue(peca.getModelo());

        } else {

            JOptionPane.showMessageDialog(null, "Seleciona um item");
        }

    }

    private boolean validaCampos() {

        if (!tfNome.getText().equals("")) {
            if (!comBoxMarca.getValue().equals("")) {
                if (!comBoxModelo.getValue().equals("")) {
                    if (!tfPreco.getText().equals("")) {

                        return true;
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um modelo");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma marca");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Digite um nome");
        }

        return false;
    }

    private void inserir() {

        ArquivoAtual.setPecas(rw.readVetor(ArquivoAtual.getNome()));
        
        Peca elemento = new Peca();
        elemento.setId(rw.getUltimoId()+1);
        elemento.setNome(tfNome.getText().toUpperCase());
        elemento.setMarca(comBoxMarca.getValue());
        elemento.setModelo(comBoxModelo.getValue());
        elemento.setPreco(Double.parseDouble(tfPreco.getText()));
        hashPecas.put(elemento);
        hashPecas.setNumeroElementos(hashPecas.getNumeroElementos() + 1);
        pecas = hashPecas.getPecas();
        ArquivoAtual.setHashAtual(hashPecas);
        ArquivoAtual.setPecas(pecas);
        rw.write(hashPecas, nomeArquivo());

        limparCampos();

        iniciaTablela(pecas);
    }
   
    private void atualizar() {

        Peca elemento = new Peca();
        elemento.setId(Integer.parseInt(tfId.getText()));
        elemento.setNome(tfNome.getText().toUpperCase());
        elemento.setMarca(comBoxMarca.getValue());
        elemento.setModelo(comBoxModelo.getValue());
        elemento.setPreco(Double.parseDouble(tfPreco.getText()));
        hashPecas.put(elemento);
        pecas = hashPecas.getPecas();
        ArquivoAtual.setHashAtual(hashPecas);
        ArquivoAtual.setPecas(pecas);
        rw.write(hashPecas, nomeArquivo());

        limparCampos();

        iniciaTablela(pecas);
    }

    private void limparCampos() {
        tfId.setText("");
        tfNome.setText("");
        tfPreco.setText("");
        comBoxMarca.setValue("");
        comBoxModelo.setValue("");

    }

    private void listarMdelo() {

        switch (comBoxMarca.getValue()) {
            case "AUDI":

                modelos = FXCollections.observableArrayList("A3", "A4", "TT", "R8", "RS8");
                comBoxModelo.setItems(modelos);
                break;

            case "BMW":

                modelos = FXCollections.observableArrayList("X1", "X3", "I8", "X7", "X8");
                comBoxModelo.setItems(modelos);
                break;

            case "CHEVROLET":

                modelos = FXCollections.observableArrayList("ONIX", "CORSA", "S10", "PRISMA", "MONZA", "CRUZE", "MONTANA");
                comBoxModelo.setItems(modelos);
                break;

            case "FIAT":

                modelos = FXCollections.observableArrayList("UNO", "DOBLO", "ARGO", "MOBI", "SIENA", "MAREA", "PALIO");
                comBoxModelo.setItems(modelos);
                break;

            case "FORD":

                modelos = FXCollections.observableArrayList("KA", "FUSION", "EDGE", "ECOSPORT", "CORCEL", "RANGER", "F250");
                comBoxModelo.setItems(modelos);
                break;

            case "HONDA":

                modelos = FXCollections.observableArrayList("CIVIC", "CR-V", "FIT", "ACCORD", "CITY", "WR-V");
                comBoxModelo.setItems(modelos);
                break;

            case "TOYOTA":

                modelos = FXCollections.observableArrayList("COROLLA", "CAMRY", "ETIOS", "YARIS", "PRIUS", "RAV4");
                comBoxModelo.setItems(modelos);
                break;

            case "VOLKSWAGEN":

                modelos = FXCollections.observableArrayList("GOL", "UP", "PARAT", "SANTANA", "PASSAT", "JETTA", "FOX", "VIRTUS");
                comBoxModelo.setItems(modelos);
                break;
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

    private String nomeArquivo() {

        String nome = ArquivoAtual.getNome();

        nome = nome.substring(0, nome.length() - 4);
       
        
        return nome;

    }

}
