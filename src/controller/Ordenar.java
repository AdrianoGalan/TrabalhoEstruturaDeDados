package controller;

import model.Peca;

public class Ordenar {

    

    public Ordenar(Peca[] pecas) {
        
    }

    public Peca[] insertionSortId(Peca[] pecas) {
        int it, j;
        Peca carta;

        for (it = 2; it < pecas.length; it++) {

            carta = pecas[it];
            
            for (j = it - 1; j >= 1 && pecas[j].getId() > carta.getId(); j--) {

                pecas[j + 1] = pecas[j];

            }

            pecas[j + 1] = carta;

        }

        return pecas;

    }

    public Peca[] insertionSortName(Peca[] pecas) {
        int it, j;
        Peca carta;

        for (it = 2; it < pecas.length; it++) {

            carta = pecas[it];

            for (j = it - 1; j >= 1 && pecas[j].getNome().compareTo(carta.getNome()) > 0; j--) {

                pecas[j + 1] = pecas[j];

            }

            pecas[j + 1] = carta;

        }

        return pecas;

    }

}
