/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wiew;

import controller.ListaPeca;
import model.Peca;

public class TesteApp {

    public static void main(String[] args) {

        ListaPeca pecas = new ListaPeca();

        pecas.insert(new Peca(0, "e", 2.0));
//        pecas.printList();
//        System.err.println("1");
        pecas.insert(new Peca(1, "d", 2.2));
//        pecas.printList();
//        System.err.println("2");
        pecas.insert(new Peca(2, "f", 3.9));
//        pecas.printList();
////        System.err.println("3");
        pecas.insert(new Peca(3, "c", 3.0));
//        pecas.printList();
////        System.err.println("4");
        pecas.insert(new Peca(4, "a", 5.79));
//        pecas.printList();
//////        System.err.println("5");
        pecas.insert(new Peca(5, "b", 6));
//////        pecas.printList();
//////        System.err.println("6");
//        pecas.insert(new Peca(6, "g"));
//////        pecas.printList();
//////        System.err.println("7");
//        pecas.insert(new Peca(7, "h"));
//////        pecas.printList();
//////        System.err.println("8");
//        pecas.insert(new Peca(8, "i"));
        pecas.printList();
////        System.err.println("9");
//        pecas.insert(new Peca(9, "a"));
//        pecas.printList();


      
        pecas.printList();

    }
}