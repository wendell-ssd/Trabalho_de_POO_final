/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorios.viagens;

import entidades.Data;
import entidades.Local;
import java.util.ArrayList;
import excecoes.viagem.*;
import entidades.Viagem;

/**
 * Essa é uma classe que implementa a interface IRepositorioViagens que contém
 * os métodos de Viagem.
 * 
 * @see IRepositorioViagens
 * @see Viagem
 * @author Weatherly Moura.
 * @since 2022-07-13
 */

public class RepositorioViagensMemoria implements IRepositorioViagens {
  private static ArrayList<Viagem> viagens = new ArrayList<Viagem>();

  /**
   * Esse método serve para listar as viagens.
   * 
   * @return ArrayList - uma lista de viagens.
   * 
   */
  public ArrayList<Viagem> listarViagens() {
    return viagens;
  }

  /**
   * Esse método serve para cadastrar uma viagem no Array.
   * 
   * @param viagem - a viagem que se quer cadastrar.
   */
  @Override
  public void cadastrarViagem(Viagem viagem) throws ViagemJaCadastradaException{
      try {
        if(consultarViagem(viagem) != null) throw new ViagemJaCadastradaException();
      } catch (Exception e) {
        viagens.add(viagem);
      }
  }

  /**
   * Esse método serve para remover uma viagem.
   * 
   * @param viagem - a viagem que se quer remover.
   * @throws ViagemInexistenteException - é levantada quando a viagem que se quer
   *                                    remover não é encontrada.
   */
  public void removerViagem(Viagem viagem) throws ViagemInexistenteException {
    try {
      Viagem viagemBuscada = consultarViagemPeloID(viagem.getID());
      viagens.remove(viagemBuscada);
    } catch (ViagemInexistenteException excecao) {
      throw new ViagemInexistenteException();
    }
  }

  /**
   * Esse método serve para consultar uma viagem pelo ID.
   * 
   * @param id - o id da viagem
   * @throws ViagemInexistenteException - é levantada quando pelo id, a viagem não
   *                                    é encontrada.
   * @return Viagem - retorna um objeto do tipo Viagem, que é a viagem que foi
   *         consultada.
   */
  public Viagem consultarViagemPeloID(int id) throws ViagemInexistenteException {
      Viagem viagemBuscada = null;
        for (Viagem viagem : viagens) {
          if (viagem.getID() == id) {
              viagemBuscada = viagem;
              break;
          }
        }
        if(viagemBuscada == null) throw new ViagemInexistenteException();
        return viagemBuscada;
  }
  /**
   * 
   * @param viagem
   * @return
   * @throws ViagemInexistenteException 
   */
  public Viagem consultarViagem(Viagem viagem) throws ViagemInexistenteException {
      Viagem viagemBuscada = null;
        for (Viagem v : viagens) {
          if (v == viagem) {
              viagemBuscada = viagem;
              break;
          }
        }
        if(viagemBuscada == null) throw new ViagemInexistenteException();
        return viagemBuscada;
  }
  /**
   * 
   * @param origem
   * @param destino
   * @param partida
   * @param chegada
   * @return
   * @throws ViagemInexistenteException 
   */
  public Viagem consultarViagem(Local origem, Local destino, Data partida, Data chegada) throws ViagemInexistenteException {
      Viagem viagemBuscada = null;
        for (Viagem v : viagens) {
          if (v.getOrigem().getEstado().equals(origem.getEstado()) && v.getDestino().getEstado().equals(destino.getEstado()) && v.getOrigem().getCidade().equals(origem.getCidade()) && v.getDestino().getCidade().equals(destino.getCidade()) && v.getDataPartida().getDia() == partida.getDia() && v.getDataPartida().getMes() == partida.getMes() && v.getDataPartida().getAno() == partida.getAno() && v.getDataChegada().getDia() == chegada.getDia() && v.getDataChegada().getMes() == chegada.getMes() && v.getDataChegada().getAno() == chegada.getAno()) {
              viagemBuscada = v;
              break;
          }
        }
        if(viagemBuscada == null) throw new ViagemInexistenteException();
        return viagemBuscada;
  }

  /**
   * Esse método mostra todas as viagens.
   * 
   * @return String - retorna uma string com as viagens e seus atributos.
   * 
   */
  public String mostrarTodosAsViagens() {
    String string = "";
    for (Viagem viagem : viagens) {
      string = string + this.mostrarAtributosViagem(viagem);
    }
    return string;
  }

  /**
   * Esse método serve para mostrar os atributos das viagens.
   * 
   * @param viagem - a viagem na qual quer se mostrar os atributos.
   * @return String - retorna uma string com os atributos das viagens.
   */
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
//    string = string + "Carro: " + viagem.getCarro() + "\n";
    return string;
  }
}
