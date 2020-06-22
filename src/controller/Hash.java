package controller;

import model.Peca;

public class Hash {

    private int key;
    private int numeroElementos;
    private Peca[] ids;
    private int idsLength;
    private Lista[] elementos;

    public Hash(int numeroElementos) {
        
        // total de elemento para efeito de calculo de id
        this.numeroElementos = numeroElementos;
        elementos = new Lista[this.numeroElementos];
        // vetor para busca direta por id
        idsLength = numeroElementos + (numeroElementos/4);
        ids = new Peca[idsLength];
    }
    
    // insere um elemento na haspmap
    public void put(Peca elemento){
        
        if(elemento.getId() >= idsLength){
         
            ids = capacity();
            
        }
        
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

    private Peca[] capacity() {
       
        int novoIdsLength = idsLength + (idsLength /4);
        
        Peca[] novoIds = new Peca[novoIdsLength];
        
        for (int i = 1; i < idsLength; i++) {
            
            novoIds[i] = ids[i];
        }
  
        idsLength = novoIdsLength;
        
        return novoIds;
        
    }

    public int getNumeroElementos() {
        return numeroElementos;
    }

    public void setNumeroElementos(int numeroElementos) {
        this.numeroElementos = numeroElementos;
    }

    public Lista[] getElementos() {
        return elementos;
    }

    
    
    

}
