package controladores;

/**
 * Essa classe abstrai o repositório de Viagens, tem por objetivo controlar as
 * operações feitas pelo repositório.
 * 
 * @author Weatherly Moura.
 * @since 2022-07-13
 * @see IRepositorioViagens
 * @see RepositorioViagensMemoria
 * @see Viagem
 */

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

  /**
   * Esse método serve para retornar todos os objetos armazenados no repositório
   * viagem. Utilizando a conexão com o Repositório.
   * 
   * @return ArrayList<Viagem> - a lista de viagem em questão
   */
  public ArrayList<Viagem> listaViagens() {
    return repositorioViagens.listarViagens();
  }

  /**
   * Esse método serve para cadastrar uma viagem. Fazendo a conexão com o
   * Repositório de viagens. Fazendo
   * conexão com o repositório.
   * 
   * @param viagem - a viagem que deve ser cadastrada.
   */
  public void cadastrarViagem(Viagem viagem) throws ViagemJaCadastradaException {
    repositorioViagens.cadastrarViagem(viagem);
  }

  /**
   * Esse método serve para remover uma viagem já cadastrada. Fazendo conexão com
   * o repositório.
   * 
   * @param viagem - a viagem que se quer remover.
   * @throws ViagemInexistenteException - É levantada quando a Viagem que quer ser
   *                                    removida não está cadastrada.
   */
  public void removerViagem(Viagem viagem) throws ViagemInexistenteException {
    try {
      repositorioViagens.removerViagem(viagem);
    } catch (ViagemInexistenteException excecao) {
      throw excecao;
    }
  }

  /**
   * Esse método serve para consultar uma viagem pelo Id da viagem. Fazendo
   * conexão com o repositório.
   * 
   * @param id - O id da viagem que quer ser consultada.
   * @return Viagem - a Viagem procurada.
   * @throws ViagemInexistenteException - É levantada quando a viagem não é
   *                                    encontrada.
   */
  public Viagem consultarViagemPeloID(int id) throws ViagemInexistenteException {
    try {
      return repositorioViagens.consultarViagemPeloID(id);
    } catch (ViagemInexistenteException excecao) {
      throw excecao;
    }
  }

  public Viagem consultarViagem(Local origem, Local destino, Data partida, Data chegada)
      throws ViagemInexistenteException {
    return repositorioViagens.consultarViagem(origem, destino, partida, chegada);
  }

  /**
   * Esse método serve para mostrar todas as viagens cadastradas. Fazendo conexão
   * com o repositório.
   * 
   * @return String - retorna as viagens que foram cadastradas.
   */
  public String mostrarTodosAsViagens() {
    return repositorioViagens.mostrarTodosAsViagens();
  }
}
