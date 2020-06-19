/*
Criar uma estrutura de dados não-homogênea para 
exemplificação dos dados gerados no cenário escolhido pelo grupo.
 */
package model;

public class Peca {
    
    private int id;
    private double preco;
    private String marca;
    private String nome;
    private String modelo;

    public Peca() {
    }

    public Peca(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Peca{" + "id=" + id + ", preco=" + preco + ", nome=" + nome + '}';
    }
    
        
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    
    
}
