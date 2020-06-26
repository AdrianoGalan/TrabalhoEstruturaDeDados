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
                if (pecas[pos].getNome().compareTo(pecas[pos + 1].getNome()) > 0) {

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

    public Peca[] selectionSortId(Peca[] pecas) {

        inicio = System.currentTimeMillis();

        Peca temp;
        int it;
        int posMenorInicial;
        int posMenor;
        int i;
        for (it = 0; it < pecas.length - 1; it++) {
            posMenorInicial = it;
            posMenor = it + 1;
            for (i = posMenorInicial + 1; i < pecas.length; i++) {
                if (pecas[i].getId() < pecas[posMenor].getId()) {
                    posMenor = i;
                }
            }
            if (pecas[posMenor].getId() < pecas[posMenorInicial].getId()) {
                // troca
                temp = pecas[posMenorInicial];
                pecas[posMenorInicial] = pecas[posMenor];
                pecas[posMenor] = temp;
            }

        }

        fim = System.currentTimeMillis();

        tempoOrdenar = fim - inicio;

        return pecas;
    }

    public Peca[] selectionSortNome(Peca[] pecas) {

        inicio = System.currentTimeMillis();

        Peca temp;
        int it;
        int posMenorInicial;
        int posMenor;
        int i;
        for (it = 0; it < pecas.length - 1; it++) {
            posMenorInicial = it;
            posMenor = it + 1;
            for (i = posMenorInicial + 1; i < pecas.length; i++) {
                //  if (pecas[i].getId() < pecas[posMenor].getId()) {
                if (pecas[i].getNome().compareTo(pecas[posMenor].getNome()) < 0) {
                    posMenor = i;
                }
            }
            //   if (pecas[posMenor].getId() < pecas[posMenorInicial].getId()) {
            if (pecas[posMenor].getNome().compareTo(pecas[posMenorInicial].getNome()) < 0) {
                // troca
                temp = pecas[posMenorInicial];
                pecas[posMenorInicial] = pecas[posMenor];
                pecas[posMenor] = temp;
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

    public Peca[] quickSort(Peca[] pecas, int inic, int f, int tipo) {

        inicio = System.currentTimeMillis();
        int pivo;

        if (inic > f) {

            fim = System.currentTimeMillis();
            tempoOrdenar = fim - inicio;
            return pecas;
        }
        if (tipo == 0) {
            pivo = partitionNome(pecas, inic, f);
        } else {
            pivo = partition(pecas, inic, f);
        }
        quickSort(pecas, inic, pivo - 1, tipo);
        quickSort(pecas, pivo + 1, f, tipo);

        fim = System.currentTimeMillis();
        tempoOrdenar = fim - inicio;
        return pecas;

    }

    private int partition(Peca[] pecas, int inicio, int fim) {
        Peca ref, temp;
        int up, down;
        ref = pecas[inicio];
        down = inicio;
        up = fim;
        while (down < up) {
            // encontrando um numero maior que o pivo (ref)
            while (pecas[down].getId() <= ref.getId() && down < fim) {
                down++; // avanço pq quero encontrar um valor maior
            }
            // tambem quero encontrar a partir do fim um valor menor que o meu de referencia
            while (pecas[up].getId() > ref.getId()) {
                up--;
            }
            if (down < up) {  // eles não se cruzaram nos índices
                //troca
                temp = pecas[down];
                pecas[down] = pecas[up];
                pecas[up] = temp;
            }
        }
        pecas[inicio] = pecas[up];
        pecas[up] = ref;
        return up; // no final das contas é a posição de UP que denota onde está o pivô
    }

    private int partitionNome(Peca[] pecas, int inicio, int fim) {
        Peca ref, temp;
        int up, down;
        ref = pecas[inicio];
        down = inicio;
        up = fim;
        while (down < up) {
            // encontrando um numero maior que o pivo (ref)
            // while (pecas[down].getId() <= ref.getId() && down < fim) {
            while (pecas[down].getNome().compareTo(ref.getNome()) <= 0 && down < fim) {
                down++; // avanço pq quero encontrar um valor maior
            }
            // tambem quero encontrar a partir do fim um valor menor que o meu de referencia
            // while (pecas[up].getId() > ref.getId()) {
            while (pecas[up].getNome().compareTo(ref.getNome()) > 0) {
                up--;
            }
            if (down < up) {  // eles não se cruzaram nos índices
                //troca
                temp = pecas[down];
                pecas[down] = pecas[up];
                pecas[up] = temp;
            }
        }
        pecas[inicio] = pecas[up];
        pecas[up] = ref;
        return up; // no final das contas é a posição de UP que denota onde está o pivô
    }

    public long getTempoOrdenar() {
        return tempoOrdenar;
    }

}
