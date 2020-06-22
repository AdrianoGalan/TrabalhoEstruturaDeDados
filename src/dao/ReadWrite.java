package dao;

import controller.EstruturaDianmica;
import controller.Hash;
import controller.No;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Peca;

public class ReadWrite {


    //escreve Pessoa arquivo txt
    public void write(EstruturaDianmica objetoGravar, String nomeArquivo) {

       // File file = new File(ENTRADA_DADOS);

        BufferedWriter writer;

        try {

           // file.createNewFile();

            writer = new BufferedWriter(new FileWriter("txt/" + nomeArquivo + ".txt"));

            writer.write(returnSave(objetoGravar));

            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String returnSave(EstruturaDianmica objetoGravar) {

        StringBuilder saida = new StringBuilder();
        
        saida.append(objetoGravar.getNumerosElementos());
        

        No aux = objetoGravar.getInicio();
        
        saida.append("\n");
        saida.append(objetoGravar.getInicio().getElemento().getId());
        saida.append(";");
        saida.append(objetoGravar.getInicio().getElemento().getNome());
        saida.append(";");
        saida.append(objetoGravar.getInicio().getElemento().getMarca());
        saida.append(";");
        saida.append(objetoGravar.getInicio().getElemento().getModelo());
        saida.append(";");
        saida.append(objetoGravar.getInicio().getElemento().getPreco());
        

        while (aux.getProximo() != objetoGravar.getInicio()) {

            aux = aux.getProximo();
            saida.append("\n");
            saida.append(aux.getElemento().getId());
            saida.append(";");
            saida.append(aux.getElemento().getNome());
            saida.append(";");
            saida.append(aux.getElemento().getMarca());
            saida.append(";");
            saida.append(aux.getElemento().getModelo());
            saida.append(";");
            saida.append(aux.getElemento().getPreco());

        }

        return saida.toString();

    }

    // ler pessoa arquivo txt
    public Hash readPacas(String nomeArquivo) {
        
       
       Hash pecas = null;

        try {
            //le arquivo
            BufferedReader read = new BufferedReader(new FileReader("txt/" + nomeArquivo + ".txt"));
            String[] ler;

            //le primeira linha arquivo
            try {

                ler = read.readLine().split(";");
                pecas = new Hash(Integer.parseInt(ler[0]));
                ler = read.readLine().split(";");
                
            } catch (Exception e) {
                ler = null;
            }
            

            while (ler != null) {

              pecas.put(new Peca(Integer.parseInt(ler[0]), Double.parseDouble(ler[4]), ler[2], ler[1], ler[3]));
                try {
                    //le proxima linha do arquivo
                    ler = read.readLine().split(";");
                } catch (Exception e) {
                    ler = null;
                }

            }

            return pecas;

        } catch (FileNotFoundException ex) {
            return null;

        }

    }
}
