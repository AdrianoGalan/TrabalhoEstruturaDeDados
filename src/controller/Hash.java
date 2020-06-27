package controller;

import model.Peca;

public class Hash {

    private int key;
    private int numeroElementos;
    private Peca[] ids;
    private int idsLength;
    private Lista[] elementos;
    private long tempoBusca;
    private int idAtual;

    public Hash(int numeroElementos) {

        // total de elemento para efeito de calculo de id
        this.numeroElementos = numeroElementos;
        elementos = new Lista[this.numeroElementos];
        // vetor para busca direta por id
        idsLength = numeroElementos + (numeroElementos / 4);
        ids = new Peca[idsLength];
        
        idAtual = 1;
    }

    // insere um elemento na haspmap
    public void put(Peca elemento) {

        if (elemento.getId() >= idsLength) {

            capacity();

        }

        ids[elemento.getId()] = elemento;
        key = callKell(elemento.getNome());

        if (elementos[key] == null) {
            elementos[key] = new Lista();
        }
        elementos[key].insert(elemento);
        idAtual++;
    }

    public Peca search(String nome) {

        long inicio = System.currentTimeMillis();

        key = callKell(nome);

        if (elementos[key] == null) {
            return null;
        }

        Peca busca = elementos[key].search(nome);

        if (busca == null) {
            long fim = System.currentTimeMillis();
            tempoBusca = (int) (fim - inicio);
            return null;
        }

        long fim = System.currentTimeMillis();
        tempoBusca = fim - inicio;
        return busca;

    }

    public Peca search(int id) {

        return ids[id];

    }

    // calcula a chave usando o nome da peça
    private int callKell(String nome) {

        byte[] code = nome.getBytes();
        int soma = 0;

        for (int i = 0; i < code.length; i++) {
            soma += code[i];
        }

        return soma % numeroElementos;

    }

    private void capacity() {

        int novoIdsLength = idsLength + (idsLength / 4);

        Peca[] novoIds = new Peca[novoIdsLength];

        for (int i = 1; i < idsLength; i++) {

            novoIds[i] = ids[i];
        }

        idsLength = novoIdsLength;

        ids = novoIds;

    }

    public int getNumeroElementos() {
        return numeroElementos;
    }

    public void setNumeroElementos(int numeroElementos) {
        this.numeroElementos = numeroElementos;
    }
    
    public Peca[] getPecas(){
        
        return ids;
    }

    public Lista[] getElementos() {
        return elementos;
    }

    public long getTempoBusca() {
        return tempoBusca;
    }

    public int getIdAtual() {
        return idAtual;
    }
    
    

}
