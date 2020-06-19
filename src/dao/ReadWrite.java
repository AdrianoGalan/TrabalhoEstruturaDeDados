package dao;

import controller.EstruturaDianmica;
import controller.No;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadWrite {

    final String ENTRADA_DADOS = "txt/entradaDados100.txt";

    //escreve Pessoa arquivo txt
    public void write(EstruturaDianmica objetoGravar) {

        File file = new File(ENTRADA_DADOS);

        BufferedWriter writer;

        try {

            file.createNewFile();

            writer = new BufferedWriter(new FileWriter(ENTRADA_DADOS));

            writer.write(returnSave(objetoGravar));
            writer.newLine();

            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String returnSave(EstruturaDianmica objetoGravar) {

        StringBuilder saida = new StringBuilder();

        No aux = objetoGravar.getInicio();

        saida.append(objetoGravar.getInicio().getElemento().getId());
        saida.append(";");
        saida.append(objetoGravar.getInicio().getElemento().getNome());
        saida.append(";");
        saida.append(objetoGravar.getInicio().getElemento().getMarca());
        saida.append(";");
        saida.append(objetoGravar.getInicio().getElemento().getModelo());
        saida.append(";");
        saida.append(objetoGravar.getInicio().getElemento().getPreco());
        saida.append("\n");

        while (aux.getProximo() != objetoGravar.getInicio()) {

            aux = aux.getProximo();
            saida.append(aux.getElemento().getId());
            saida.append(";");
            saida.append(aux.getElemento().getNome());
            saida.append(";");
            saida.append(aux.getElemento().getMarca());
            saida.append(";");
            saida.append(aux.getElemento().getModelo());
            saida.append(";");
            saida.append(aux.getElemento().getPreco());
            saida.append("\n");

        }

        return saida.toString();

    }

//    // ler pessoa arquivo txt
//    public ArrayList<Pessoa> readPessoa() {
//
//        int cont = 0;
//
//        try {
//            //le arquivo
//            BufferedReader read = new BufferedReader(new FileReader(ARQUIVOPESSOA));
//            String[] ler;
//
//            //le primeira linha arquivo
//            try {
//
//                ler = read.readLine().split(";");
//
//            } catch (Exception e) {
//                ler = null;
//            }
//            ArrayList<Pessoa> pessoa = new ArrayList<>();
//
//            while (ler != null) {
//
//                pessoa.add(new Pessoa());
//
//                pessoa.get(cont).setId(Integer.parseInt(ler[0]));
//                pessoa.get(cont).setNome(ler[1]);
//                pessoa.get(cont).setCpf(ler[2]);
//                cont++;
//                try {
//                    //le proxima linha do arquivo
//                    ler = read.readLine().split(";");
//                } catch (Exception e) {
//                    ler = null;
//                }
//
//            }
//
//            return pessoa;
//
//        } catch (FileNotFoundException ex) {
//            return null;
//
//        }
//
//    }
}
