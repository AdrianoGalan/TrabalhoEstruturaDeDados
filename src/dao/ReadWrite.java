package dao;


import controller.EstruturaDianmica;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadWrite {

    final String ENTRADA_DADOS = "txt/entradaDados.txt";
   

    //escreve Pessoa arquivo txt
    public void writePessoa(EstruturaDianmica objetoGravar) {
        
        File f = new File("txt/teste2.txt");
        

        BufferedWriter writer;

        try {
            
            f.createNewFile();
            
            writer = new BufferedWriter(new FileWriter("txt/teste2.txt"));

            if(objetoGravar.getInicio().getProximo() == objetoGravar.getInicio()){
               
                writer.write(objetoGravar.getInicio().getElemento().toString());
                writer.newLine();
                
                
            }
                                    

            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
        }

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
