package apiPokemon;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;


public class PokeApi {
  public static void main(String[] args) throws Exception {
    WebClient clientPokemon = WebClient.create("https://pokeapi.co/api/v2/pokemon/1");

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    Response response = clientPokemon
        .header("Content-Type", "application/json")
        .get();


    int status = response.getStatus();
    System.out.println("Status: " + status);

    String responseBody = response.readEntity(String.class);

    if (status == 200) {
      System.out.println("\nresponse = " + responseBody + "\n");
      Map<String, Object> respuesta = objectMapper.readValue(responseBody, new TypeReference<Map<String, Object>>(){});
      List listaDeMoviemientos = (List) respuesta.get("moves");
      System.out.println(listaDeMoviemientos);
 }


      /*for (int i = 0 ; i < movimientos.length ; i++) {
        System.out.println(i);
        //System.out.println("\nName: " + habilidades[i].getHabilidad());
      }
    } else {
      System.out.println("Error response = " + responseBody);
      throw new Exception("Error en la llamada a /api/user");
    }*/

  }
}
