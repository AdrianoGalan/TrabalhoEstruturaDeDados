/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewController;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import modelTable.TableFie;

/**
 * FXML Controller class
 *
 * @author drico
 */
public class CodigoController implements Initializable {

    @FXML
    private TableView<TableFie> tbArquivos;
    @FXML
    private TableColumn<TableFie, String> tbNome;

    private ReadWrite rw;
    private ArrayList arquivos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        rw = new ReadWrite();
        iniciaTablelaArquivos();

    }

    @FXML
    private void btnAbrirArquivo(ActionEvent event) {

        abrirArquivo();
    }

    private void iniciaTablelaArquivos() {

        tbNome.setCellValueFactory(new PropertyValueFactory("nome"));

        tbArquivos.setItems(atualizaTabela());

    }

    private ObservableList<TableFie> atualizaTabela() {

        arquivos = rw.readDir("codigos/");
        return FXCollections.observableArrayList(carregaTabela());
    }

    //carrega dados da tabela
    private ArrayList<TableFie> carregaTabela() {

        ArrayList<TableFie> tabelas = new ArrayList();

        for (int i = 0; i < arquivos.size(); i++) {

            TableFie tabela = new TableFie();

            //  tabela.setNome(arquivos.get(i).toString());
            tabela.setNome(nomeArquivo(arquivos.get(i).toString()));

            tabelas.add(tabela);

        }

        return tabelas;
    }

    private void abrirArquivo() {

        TableFie arqSelecionado = tbArquivos.getSelectionModel().getSelectedItem();
        String nome;

        try {

            if (arqSelecionado != null) {
                nome = arqSelecionado.getNome();

                rw.openFile(nome + ".txt", "codigos/");

                iniciaTablelaArquivos();

            } else {
                JOptionPane.showMessageDialog(null, "Seleciona um arquivo");
            }
        } catch (IOException ex) {
            Logger.getLogger(GerarController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String nomeArquivo(String nome) {

        nome = nome.substring(0, nome.length() - 4);

        return nome;

    }

}
