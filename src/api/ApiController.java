package api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Conversion;
import util.Moedas;
import util.Prop;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

import static util.Prop.getProp;

public class ApiController {
    private static String baseUrl = "https://v6.exchangerate-api.com/v6/";


   public static Conversion getConversionRate(Moedas base_code, Moedas target_code){

       String urlCompleta = "";
       Conversion conversion = null;
       HttpClient client = HttpClient.newHttpClient();


       try {
           String key = Prop.getProp().getProperty("prop.api.key");
           urlCompleta = baseUrl + key+ "/pair/" + base_code + "/" + target_code;
       }catch (IOException e){
           System.out.println("Erro ao ler a chave da api");
           System.out.println(e.getMessage());
       }

       HttpRequest request = HttpRequest.newBuilder(URI.create(urlCompleta))
               .header("Content-Type", "application/json")
               .build();

       try {


           HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

          String body = (String) response.body();

           Gson gson = new Gson();
           conversion = gson.fromJson(body, Conversion.class);


       } catch (Exception e) {
           System.out.println("Erro ao buscar o valor da moeda!");


       }

      return conversion;
   }


}
