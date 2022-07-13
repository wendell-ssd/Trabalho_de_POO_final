/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorios.viagens;

import java.util.ArrayList;
import excecoes.viagem.*;
import entidades.Viagem;
/**
 *
 * @author Eliabe
 */
public class RepositorioViagensMemoria implements IRepositorioViagens{
    private static ArrayList<Viagem> viagens = new ArrayList<Viagem>();

  public ArrayList<Viagem> listarViagens() {
    return viagens;
  }

  public void cadastrarViagem(Viagem viagem) {
    viagens.add(viagem);
  }

  public void removerViagem(Viagem viagem) throws ViagemInexistenteException {
    try {
      Viagem viagemBuscada = consultarViagemPeloID(viagem.getID());
      viagens.remove(viagemBuscada);
    } catch (ViagemInexistenteException excecao) {
      throw new ViagemInexistenteException();
    }
  }

  public Viagem consultarViagemPeloID(int id) throws ViagemInexistenteException {
    for (Viagem viagem : viagens) {
      if (viagem.getID() == id) {
        return viagem;
      }
    }
    throw new ViagemInexistenteException();
  }

  public String mostrarTodosAsViagens() {
    String string = "";
    for (Viagem viagem : viagens) {
      string = string + this.mostrarAtributosViagem(viagem);
    }
    return string;
  }

  private String mostrarAtributosViagem(Viagem viagem) {
    String string = "";
    string = string + "ID: " + viagem.getID() + "\n";
    string = string + "Origem: " + viagem.getOrigem() + "\n";
    string = string + "Destino: " + viagem.getDestino() + "\n";
    string = string + "Numero do voo:" + viagem.getNumeroVoo() + "\n";
    string = string + "Data de partida: " + viagem.getDataPartida() + "\n";
    string = string + "Data de chegada: " + viagem.getDataChegada() + "\n";
    string = string + "Empresa: " + viagem.getEmpresa() + "\n";
    string = string + "Bagagens: " + viagem.getBagagens() + "\n";
    string = string + "Carro: " + viagem.getCarro() + "\n";
    return string;
  }
}
