package controladores;

import entidades.Data;
import entidades.Local;
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

  public void cadastrarViagem(Viagem viagem) throws ViagemJaCadastradaException {
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
  public Viagem consultarViagem(Local origem, Local destino, Data partida, Data chegada) throws ViagemInexistenteException {
      return repositorioViagens.consultarViagem(origem, destino, partida, chegada);
  }

  public String mostrarTodosAsViagens() {
    return repositorioViagens.mostrarTodosAsViagens();
  }
}
