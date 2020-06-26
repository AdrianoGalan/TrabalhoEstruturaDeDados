package controller;

import model.Peca;

public class Busca {

    private Ordenar ordenar;
    private long inicio, fim, tempoOrdenar, tempoBusca;

    public Busca() {

        ordenar = new Ordenar();

    }

    public Peca buscaBinaria(Peca[] pecas, String nome) {

        int menor = 0;
        int maior = pecas.length - 1;
        int meio;
        boolean vetorOrdenado = false;

        if(!vetorOrdenado){
        pecas = ordenar.quickSort(pecas, menor, maior, 0);
        vetorOrdenado = true;
        }
        tempoOrdenar = ordenar.getTempoOrdenar();

        inicio = System.currentTimeMillis();

        while (menor <= maior) {
            meio = (menor + maior) / 2;

            if (pecas[meio].getNome().equals(nome)) {

                fim = System.currentTimeMillis();

                tempoBusca = inicio - fim;

                return pecas[meio];
            }

            if (pecas[meio].getNome().compareTo(nome) < 0) {
                menor = meio + 1;
            } else if (pecas[meio].getNome().compareTo(nome) > 0) {
                maior = meio - 1;
            }
        }

        fim = System.currentTimeMillis();

        tempoBusca = inicio - fim;

        return null;

    }

    public Peca buscaLinear(Peca[] pecas, String nome) {

        inicio = System.currentTimeMillis();

        int tamanho = pecas.length;

        for (int j = 0; j < tamanho; j++) {

            if (pecas[j].getNome().equals(nome)) {

                fim = System.currentTimeMillis();
                tempoBusca = fim - inicio;
                return pecas[j];
            }
        }

        fim = System.currentTimeMillis();
        tempoBusca = fim - inicio;
        return null;

    }

    public long getTempoOrdenar() {
        return tempoOrdenar;
    }

    public long getTempoBusca() {
        return tempoBusca;
    }

}
