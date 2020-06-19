package controller;

import model.Peca;

public class Pilha extends EstruturaDianmica {

    public Pilha() {
    }

    @Override
    public void insert(Peca elemento) {

        //cria novo nó para inserir o novo elemento
        No novo = new No(elemento);
        numerosElementos++;

        //verifica se a pilha esta vazia, e insere no topo da pilha
        if (isEmpty()) {
            inicio = novo;
            inicio.setProximo(inicio);
            inicio.setAnterior(inicio);
            return;
        }

        // insere elemento no topo da pilha
        inicio.getAnterior().setProximo(novo);
        novo.setAnterior(inicio.getAnterior());
        inicio.setAnterior(novo);
        novo.setProximo(inicio);
        inicio = novo;


    }


}
