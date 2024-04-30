import java.util.Scanner;

import model.Conversion;
import model.PrintMenuInfo;
import util.Moedas;
import api.ApiController;
import util.Prop;

public class Principal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Conversion conv = null;
        String entrada = "";
        double valor = 0.0;
        double conversionRate = 0.0;
        double valorFinal = 0.0;
        Moedas parInicial = null;
        Moedas parFinal = null;
        int loopInt = 0;


        while (!entrada.equalsIgnoreCase("Sair") || !entrada.equalsIgnoreCase("7")){

            PrintMenuInfo.menu();
            entrada = scanner.nextLine();

            if(loopInt > 0) {
                entrada = scanner.nextLine();
            }


            if(entrada.equalsIgnoreCase("Sair") || entrada.equalsIgnoreCase("7")) break;

            try {
                 PrintMenuInfo.valor();
                 valor = scanner.nextDouble();

                switch (entrada){
                    case "1":
                        parInicial = Moedas.USD;
                        parFinal = Moedas.ARS;

                         conv = ApiController.getConversionRate(
                                 parInicial,
                                 parFinal);
                        conversionRate = conv.conversion_rate();

                        break;

                    case "2":

                        parInicial = Moedas.ARS;
                        parFinal  =  Moedas.USD;

                        conv = ApiController.getConversionRate(
                                parInicial,
                                parFinal);

                        conversionRate = conv.conversion_rate();


                        break;

                    case "3":

                        parInicial =   Moedas.USD;
                        parFinal  =    Moedas.BRL;

                        conv = ApiController.getConversionRate(
                                parInicial,
                                parFinal);

                        conversionRate = conv.conversion_rate();
                        break;

                    case "4":

                        parInicial =  Moedas.BRL;
                        parFinal  =   Moedas.USD;

                        conv = ApiController.getConversionRate(
                                parInicial,
                                parFinal);

                        conversionRate = conv.conversion_rate();

                        break;

                    case "5":

                        parInicial = Moedas.USD;
                        parFinal  =  Moedas.COL;

                        conv = ApiController.getConversionRate(
                                parInicial,
                                parFinal);

                        conversionRate = conv.conversion_rate();

                        break;

                    case "6":

                        parInicial =     Moedas.COL;
                        parFinal  =      Moedas.USD;

                        conv = ApiController.getConversionRate(
                                parInicial,
                                parFinal);


                        conversionRate = conv.conversion_rate();

                        break;


                }



                valorFinal = valor * conversionRate;
                PrintMenuInfo.valorConvert(valor, valorFinal, parInicial, parFinal);

            }catch (Exception e){
                System.out.println("Digite um numero valido");
            }

            loopInt++;

        }








    }


}
