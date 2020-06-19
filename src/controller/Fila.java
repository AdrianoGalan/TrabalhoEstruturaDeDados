package controller;

import model.Peca;

public class Fila extends EstruturaDianmica {

    public Fila() {
    }

    @Override
    public void remove() {

        if (!isEmpty()) {
            if (inicio.getProximo() == inicio) {

                inicio = null;
                this.numerosElementos--;
                return;
            }
            
            inicio.getAnterior().setProximo(inicio.getProximo());
            inicio.getProximo().setAnterior(inicio.getAnterior());
            inicio = inicio.getProximo();
            this.numerosElementos--;

        }

    }

    @Override
   public void insert(Peca elemento) {

        //cria novo nó para inserir o novo elemento
        No novo = new No(elemento);
        numerosElementos++;

        //verifica se a lista esta vazia, e insere primeiro nó a lista
        if (isEmpty()) {
            inicio = novo;
            inicio.setProximo(inicio);
            inicio.setAnterior(inicio);
            return;
        }

        //cria um nó auxiliar para não perder a referencia do inicio da lista
        aux = inicio;

        // Percorre a lista até o ultimo nó ou até encontrar um nó com elemento de menor valor
        while (this.aux.getProximo() != inicio) {

            aux = aux.getProximo();
        }

        novo.setAnterior(aux);
        novo.setProximo(inicio);
        inicio.setAnterior(novo);
        aux.setProximo(novo);

    }

}
