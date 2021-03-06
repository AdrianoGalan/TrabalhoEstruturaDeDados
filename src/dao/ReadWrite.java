package dao;

import controller.EstruturaDianmica;
import controller.Hash;
import controller.No;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Peca;

public class ReadWrite {

    private int ultimoId;

    public ReadWrite() {

        ultimoId = 0;
    }

    //escreve peca arquivo txt
    public void writeReport(String nomeMetodo, int nElementos, long tempo) {

        String report = outReport(nomeMetodo, nElementos, tempo);

        BufferedWriter writer;

        File dir = new File("relatorio/");
        File arq = new File("relatorio/", "relatorio.txt");

        if (!dir.exists() && !dir.isDirectory()) {
            dir.mkdir();
        }

        boolean existe = arq.exists();

        try {

            writer = new BufferedWriter(new FileWriter(arq, existe));

            writer.write(report);
            writer.newLine();

            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String readReposrt() throws FileNotFoundException, IOException {

        File arq = new File("relatorio/", "relatorio.txt");
        StringBuilder texto = new StringBuilder();

        if (arq.exists() && arq.isFile()) {

            FileInputStream fluxo = new FileInputStream(arq);
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String linha = buffer.readLine();
            while (linha != null) {

                texto.append(linha);
                texto.append("\r\n");
                linha = buffer.readLine();
            }
            buffer.close();
            leitor.close();
            fluxo.close();

            return texto.toString();

        } else {
            throw new IOException("Diretório inválido");
        }

    }

    private String outReport(String nomeMetodo, int nElementos, long tempo) {

        Calendar c = Calendar.getInstance();

        String saida = ">>>" + nomeMetodo + "<<<\n";
        saida = saida + c.getTime() + "\n";
        saida = saida + "Numero de elementos: " + nElementos + "\n";
        saida = saida + "Tempo de execução: " + tempo + " ms\n";
        saida = saida + "--------------------------------------\n";

        return saida;
    }

    public void write(EstruturaDianmica objetoGravar, String nomeArquivo) {

        BufferedWriter writer;

        File dir = new File("txt/");

        if (!dir.exists() && !dir.isDirectory()) {
            dir.mkdir();
        }

        try {

            writer = new BufferedWriter(new FileWriter("txt/" + nomeArquivo + ".txt"));

            writer.write(objetoGravar.getNumerosElementos() + "");

            writer.write(returnSave(objetoGravar));

            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean upFile(Peca peca, String name) throws IOException {

        String conteudo = returnSave(peca);
        String path = "txt/";
        File dir = new File(path);
        File arq = new File(path, name);

        if (dir.exists() && dir.isDirectory()) {
            boolean existe = arq.exists();

            FileWriter fileWriter = new FileWriter(arq, existe);
            PrintWriter print = new PrintWriter(fileWriter);
            print.write(conteudo);
            print.flush();
            print.close();
            fileWriter.close();
            return true;

        } else {
            throw new IOException("Diretório inválido");
        }

    }

    public void write(Hash objetoGravar, String nomeArquivo) {

        BufferedWriter writer;

        try {

            // file.createNewFile();
            writer = new BufferedWriter(new FileWriter("txt/" + nomeArquivo + ".txt"));

            writer.write(objetoGravar.getNumeroElementos() + "");

            writer.write(returnSave(objetoGravar));

            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void write(Peca[] objetoGravar, String nomeArquivo) {

        BufferedWriter writer;
        int tamanho = objetoGravar.length;

        try {

            // file.createNewFile();
            writer = new BufferedWriter(new FileWriter("txt/" + nomeArquivo + ".txt"));

            writer.write(tamanho + "");

            writer.write(returnSave(objetoGravar, tamanho));

            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(ReadWrite.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String returnSave(Hash objetoGravar) {

        StringBuilder saida = new StringBuilder();

        for (int i = 0; i < objetoGravar.getElementos().length; i++) {

            if (objetoGravar.getElementos()[i] != null) {
                saida.append(returnSave(objetoGravar.getElementos()[i]));
            }
        }

        return saida.toString();

    }

    private String returnSave(Peca objetoGravar) {

        StringBuilder saida = new StringBuilder();

        saida.append("\n");
        saida.append(objetoGravar.getId());
        saida.append(";");
        saida.append(objetoGravar.getNome());
        saida.append(";");
        saida.append(objetoGravar.getMarca());
        saida.append(";");
        saida.append(objetoGravar.getModelo());
        saida.append(";");
        saida.append(objetoGravar.getPreco());

        return saida.toString();

    }

    private String returnSave(EstruturaDianmica objetoGravar) {

        StringBuilder saida = new StringBuilder();

        No aux = objetoGravar.getInicio();

        if (objetoGravar != null && objetoGravar.getInicio() != null && objetoGravar.getInicio().getElemento() != null) {
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
        }
        return saida.toString();

    }

    private String returnSave(Peca[] objetoGravar, int tamanho) {

        StringBuilder saida = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {

            saida.append("\n");
            saida.append(objetoGravar[i].getId());
            saida.append(";");
            saida.append(objetoGravar[i].getNome());
            saida.append(";");
            saida.append(objetoGravar[i].getMarca());
            saida.append(";");
            saida.append(objetoGravar[i].getModelo());
            saida.append(";");
            saida.append(objetoGravar[i].getPreco());

        }

        return saida.toString();

    }

    // ler pessoa arquivo txt
    public Hash readHash(String nomeArquivo) {

        Hash pecas = null;

        try {
            //le arquivo
            BufferedReader read = new BufferedReader(new FileReader("txt/" + nomeArquivo));
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

    public Peca[] readVetor(String nomeArquivo) {

        Peca[] pecas = null;

        try {
            //le arquivo
            BufferedReader read = new BufferedReader(new FileReader("txt/" + nomeArquivo));
            String[] ler;

            //le primeira linha arquivo
            try {

                ler = read.readLine().split(";");
                pecas = new Peca[Integer.parseInt(ler[0])];
                ler = read.readLine().split(";");

                for (int i = 0; i < pecas.length; i++) {
                    pecas[i] = new Peca();
                    pecas[i].setId(Integer.parseInt(ler[0]));
                    pecas[i].setNome(ler[1]);
                    pecas[i].setMarca(ler[2]);
                    pecas[i].setModelo(ler[3]);
                    pecas[i].setPreco(Double.parseDouble(ler[4]));
                    if (ultimoId < pecas[i].getId()) {
                        ultimoId = pecas[i].getId();
                    }
                    ler = read.readLine().split(";");
                }

            } catch (Exception e) {
                ler = null;
            }

            return pecas;

        } catch (FileNotFoundException ex) {
            return null;

        }

    }

    public ArrayList readDir(String path) {

        ArrayList<String> arquivos = new ArrayList();

       

        File file = new File(path);
        if (file.exists() && file.isDirectory()) {

            File[] files = file.listFiles();
            for (File f : files) {
                if (f.isFile()) {
                    arquivos.add(f.getName());
                }
            }

        } else {
            //throw new IOException("Diretório inválido");
        }
        return arquivos;
    }

    public boolean deleteFine(String name) {

        ArrayList<String> arquivos = new ArrayList();

        String path = "txt/";

        File file = new File(path, name);
        if (file.exists()) {

            return file.delete();

        } else {

            return false;
            //throw new IOException("Diretório inválido");
        }

    }

    public void openFile(String name, String path) throws IOException {

        

        File arq = new File(path, name);

        if (arq.exists() && arq.isFile()) {

            Desktop desktop = Desktop.getDesktop();
            desktop.open(arq);

        } else {
            throw new IOException("Diretório inválido");
        }

    }

    public int getUltimoId() {
        return ultimoId;
    }

}
