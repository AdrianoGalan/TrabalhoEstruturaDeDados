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


    public Peca search(int id) {

        if (!isEmpty()) {

            if (inicio.getElemento().getId() == id) {
                return inicio.getElemento();
            }

            aux = inicio;

            while (aux.getProximo() != inicio && aux.getElemento().getId() != id) {

                aux = aux.getProximo();

            }
            if (aux.getElemento().getId() == id) {
                return aux.getElemento();
            }

            return null;

        } else {

            return null;
        }

    }
    
    public Peca search(String nome) {

        if (!isEmpty()) {

            if  (inicio.getElemento().getNome().equalsIgnoreCase(nome)) {
                return inicio.getElemento();
            }

            aux = inicio;

            while (aux.getProximo() != inicio && (!aux.getElemento().getNome().equalsIgnoreCase(nome))) {

                aux = aux.getProximo();

            }
            if (aux.getElemento().getNome().equalsIgnoreCase(nome)) {
                return aux.getElemento();
            }

            return null;

        } else {

            return null;
        }

    }
    
    public Peca searchBrand(String marca) {

        if (!isEmpty()) {

            if  (inicio.getElemento().getMarca().equalsIgnoreCase(marca)) {
                return inicio.getElemento();
            }

            aux = inicio;

            while (aux.getProximo() != inicio && (!aux.getElemento().getMarca().equalsIgnoreCase(marca))) {

                aux = aux.getProximo();

            }
            if (aux.getElemento().getModelo().equalsIgnoreCase(marca)) {
                return aux.getElemento();
            }

            return null;

        } else {

            return null;
        }

    }
    
    public Peca searchModel(String modelo) {

        if (!isEmpty()) {

            if  (inicio.getElemento().getModelo().equalsIgnoreCase(modelo)) {
                return inicio.getElemento();
            }

            aux = inicio;

            while (aux.getProximo() != inicio && (!aux.getElemento().getModelo().equalsIgnoreCase(modelo))) {

                aux = aux.getProximo();

            }
            if (aux.getElemento().getModelo().equalsIgnoreCase(modelo)) {
                return aux.getElemento();
            }

            return null;

        } else {

            return null;
        }

    }

    public void printList() {

        if (!isEmpty()) {
            aux = inicio;
            while (aux.getProximo() != inicio) {
                System.out.println("[Id-" + aux.getElemento().getId() + " nome- "
                        + aux.getElemento().getNome() + " preço- " + aux.getElemento().getPreco() + "] ");

                aux = aux.getProximo();
            }
            System.out.println("[Id-" + aux.getElemento().getId() + " nome- "
                    + aux.getElemento().getNome() + " preço- " + aux.getElemento().getPreco() + "] ");

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

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public No getAux() {
        return aux;
    }

    public void setAux(No aux) {
        this.aux = aux;
    }
    
    

}
