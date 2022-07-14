package controladores;

import repositorios.viajantes.IRepositorioViajantes;
import entidades.Viajante;
import excecoes.viajante.*;
import java.util.ArrayList;

/**
 * Essa classe abstrai o repositório de Viajante, tem por objetivo controlar as
 * operações feitas pelo repositório.
 * 
 * @author Gabriel Pinheiro.
 * @since 2022-07-13
 * @see IRepositorioViajantes
 * @see RepositorioViajantesMemoria
 * @see Viajante
 */

public class ControladorViajantes {
  private IRepositorioViajantes repositorioViajantes;

  public ControladorViajantes(IRepositorioViajantes repositorioViajantes) {
    this.repositorioViajantes = repositorioViajantes;
  }

  /**
   * Esse método serve para retornar todos os objetos armazenados no repositório
   * Viajante. Utilizando a conexão com o Repositório.
   * 
   * @return ArrayList<Viajante> - a lista de viajante em questão
   */
  public ArrayList<Viajante> listarViajantes() {
    return repositorioViajantes.listarViajantes();
  }

  /**
   * Esse método serve para cadastrar um viajante no sistema. Faz conexão com o
   * repositório de viajante.
   * 
   * @param viajante - O viajante que se quer cadastrar.
   * @throws ViajanteJaCadastradoException - É levantada quando o viajante ja está
   *                                       cadastrado.
   */
  public void cadastrarViajante(Viajante viajante) throws ViajanteJaCadastradoException {
    try {
      this.repositorioViajantes.cadastrarViajante(viajante);
    } catch (ViajanteJaCadastradoException excecao) {
      throw new ViajanteJaCadastradoException();
    }
  }

  /**
   * Esse método serve para pesquisar um viajante que esteja cadastrado. Faz
   * conexão com o repositório de viajante.
   * 
   * @param cpf - O cpf do viajante que ser buscar.
   * @return Viajante - retorna o viajante buscado.
   * @throws ViajanteInexistenteException - É levantada quando o viajante não é
   *                                      encontrado.
   */
  public Viajante pesquisarViajante(String cpf) throws ViajanteInexistenteException {
    try {
      return this.repositorioViajantes.pesquisarViajante(cpf);
    } catch (ViajanteInexistenteException excecao) {
      throw new ViajanteInexistenteException();
    }
  }

  /**
   * Esse método serve para mostrar todos os viajantes que estão cadastrados. Faz
   * conexão com o repositório de viajantes.
   * 
   * @return String - retorna uma string que mostra os viajantes.
   */
  public String mostrarTodosViajantes() {
    return this.repositorioViajantes.mostrarTodosViajantes();
  }
}
