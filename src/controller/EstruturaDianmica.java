
package controller;

import model.Peca;


public abstract class EstruturaDianmica {
    
    
    protected No inicio;
    protected No aux;
    protected int numerosElementos;

    public EstruturaDianmica() {

        this.inicio = null;
        numerosElementos = 0;
    }

    // Método para inserir novo elemento na lista 
    protected abstract void insert(Peca elemento);
    
    
    //metodo para remover um elemento
    protected abstract void remove();
    
           
    public void printList() {

        if (!isEmpty()) {
            aux = inicio;
            while (aux.getProximo() != inicio) {
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

    protected int getNumerosElementos() {
        return numerosElementos;
    }
    
}
