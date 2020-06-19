/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Peca;

public class No {
    
    private Peca elemento;
    private No proximo; 
    private No anterior;
    
    public No(Peca peca){
        this.elemento = peca;
    }

    public Peca getElemento() {
        return elemento;
    }

    public void setElemento(Peca elemento) {
        this.elemento = elemento;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
    
    
    
    
}
