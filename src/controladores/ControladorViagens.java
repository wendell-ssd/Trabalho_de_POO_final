package controladores;

import repositorios.viagens.IRepositorioViagens;
import entidades.Viagem;
import java.util.ArrayList;
import excecoes.viagem.*;;

public class ControladorViagens {
  private IRepositorioViagens repositorioViagens;

  public ControladorViagens(IRepositorioViagens repositorioViagens) {
    this.repositorioViagens = repositorioViagens;
  }

  public ArrayList<Viagem> listaViagens() {
    return repositorioViagens.listarViagens();
  }

  public void cadastrarViagem(Viagem viagem) {
    repositorioViagens.cadastrarViagem(viagem);
  }

  public void removerViagem(Viagem viagem) throws ViagemInexistenteException {
    try {
      repositorioViagens.removerViagem(viagem);
    } catch (ViagemInexistenteException excecao) {
      throw excecao;
    }
  }

  public Viagem consultarViagemPeloID(int id) throws ViagemInexistenteException {
    try {
      return repositorioViagens.consultarViagemPeloID(id);
    } catch (ViagemInexistenteException excecao) {
      throw excecao;
    }
  }

  public String mostrarTodosAsViagens() {
    return repositorioViagens.mostrarTodosAsViagens();
  }
}
