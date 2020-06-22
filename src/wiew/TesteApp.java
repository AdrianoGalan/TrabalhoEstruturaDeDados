/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wiew;

import controller.Fila;
import controller.Hash;
import controller.Lista;
import controller.Pilha;
import dao.ReadWrite;
import java.util.Scanner;
import model.Peca;
import util.GerarDadosEntrada;

public class TesteApp {

    public static void main(String[] args) {

        GerarDadosEntrada gerador = new GerarDadosEntrada();
        ReadWrite rw = new ReadWrite();
        Hash pecas;

        Scanner teclado = new Scanner(System.in);

        pecas = rw.readPacas("entradaDados200");

        int flag = -1;

        while (flag != 9) {

            System.out.println("Digite 1 para buscar");
            System.out.println("Digite 2 para ordenar");
            System.out.println("Digite 9 ");

            flag = teclado.nextInt();

            switch (flag) {
                case 1:

                    System.out.println("Digite o nome da peça ou id");
                    int id;
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
            }

        }

    }

}
