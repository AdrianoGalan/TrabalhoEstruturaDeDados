package controller;

import model.Peca;

public class Hash {

    private int key;
    private int numeroElementos;
    private Peca[] ids;
    private int idsLength;
    private Lista[] elementos;
    private long tempoBusca;
    private long idAtual;

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

        // verifica o tamanho do vetor de ids
        while (elemento.getId() >= idsLength) {

            capacity();

        }

        // Faz referencia ao elemento na posição do vetor correspondente a id
        ids[elemento.getId()] = elemento;
        //calcula o valor da chave
        key = callKell(elemento.getNome());
        // verifica a posição caso não tenha elemento cria um novo e insere na posição
        if (elementos[key] == null) {
            elementos[key] = new Lista();
        }
        // caso tenha elemento a responsabilidade de tratar é da classe lista
        elementos[key].insert(elemento);
        idAtual++;
    }

    // Metodo de busca por nome
    public Peca search(String nome) {

        long inicio = System.currentTimeMillis();

        // calcula a chave usando o nome
        key = callKell(nome);

        if (elementos[key] == null) {
            long fim = System.currentTimeMillis();
            tempoBusca = (int) (fim - inicio);
            return null;
        }
        
        // cria um novo que recebe o elemento na posição da chave chama no metodo de busca para percorrer os elementod da posição
        Peca busca = elementos[key].search(nome);

        if (busca == null) {
            long fim = System.currentTimeMillis();
            tempoBusca = (fim - inicio);
            return null;
        }

        // retorna o elemendo 
        long fim = System.currentTimeMillis();
        tempoBusca = fim - inicio;
        return busca;

    }

    //metodo de busca por id
    public Peca search(int id) {
        
        // retorna o elemento da posição correspondente
        return ids[id];

    }

    // metodo para remover elemento
    public void remove(Peca peca) {

        // remove elemento da posição correspondente
        ids[peca.getId()] = null;
        //calcula a chave
        key = callKell(peca.getNome());
        //a responsabilidade de remover é da classe lista
        elementos[key].remove(peca.getId());
        numeroElementos--;

    }

    // calcula a chave usando o nome da peça
    private int callKell(String nome) {

        //cria e coloca a String em um vetor de byte
        byte[] code = nome.getBytes();
        int soma = 0;

        //soma os valores da tabela ascii correspondente de cada letra do nome
        for (int i = 0; i < code.length; i++) {
            soma += code[i];
        }
        
        // retorna o resto da divisão com o numero de elementos 
        return soma % numeroElementos;

    }

    
    private void capacity() {

        int novoIdsLength = idsLength + (idsLength / 2);

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

    public Peca[] getPecas() {

        return ids;
    }

    public Lista[] getElementos() {
        return elementos;
    }

    public long getTempoBusca() {
        return tempoBusca;
    }

    public long getIdAtual() {
        return idAtual;
    }

}
