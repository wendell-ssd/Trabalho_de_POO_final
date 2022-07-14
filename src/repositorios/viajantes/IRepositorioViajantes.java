package repositorios.viajantes;

import entidades.Viajante;
import excecoes.viajante.*;
import java.util.ArrayList;

/**
 * Essa Classe é uma interface que contém os métodos de Viajante, essa interface
 * deve ser implementada.
 * Contém um atributo de lista de viajantes.
 * 
 * @see RepositorioViajantesMemoria
 * @see Viajante
 * @author Gabriel Pinheiro.
 * @since 2022-07-13
 * 
 */

public interface IRepositorioViajantes {
  public ArrayList<Viajante> listarViajantes();

  public void cadastrarViajante(Viajante viajante) throws ViajanteJaCadastradoException;

  public Viajante pesquisarViajante(String cpf) throws ViajanteInexistenteException;

  public String mostrarTodosViajantes();
}
