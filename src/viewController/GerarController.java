/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewController;

import controller.ArquivoAtual;
import dao.ReadWrite;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import modelTable.TableFie;
import util.GerarDadosEntrada;

/**
 * FXML Controller class
 *
 * @author drico
 */
public class GerarController implements Initializable {

    @FXML
    private TableView<TableFie> tbArquivos;
    @FXML
    private TableColumn<TableFie, String> tbNome;
    @FXML
    private TextField lbNElementos;
    @FXML
    private TextField lbNomeArquivo;
    @FXML
    private Button btnCarrega;
    @FXML
    private ProgressBar pBar;

 
    private ArrayList arquivos;
    private ReadWrite rw;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        rw = new ReadWrite();

        iniciaTablelaArquivos();

    }

    @FXML
    private void btnGerar(ActionEvent event) {

        pBar.setProgress(-1);
        gerarArquivo();
    }

    @FXML
    private void btnAtualizarLista(ActionEvent event) {

        iniciaTablelaArquivos();

    }

    @FXML
    private void btnDeletarArquivo(ActionEvent event) {

        TableFie arqSelecionado = tbArquivos.getSelectionModel().getSelectedItem();
        String nome = null;

        if (arqSelecionado != null) {
            nome = arqSelecionado.getNome();
            rw.deleteFine(nome);
            iniciaTablelaArquivos();

        } else {
            JOptionPane.showMessageDialog(null, "Seleciona um arquivo");
        }

    }

    @FXML
    private void btnAbrirArquivo(ActionEvent event) {

        abrirArquivo();
    }

    @FXML
    private void btnCarregaArquivo(ActionEvent event) {

        pBar.setProgress(-1);

        if (pBar.getProgress() == -1) {

            carrega();

        }
    }

    private void iniciaTablelaArquivos() {

        tbNome.setCellValueFactory(new PropertyValueFactory("nome"));

        tbArquivos.setItems(atualizaTabela());

    }

    private ObservableList<TableFie> atualizaTabela() {

        arquivos = rw.readDir("txt/");
        return FXCollections.observableArrayList(carregaTabela());
    }

    //carrega dados da tabela
    private ArrayList<TableFie> carregaTabela() {

        ArrayList<TableFie> tabelas = new ArrayList();

        for (int i = 0; i < arquivos.size(); i++) {

            TableFie tabela = new TableFie();

            tabela.setNome(arquivos.get(i).toString());

            tabelas.add(tabela);

        }

        return tabelas;
    }

    private void gerarArquivo() {

        GerarDadosEntrada gerador = new GerarDadosEntrada();

        try {
            if (!lbNElementos.getText().equalsIgnoreCase("")) {
                if (!lbNomeArquivo.getText().equalsIgnoreCase("")) {

                    int nElementos = Integer.parseInt(lbNElementos.getText());

                    rw.write(gerador.gerarDados(nElementos), lbNomeArquivo.getText());
                    iniciaTablelaArquivos();
                    pBar.setProgress(1);
                    lbNElementos.setText("");
                    lbNomeArquivo.setText("");
                    JOptionPane.showMessageDialog(null, "Arquivo gerado");

                } else {
                    JOptionPane.showMessageDialog(null, "Digite o nome do arquivo");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Digite o numero de elementos");
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "o nomero de elemento deve ser inteiro");
        }
    }

    private void carrega() {

        TableFie arqSelecionado = tbArquivos.getSelectionModel().getSelectedItem();
        String nome;

        if (arqSelecionado != null) {

            long inicio = System.currentTimeMillis();

            nome = arqSelecionado.getNome();

            ArquivoAtual.setHashAtual(rw.readHash(nome));
            ArquivoAtual.setPecas(rw.readVetor(nome));
            pBar.setProgress(1);
            ArquivoAtual.setNome(nome);

            rw.writeReport("Carregar Arquivo", ArquivoAtual.getHashAtual().getNumeroElementos(), System.currentTimeMillis() - inicio);

            JOptionPane.showMessageDialog(null, "Arquivo carregado");

        } else {
            JOptionPane.showMessageDialog(null, "Seleciona um arquivo");
        }

    }

    private void abrirArquivo() {

        TableFie arqSelecionado = tbArquivos.getSelectionModel().getSelectedItem();
        String nome;

        try {

            if (arqSelecionado != null) {
                nome = arqSelecionado.getNome();

                rw.openFile(nome, "txt/");

                iniciaTablelaArquivos();

            } else {
                JOptionPane.showMessageDialog(null, "Seleciona um arquivo");
            }
        } catch (IOException ex) {
            Logger.getLogger(GerarController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
