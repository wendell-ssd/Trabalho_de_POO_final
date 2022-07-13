package fabrica.viagens;

import repositorios.viagens.RepositorioViagensMemoria;

public class FabricaViagensMemoria implements IFabricaViagens {
  public RepositorioViagensMemoria getRepositorioViagens() {
    return new RepositorioViagensMemoria();
  }
}