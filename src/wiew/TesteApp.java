/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wiew;

import controller.Fila;
import controller.Hash;
import controller.Lista;
import controller.Ordenar;
import controller.Pilha;
import dao.ReadWrite;
import java.util.Scanner;
import model.Peca;
import util.GerarDadosEntrada;

public class TesteApp {
    
    public static void main(String[] args) {
        
        int id;
        
        GerarDadosEntrada gerador = new GerarDadosEntrada();
        ReadWrite rw = new ReadWrite();
       
        Hash pecas;
        System.out.println("esta aki 1");
        Peca[] vetor = rw.readVetor("entradaDados100");
        System.out.println("esta aki 2");
         Ordenar ordenar = new Ordenar(vetor);
        
      //  rw.write(gerador.gerarDados(5), "teste5");
        
        Scanner teclado = new Scanner(System.in);
        
        vetor = ordenar.insertionSortName(vetor);
        
        System.out.println("Ordenado ...");
        
        rw.write(vetor, "texte100Ordenado");
        
        System.exit(0);
     
        pecas = rw.readHash("teste5");
      
        
        int flag = -1;
        
        while (flag != 9) {
            
            System.out.println("Digite 1 para buscar");
            System.out.println("Digite 2 para ordenar");
            System.out.println("Digite 3 para inserir novo");
            System.out.println("Digite 4 para grava novo txt");
            System.out.println("Digite 9 ");
            
            flag = teclado.nextInt();
            
            switch (flag) {
                case 1:
                    
                    System.out.println("Digite o nome da peça ou id");
                    String nome = teclado.next();
                    
                    try {
                        id = Integer.parseInt(nome);
                        Peca busca = pecas.search(id);
                        if (busca != null) {
                            System.out.println(busca);
                        } else {
                            System.out.println("Peca não existe");
                        }
                    } catch (Exception e) {
                        
                        Peca busca = pecas.search(nome);
                        if (busca != null) {
                            System.out.println(busca);
                        } else {
                            System.out.println("Peca não existe");
                        }
                    }
                    
                    break;
                case 3:
                    
                    id = pecas.getNumeroElementos() + 1;
                    Peca novaPeca = new Peca(id);
                    System.out.println("Digite o nome da peça");
                    novaPeca.setNome(teclado.next());
                    System.out.println("Digite a Marca");
                    novaPeca.setMarca(teclado.next());
                    System.out.println("Digite o modelo");
                    novaPeca.setModelo(teclado.next());
                    System.out.println("Digite o preco ");
                    novaPeca.setPreco(teclado.nextDouble());
                    
                    pecas.setNumeroElementos(id);
                    pecas.put(novaPeca);
                    
                    break;
                case 4:
                    
                    rw.write(pecas, "teste5");
                    
                    break;
                
            }
            
        }
        
        
        
    }
    
}
