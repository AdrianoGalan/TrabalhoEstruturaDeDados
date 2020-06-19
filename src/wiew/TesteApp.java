/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wiew;

import controller.Fila;
import controller.Lista;
import controller.Pilha;
import dao.ReadWrite;
import model.Peca;
import util.GerarDadosEntrada;

public class TesteApp {

    public static void main(String[] args) {

        ReadWrite rw = new ReadWrite();
        GerarDadosEntrada gerar = new GerarDadosEntrada();
        
      
        rw.write(gerar.gerarDados(500000));

    }
}
