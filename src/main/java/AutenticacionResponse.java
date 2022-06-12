import apiPokemon.Move;

import java.util.Collection;

public class AutenticacionResponse {
  private String url;
  private Collection<Move> movimientos;


  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Collection<Move> getMovimientos() {
    return movimientos;
  }
}
