package controladores;

import repositorios.viajantes.IRepositorioViajantes;
import entidades.Viajante;
import excecoes.viajante.*;
import java.util.ArrayList;

public class ControladorViajantes {
  private IRepositorioViajantes repositorioViajantes;

  public ControladorViajantes(IRepositorioViajantes repositorioViajantes) {
    this.repositorioViajantes = repositorioViajantes;
  }

  public ArrayList<Viajante> listarViajantes() {
    return repositorioViajantes.listarViajantes();
  }

  public void cadastrarViajante(Viajante viajante) throws ViajanteJaCadastradoException {
    try {
      this.repositorioViajantes.cadastrarViajante(viajante);
    } catch (ViajanteJaCadastradoException excecao) {
      throw new ViajanteJaCadastradoException();
    }
  }

  public Viajante pesquisarViajante(String cpf) throws ViajanteInexistenteException {
    try {
      return this.repositorioViajantes.pesquisarViajante(cpf);
    } catch (ViajanteInexistenteException excecao) {
      throw new ViajanteInexistenteException();
    }
  }

  public String mostrarTodosViajantes() {
    return this.repositorioViajantes.mostrarTodosViajantes();
  }
}
