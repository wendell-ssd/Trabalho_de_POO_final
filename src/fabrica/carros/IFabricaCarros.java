package fabrica.carros;

import repositorios.carros.IRepositorioCarros;

public interface IFabricaCarros {
  public IRepositorioCarros getRepositorioCarros();
}
