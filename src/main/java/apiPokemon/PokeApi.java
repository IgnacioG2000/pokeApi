package apiPokemon;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.Response;

public class PokeApi {


  public String obtenerToken(String mail) throws Exception {
    WebClient clientUsers = WebClient.create("https://pokeapi.co/api/v2/pokemon/ditto");


    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    //response lo que nos devuelve
    Response response = clientUsers
        .header("Content-apiPokemon.Type", "application/json")
        .get();

    int status = response.getStatus();
    System.out.println("Status: " + status);
    String responseBody = response.readEntity(String.class);
    if (status == 201) {
      System.out.println("Autent response = " + responseBody);
      AutenticacionResponse autenticacionResponse = objectMapper.readValue(responseBody, AutenticacionResponse.class);
      return autenticacionResponse.getToken();
    } else {
      System.out.println("Error response = " + responseBody);
      throw new Exception("Error en la llamada a /api/user");
    }
  }
}
