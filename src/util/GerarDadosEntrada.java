package util;

import controller.EstruturaDianmica;
import controller.Lista;
import dao.ReadWrite;
import java.util.Random;
import model.Peca;

public class GerarDadosEntrada {

    private Random rand = new Random();
    private String[] marcas = {"AUDI", "BMW", "CHEVROLET", "FIAT", "FORD", "HONDA", "TOYOTA", "VOLKSWAGEN"};
    private ReadWrite rw;
    

    public GerarDadosEntrada() {
        
        rw = new ReadWrite();

    }

    public EstruturaDianmica gerarDados(int NumerosElementos) {

        long inicio = System.currentTimeMillis();
        
        Lista pecas = new Lista();

        for (int i = 1; i <= NumerosElementos; i++) {

            String nome = geraNome();
            String marca = geraMarca();
            String modelo = geraModelo(marca);
            double preco = geraPreco();

            Peca peca = new Peca(i, preco, marca, nome, modelo);
            pecas.insert(peca);

        }
        
        rw.writeReport("Gerar massa dados", NumerosElementos, System.currentTimeMillis() - inicio);
        
        return pecas;

    }

    private char gerarLetra() {

        char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        return letras[rand.nextInt(letras.length)];
    }

    private String geraNome() {

        StringBuilder nome = new StringBuilder();
        nome.append(gerarLetra());
        nome.append(gerarLetra());
        nome.append(gerarLetra());
        nome.append(gerarLetra());
        nome.append(gerarLetra());
        nome.append(gerarLetra());
        nome.append(gerarLetra());

        return nome.toString();
    }

    private String geraMarca() {

        return marcas[rand.nextInt(marcas.length)];

    }

    private String geraModelo(String marca) {

        switch (marca) {
            case "AUDI":

                String[] modelosa = {"A3", "A4", "TT", "R8", "RS8"};

                return modelosa[rand.nextInt(5)];

            case "BMW":

                String[] modelosb = {"X1", "X3", "I8", "X7", "X8"};
                return modelosb[rand.nextInt(5)];

            case "CHEVROLET":

                String[] modelosc = {"ONIX", "CORSA", "S10", "PRISMA", "MONZA", "CRUZE", "MONTANA"};
                return modelosc[rand.nextInt(7)];

            case "FIAT":

                String[] modelosf = {"UNO", "DOBLO", "ARGO", "MOBI", "SIENA", "MAREA", "PALIO"};
                return modelosf[rand.nextInt(7)];

            case "FORD":

                String[] modelosfo = {"KA", "FUSION", "EDGE", "ECOSPORT", "CORCEL", "RANGER", "F250"};
                return modelosfo[rand.nextInt(7)];

            case "HONDA":

                String[] modelosh = {"CIVIC", "CR-V", "FIT", "ACCORD", "CITY", "WR-V"};
                return modelosh[rand.nextInt(6)];

            case "TOYOTA":

                String[] modelost = {"COROLLA", "CAMRY", "ETIOS", "YARIS", "PRIUS", "RAV4"};
                return modelost[rand.nextInt(6)];

            case "VOLKSWAGEN":

                String[] modelosv = {"GOL", "UP", "PARAT", "SANTANA", "PASSAT", "JETTA", "FOX", "VIRTUS"};
                return modelosv[rand.nextInt(8)];
        }

        return "outros";
    }

    private double geraPreco() {

        return Math.round(rand.nextDouble() * 100);

    }

}
