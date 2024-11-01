package br.com.concertcars.models;

import java.util.Scanner;

public class Diagnostico extends Pedido{

    private String descricaoSintoma;


    public void exibirMenuProblema(){
        System.out.println(
                "-----------------------------------------\n" +
                        "\tM E N U - D E - P R O B L E M A S \n" +
                        "-----------------------------------------\n" +
                        " 1 - Superaquecimento\n" +
                        " 2 - Pane Elétrica\n" +
                        " 3 - Bateria\n" +
                        " 4 - Falta de Combustível\n" +
                        " 5 - Carro Trepidando\n" +
                        " 6 - Pneus Furados\n" +
                        " 7 - Correia Dentada\n" +
                        " 8 - Problemas no Câmbio\n" +
                        " 0 - Voltar\n" +
                        "------>"
        );
    }

    public void exibirDiagnostico() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("\nCaso você queira resolver o problema, " +
                "\nE caso você ache que seu problema está relacionado a algum destes infortúnios" +
                "\n por favor digite o repectivo número: ");
        while (true){
            exibirMenuProblema();
            String opcao = leitor.nextLine();
            if (opcao.equals("1")){
                System.out.println("Se o carro estiver superaquecendo, pare imediatamente, desligue o motor e deixe esfriar." +
                        "\nVerifique o nível do líquido de arrefecimento e procure por vazamentos.");
            } else if (opcao.equals("2")) {
                System.out.println("Em caso de pane elétrica no carro, verifique os fusíveis e conexões elétricas." +
                        "\nSe necessário, chame um eletricista automotivo qualificado para diagnosticar e corrigir o problema.");
            } else if (opcao.equals("3")) {
                System.out.println("Se a bateria do carro estiver ruim, tente dar uma carga com cabos auxiliares ou um carregador portátil." +
                        "\nSe não resolver, substitua por uma nova ou chame um serviço de assistência para fazer isso.");
            } else if (opcao.equals("4")) {
                System.out.println("Se estiver sem combustível, pare o carro em local seguro." +
                        "\nSe possível, peça ajuda para trazer combustível. " +
                        "\nSe não, chame um serviço de assistência para reabastecer ou providenciar uma solução.");
            } else if (opcao.equals("5")) {
                System.out.println("Se o carro estiver trepidando, verifique as rodas quanto a danos ou desequilíbrio." +
                        "\nSe necessário, ajuste a pressão dos pneus." +
                        "\nSe o problema persistir, pode ser necessário verificar os freios ou a suspensão com um mecânico.");
            } else if (opcao.equals("6")) {
                System.out.println("Se tiver um pneu furado, estacione em local seguro." +
                        "\nTroque o pneu utilizando o macaco e a chave de roda, ou chame um serviço de assistência para trocar o pneu por você.");
            } else if (opcao.equals("7")) {
                System.out.println("Se a correia dentada quebrar, pare o carro imediatamente para evitar danos ao motor." +
                        "\nChame um serviço de reboque para levar o veículo a uma oficina mecânica para substituir a correia e verificar se há danos adicionais no motor.");
            } else if (opcao.equals("8")) {
                System.out.println("Se enfrentar problemas de câmbio, estacione com segurança." +
                        "\nVerifique o nível de fluido de transmissão e procure sinais de vazamento." +
                        "\nSe persistir, consulte um mecânico qualificado para diagnosticar e reparar o câmbio.");
            } else if (opcao.equals("0")) {
                System.out.println("Voltando...");
                break;
            } else {
                System.out.println("Por Favor digite o respectivo número");
            }
        }
    }

    //Getters e Setters

    public String getDescricaoSintoma() {
        return descricaoSintoma;
    }

    public void setDescricaoSintoma(String descricaoSintoma) {
        this.descricaoSintoma = descricaoSintoma;
    }
}
