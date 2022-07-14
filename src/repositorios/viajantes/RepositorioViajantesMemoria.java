package repositorios.viajantes;

import java.util.ArrayList;
import entidades.Viajante;
import excecoes.viajante.*;

/**
 * Essa é uma classe que implementa a interface IRepositorioViagens que contém
 * os métodos de Viagem.
 * 
 * @see IRepositorioViajantes
 * @see Viajante
 * @author Gabriel Pinheiro.
 * @since 2022-07-13
 */

public class RepositorioViajantesMemoria implements IRepositorioViajantes {
  private static ArrayList<Viajante> viajantes = new ArrayList<Viajante>();

  /**
   * Esse método serve para listar os viajantes.
   * 
   * @return ArrayList - uma lista de viajantes.
   * 
   */
  public ArrayList<Viajante> listarViajantes() {
    return viajantes;
  }

  /**
   * Esse método serve para cadastrar o viajante
   * 
   * @param viajante - o viajante que se quer cadastrar.
   * @throws ViajanteJaCadastradoException - É levantada caso o viajante já esteja
   *                                       cadastrado.
   */
  public void cadastrarViajante(Viajante viajante) throws ViajanteJaCadastradoException {
    try {
      if (pesquisarViajante(viajante.getCpf()) != null)
        throw new ViajanteJaCadastradoException();
    } catch (ViajanteInexistenteException exception) {
      viajantes.add(viajante);
    }

  }

  /**
   * Esse método serve para pesquisar o viajante com base no seu cpf.
   * 
   * @param cpf - o cpf do viajante que se quer pesquisar.
   * @throws ViajanteInexistenteException - É levantada caso o Viajante não seja
   *                                      achado.
   * 
   */
  public Viajante pesquisarViajante(String cpf) throws ViajanteInexistenteException {
    Viajante viajanteBuscado = null;
    for (Viajante viajante : viajantes) {
      if (viajante.getCpf().equals(cpf)) {
        viajanteBuscado = viajante;
        break;
      }
    }
    if (viajanteBuscado == null) {
      throw new ViajanteInexistenteException();
    }
    return viajanteBuscado;
  }

  /**
   * Esse método serve para mostrar todos os viajantes
   * 
   * @return String - retorna todos os viajantes que foram cadastrados.
   */
  public String mostrarTodosViajantes() {
    String string = "";
    for (Viajante viajante : viajantes) {
      string = string + this.informacoesViajante(viajante);
    }
    return string;
  }

  /**
   * Esse método serve para mostrar as informações / atributos dos viajantes.
   * 
   * @param Viajante - o viajante que se quer ver as informações/atributos.
   * @return String - retorna os atributos/informações do viajante.
   */
  private String informacoesViajante(Viajante Viajante) {
    String string = "";
    string = string + Viajante.getNome() + "\n";
    string = string + Viajante.getIdade() + "\n";
    string = string + Viajante.getdataNascimento() + "\n";
    string = string + Viajante.getCpf() + "\n";
    return string;
  }
}
