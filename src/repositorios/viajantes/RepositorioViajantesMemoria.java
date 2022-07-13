package repositorios.viajantes;

import java.util.ArrayList;
import entidades.Viajante;
import excecoes.viajante.*;

public class RepositorioViajantesMemoria implements IRepositorioViajantes {
  private static ArrayList<Viajante> viajantes = new ArrayList<Viajante>();

  public ArrayList<Viajante> listarViajantes() {
    return viajantes;
  }

  public void cadastrarViajante(Viajante viajante) throws ViajanteJaCadastradoException {
    try {
        if(pesquisarViajante(viajante.getCpf()) != null) throw new ViajanteJaCadastradoException();
    } catch (ViajanteInexistenteException exception) {
      viajantes.add(viajante);
    }

  }

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

  public String mostrarTodosViajantes() {
    String string = "";
    for (Viajante viajante : viajantes) {
      string = string + this.informacoesViajante(viajante);
    }
    return string;
  }

  private String informacoesViajante(Viajante Viajante) {
    String string = "";
    string = string + Viajante.getNome() + "\n";
    string = string + Viajante.getIdade() + "\n";
    string = string + Viajante.getdataNascimento() + "\n";
    string = string + Viajante.getCpf() + "\n";
    return string;
  }
}
