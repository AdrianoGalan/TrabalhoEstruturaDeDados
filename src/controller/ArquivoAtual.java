package controller;

import javafx.scene.control.Label;
import model.Peca;

public class ArquivoAtual {
    
    private static String nome;
    private static Hash hashAtual;
    private static Peca[] pecas;

    public ArquivoAtual() {
        
        nome = "Selecione um arquivo";
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        ArquivoAtual.nome = nome;
    }

    public static Hash getHashAtual() {
        return hashAtual;
    }

    public static void setHashAtual(Hash hashAtual) {
        ArquivoAtual.hashAtual = hashAtual;
    }

    public static Peca[] getPecas() {
        return pecas;
    }

    public static void setPecas(Peca[] pecas) {
        ArquivoAtual.pecas = pecas;
    }


  
    
    
    
}
