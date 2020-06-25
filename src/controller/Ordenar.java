package controller;

import model.Peca;

public class Ordenar {

    private long inicio, fim, tempoOrdenar;

    public Ordenar() {

    }

    public Peca[] bubbleSortId(Peca[] pecas) {

        inicio = System.currentTimeMillis();

        int i;
        int pos;
        Peca temp;

        for (i = 0; i < pecas.length - 1; i++) {
            for (pos = 0; pos < pecas.length - i - 1; pos++) {
                // comparo o elemento da posicao com seu proximo
                if (pecas[pos].getId() > pecas[pos + 1].getId()) {

                    temp = pecas[pos];
                    pecas[pos] = pecas[pos + 1];
                    pecas[pos + 1] = temp;
                }
            }

        }

        fim = System.currentTimeMillis();

        tempoOrdenar = fim - inicio;

        return pecas;
    }
    
    public Peca[] bubbleSortNome(Peca[] pecas) {

        inicio = System.currentTimeMillis();

        int i;
        int pos;
        Peca temp;

        for (i = 0; i < pecas.length - 1; i++) {
            for (pos = 0; pos < pecas.length - i - 1; pos++) {
                // comparo o elemento da posicao com seu proximo
                //pecas[j].getNome().compareTo(carta.getNome()) > 0
                //if (pecas[pos].getId() > pecas[pos + 1].getId()) 
                if(pecas[pos].getNome().compareTo(pecas[pos+1].getNome()) > 0){

                    temp = pecas[pos];
                    pecas[pos] = pecas[pos + 1];
                    pecas[pos + 1] = temp;
                }
            }

        }

        fim = System.currentTimeMillis();

        tempoOrdenar = fim - inicio;

        return pecas;
    }

    public Peca[] insertionSortId(Peca[] pecas) {
        int it, j;
        Peca carta;

        inicio = System.currentTimeMillis();

        for (it = 1; it < pecas.length; it++) {

            carta = pecas[it];

            for (j = it - 1; j >= 0 && pecas[j].getId() > carta.getId(); j--) {

                pecas[j + 1] = pecas[j];

            }

            pecas[j + 1] = carta;

        }

        fim = System.currentTimeMillis();

        tempoOrdenar = fim - inicio;

        return pecas;

    }

    public Peca[] insertionSortName(Peca[] pecas) {
        int it, j;
        Peca carta;

        inicio = System.currentTimeMillis();

        for (it = 1; it < pecas.length; it++) {

            carta = pecas[it];

            for (j = it - 1; j >= 0 && pecas[j].getNome().compareTo(carta.getNome()) > 0; j--) {

                pecas[j + 1] = pecas[j];

            }

            pecas[j + 1] = carta;

        }

        fim = System.currentTimeMillis();

        tempoOrdenar = fim - inicio;

        return pecas;

    }

    public long getTempoOrdenar() {
        return tempoOrdenar;
    }

}
