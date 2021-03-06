package controller;

import dao.ReadWrite;
import model.Peca;

public class Busca {

    private Ordenar ordenar;
    private long tempoOrdenar, tempoBuscaL, tempoBuscaB, inicOr, fimOr;

    private ReadWrite rw;

    public Busca() {

        ordenar = new Ordenar();
        rw = new ReadWrite();

    }

    public Peca buscaBinaria(Peca[] pecas, String nome) {

        int menor = 0;
        int maior = pecas.length - 1;
        int meio;

        pecas = rw.readVetor(ArquivoAtual.getNome());
        inicOr = System.currentTimeMillis();
        pecas = ordenar.quickSort(pecas, menor, maior, 0);
        fimOr = System.currentTimeMillis();

        tempoOrdenar = fimOr - inicOr;

        long inicio = System.currentTimeMillis();

        while (menor <= maior) {
            meio = (menor + maior) / 2;

            if (pecas[meio].getNome().equals(nome)) {

                tempoBuscaB = System.currentTimeMillis() - inicio;

                return pecas[meio];
            }

            if (pecas[meio].getNome().compareTo(nome) < 0) {
                menor = meio + 1;
            } else if (pecas[meio].getNome().compareTo(nome) > 0) {
                maior = meio - 1;
            }
        }

        tempoBuscaB = System.currentTimeMillis() - inicio;

        return null;

    }

    public Peca buscaBinaria(Peca[] pecas, int id) {

        int menor = 0;
        int maior = pecas.length - 1;
        int meio;

        pecas = rw.readVetor(ArquivoAtual.getNome());
        pecas = ordenar.quickSort(pecas, menor, maior, 0);
        inicOr = System.currentTimeMillis();
        pecas = ordenar.quickSort(pecas, menor, maior, 1);
        fimOr = System.currentTimeMillis();

        tempoOrdenar = fimOr - inicOr;

        long inicio = System.currentTimeMillis();

        while (menor <= maior) {
            meio = (menor + maior) / 2;

            if (pecas[meio].getId() == id) {

                tempoBuscaB = System.currentTimeMillis() - inicio;

                return pecas[meio];
            }

            if (pecas[meio].getId() < id) {
                menor = meio + 1;
            } else if (pecas[meio].getId() > id) {
                maior = meio - 1;
            }
        }

        tempoBuscaB = System.currentTimeMillis() - inicio;

        return null;

    }

    public Peca buscaLinear(Peca[] pecas, String nome) {

        long inicio = System.currentTimeMillis();

        int tamanho = pecas.length;

        for (int j = 0; j < tamanho; j++) {

            if (pecas[j] != null) {
                if (pecas[j].getNome().equals(nome)) {

                    tempoBuscaL = System.currentTimeMillis() - inicio;
                    return pecas[j];
                }
            }
        }

        tempoBuscaL = System.currentTimeMillis() - inicio;
        return null;

    }

    public Peca buscaLinear(Peca[] pecas, int id) {

        long inicio = System.currentTimeMillis();

        int tamanho = pecas.length;

        for (int j = 0; j < tamanho; j++) {

            if (pecas[j].getId() == id) {

                tempoBuscaL = System.currentTimeMillis() - inicio;
                return pecas[j];
            }
        }

        tempoBuscaL = System.currentTimeMillis() - inicio;
        return null;

    }

    public long getTempoOrdenar() {
        return tempoOrdenar;
    }

    public long getTempoBuscaL() {
        return tempoBuscaL;
    }

    public long getTempoBuscaB() {
        return tempoBuscaB;
    }

}
