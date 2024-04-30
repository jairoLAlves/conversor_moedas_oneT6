package model;

import util.Moedas;

public class PrintMenuInfo {

   public static  void menu(){
        System.out.println("""
                ****************************************************************
                Seja bem-vindo/a ao Conversor de Moedas
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileiro 
                4) Real brasileiro =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano  =>>  Dólar
                7) Sair
                Escolha uma opção válida
                ****************************************************************
                """);
    }
    public static  void valor (){
        System.out.println("Digite o valor que deseja converter:");
    }

    public static  void valorConvert (
            double valor,
            double valorFinal,
            Moedas parInicial,
            Moedas parFinal
            ){
        System.out.printf(
                "Valor %.3f [%s] corresponde ao valor final de =>>> %.3f  %s %n",
                valor,
                parInicial.toString(),
                valorFinal,
                parFinal.toString()
                );
    }
}
