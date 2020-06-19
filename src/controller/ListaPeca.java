package controller;

import model.Peca;

public class ListaPeca {

    private No inicio;
    private No aux;
    private int numerosElementos;

    public ListaPeca() {

        this.inicio = null;
        numerosElementos = 0;
    }

    // Método para inserir novo elemento na lista em ordem Alfabética, classificando pelo nome da peça
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
    

    public void printList() {

        if (!isEmpty()) {
            aux = inicio;
            while (aux.getProximo()!= inicio) {
                System.out.println("[Id-" + aux.getElemento().getId() + " nome- "
                        + aux.getElemento().getNome() + "] ");

                aux = aux.getProximo();
            }
            System.out.println("[Id-" + aux.getElemento().getId() + " nome- "
                        + aux.getElemento().getNome() + "] ");
            
            System.out.println("Total de Elementos = " + numerosElementos);

        } else {
            System.out.println("Não existe elementos na lista");
        }

    }

    public boolean isEmpty() {

        return this.inicio == null;
    }

    public int getNumerosElementos() {
        return numerosElementos;
    }

  

}
