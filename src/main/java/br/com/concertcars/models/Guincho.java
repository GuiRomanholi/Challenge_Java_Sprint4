package br.com.concertcars.models;

import java.util.Scanner;

public class Guincho extends Carro{
    private String chassi;
    private String ano_fabricacao;

    public String exibirDetalhes(){
        return "O Guincho é de placa " + getPlaca()
                + " e de marca " + getMarca() + " e foi fabricado " + getAno_fabricacao() +
                ", cuidado para não se confundir!";
    }

    public Boolean acionarGuincho(){
        Scanner leitor = new Scanner(System.in);
        while (true){
            System.out.println("Deseja Chamar o Guincho? 1 = Sim / 2 = Não");
            String opcao = leitor.nextLine();
            if (opcao.equals("1")){
                System.out.println("O guincho está a caminho!");
                System.out.println(exibirDetalhes());
                System.out.println("De Enter para continuar");
                leitor.nextLine();
                return true;
            } else if (opcao.equals("2")) {
                System.out.println("De Enter para continuar");
                leitor.nextLine();
                return false;
            }else {
                System.out.println("Por Favor Digie um valor válido!");
                System.out.println("De Enter para continuar");
                leitor.nextLine();
            }
        }

    }

    //Getters e Setters
    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getAno_fabricacao() {
        return ano_fabricacao;
    }

    public void setAno_fabricacao(String ano_fabricacao) {
        this.ano_fabricacao = ano_fabricacao;
    }
}
