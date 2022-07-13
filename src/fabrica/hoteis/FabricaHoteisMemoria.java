package fabrica.hoteis;

import repositorios.hoteis.RepositorioHoteisMemoria;

public class FabricaHoteisMemoria implements IFabricaHoteis {
  public RepositorioHoteisMemoria getRepositorioHoteis() {
    return new RepositorioHoteisMemoria();
  }
}