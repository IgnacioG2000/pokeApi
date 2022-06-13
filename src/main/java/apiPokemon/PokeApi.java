package apiPokemon;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.Response;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class PokeApi {
  public static void main(String[] args) throws Exception {
    WebClient clientPokemon = WebClient.create("https://pokeapi.co/api/v2/pokemon/8");

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    Response response = clientPokemon
        .header("Content-Type", "application/json")
        .get();

    int status = response.getStatus();
    System.out.println("Status: " + status);

    String responseBody = response.readEntity(String.class);

    if (status == 200) {
      //System.out.println("\nresponse = " + responseBody + "\n");
      Map<String, Object> respuesta = objectMapper.readValue(responseBody, new TypeReference<Map<String, Object>>(){});
      List listaDeMoviemientos = (List) respuesta.get("moves");
      System.out.println("Lista de Movimientos: " + listaDeMoviemientos + "\n");
      LinkedHashMap sprites = (LinkedHashMap) respuesta.get("sprites");
      LinkedHashMap other = (LinkedHashMap) sprites.get("other");
      LinkedHashMap dream_world = (LinkedHashMap) other.get("dream_world");
      String front_default = (String) dream_world.get("front_default");
      System.out.println("Imagen: " + front_default);
    } else {
      System.out.println("Error response = " + responseBody);
      throw new Exception("Error en la llamada a /api/user");
    }
  }
}
