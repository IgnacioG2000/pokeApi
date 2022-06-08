import java.util.Collection;

public class AutenticacionResponse {
  private String url;
  private Collection<Movimiento> movimientos;


  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Collection<Movimiento> getMovimientos() {
    return this.movimientos;
  }
}
