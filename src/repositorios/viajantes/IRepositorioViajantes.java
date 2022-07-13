package repositorios.viajantes;

import entidades.Viajante;
import excecoes.viajante.*;
import java.util.ArrayList;

public interface IRepositorioViajantes {
  public ArrayList<Viajante> listarViajantes();

  public void cadastrarViajante(Viajante viajante) throws ViajanteJaCadastradoException;

  public Viajante pesquisarViajante(String cpf) throws ViajanteInexistenteException;

  public String mostrarTodosViajantes();
}
