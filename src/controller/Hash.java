package controller;

import model.Peca;

public class Hash {

    private int key;
    private int numeroElementos;
    private Peca[] ids;
    private Lista[] elementos;

    public Hash(int numeroElementos) {
        
        this.numeroElementos = numeroElementos;
        elementos = new Lista[this.numeroElementos];
        ids = new Peca[numeroElementos + (numeroElementos/4)];
    }
    
    // insere um elemento na haspmap
    public void put(Peca elemento){
        
        ids[elemento.getId()] = elemento;
        key = callKell(elemento.getNome());
        
        if(elementos[key] == null){
            elementos[key] = new Lista();
        }
        elementos[key].insert(elemento);
    }
    
    public Peca search(String nome){
        
        key = callKell(nome);
        
        if(elementos[key] == null){
            return null;
        }
        
        Peca busca = elementos[key].search(nome);

        if( busca == null){
            return null;
        }
        
        return busca;
        
    }
    
    public Peca search(int id){
        
        return ids[id];
        
    }

    // calcula a chave usando o nome da peça
    private int callKell(String nome) {

        byte[] code = nome.getBytes();
        int soma = 0;
        
        for(int i = 0; i < code.length; i++){
           soma += code[i];    
        }
        
        return soma % numeroElementos;

    }

}
