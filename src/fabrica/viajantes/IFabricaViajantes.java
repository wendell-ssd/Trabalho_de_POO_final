package fabrica.viajantes;

import repositorios.viajantes.IRepositorioViajantes;

public interface IFabricaViajantes {
  public IRepositorioViajantes getRepositorioViajantes();
}
