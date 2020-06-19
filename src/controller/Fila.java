package controller;

import model.Peca;

public class Fila extends EstruturaDianmica {

    public Fila() {
    }

   
    @Override
    public void insert(Peca elemento) {

        //cria novo nó para inserir o novo elemento
        No novo = new No(elemento);
        numerosElementos++;

        //verifica se a fila esta vazia, e insere primeiro nó na lista
        if (isEmpty()) {
            inicio = novo;
            inicio.setProximo(inicio);
            inicio.setAnterior(inicio);
            return;
        }

        //cria um nó auxiliar para não perder a referencia do inicio da fila
        aux = inicio;

        // Percorre a fila até o ultimo nó.
        while (this.aux.getProximo() != inicio) {

            aux = aux.getProximo();
        }

        // insere elemento no final da fila
        novo.setAnterior(aux);
        novo.setProximo(inicio);
        inicio.setAnterior(novo);
        aux.setProximo(novo);

    }

}
