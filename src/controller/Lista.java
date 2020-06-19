package controller;

import model.Peca;

public class Lista extends EstruturaDianmica {

    public Lista() {
    }

    // Método para inserir novo elemento na lista em ordem Alfabética, classificando pelo nome da peça
    public void insertOrder(Peca elemento) {

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

        //verifica se o elemento a ser inserido na lista é "menor" quero o elemento na posição inicio caso verdade
        //insere novo elemento na posição inicio e muda a referencia para ele apontar para o próximo
        if (inicio.getElemento().getNome().compareTo(novo.getElemento().getNome()) > 0) {

            inicio.getAnterior().setProximo(novo);
            novo.setAnterior(inicio.getAnterior());
            inicio.setAnterior(novo);
            novo.setProximo(inicio);
            inicio = novo;

            return;

        }

        //cria um nó auxiliar para não perder a referencia do inicio da lista
        aux = inicio;

        // Percorre a lista até o ultimo nó ou até encontrar um nó com elemento de menor valor
        while (this.aux.getProximo() != inicio && (aux.getProximo().getElemento().getNome().compareTo(novo.getElemento().getNome())) < 0) {

            aux = aux.getProximo();
        }

        //Verifica se o nó aux é o ultimo da lista se verdade insere novo nó na ultima posição
        if (aux.getProximo() == inicio) {

            novo.setAnterior(aux);
            novo.setProximo(inicio);
            inicio.setAnterior(novo);
            aux.setProximo(novo);
            return;

        }

        //troca de posição o novo nó e o aux;
        novo.setProximo(aux.getProximo());
        aux.getProximo().setAnterior(novo);
        novo.setAnterior(aux);
        aux.setProximo(novo);

    }

    // Método para inserir novo elemento na lista 
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

    

    //metodo para remover um elemento
    public void remove(int id) {

        //verifica se a lista esta vazia
        if (!isEmpty()) {

            // verifica se o elemento a ser removido é o primeiro
            if (inicio.getElemento().getId() == id) {

                if (inicio.getProximo() == inicio) {

                    inicio = null;
                    this.numerosElementos--;
                    return;

                }

                inicio.getAnterior().setProximo(inicio.getProximo());
                inicio.getProximo().setAnterior(inicio.getAnterior());
                inicio = inicio.getProximo();
                this.numerosElementos--;
                return;
            }

            aux = inicio;

            // percorre lista na procura do elemento
            while (aux.getProximo() != inicio && aux.getElemento().getId() != id) {

                aux = aux.getProximo();
            }

            // remove o elemento da lista
            if (aux.getElemento().getId() == id) {

                aux.getAnterior().setProximo(aux.getProximo());
                aux.getProximo().setAnterior(aux.getAnterior());
                this.numerosElementos--;
                return;

            }

            System.out.println("Elemento não encontrado na lista");

        } else {
            System.out.println("Não existe elementos na lista");
        }

    }

   

}
