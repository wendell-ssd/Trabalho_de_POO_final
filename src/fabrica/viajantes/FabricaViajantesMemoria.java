package fabrica.viajantes;

import repositorios.viajantes.RepositorioViajantesMemoria;

public class FabricaViajantesMemoria implements IFabricaViajantes {
  public RepositorioViajantesMemoria getRepositorioViajantes() {
    return new RepositorioViajantesMemoria();
  }
}
