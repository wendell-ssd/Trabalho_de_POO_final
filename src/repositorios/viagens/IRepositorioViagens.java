/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorios.viagens;

import entidades.Data;
import entidades.Local;
import entidades.Viagem;
import java.util.ArrayList;
import excecoes.viagem.*;

/**
 * Essa Classe é uma interface que contém os métodos de Viagem, essa interface
 * deve ser implementada.
 * Contém um atributo de lista de viagens.
 * 
 * @see RepositorioHoteisMemoria
 * @see Viagem
 * @author Weatherly Moura.
 * @since 2022-07-13
 * 
 */

public interface IRepositorioViagens {
  public ArrayList<Viagem> listarViagens();

  public void cadastrarViagem(Viagem viagem) throws ViagemJaCadastradaException;

  public void removerViagem(Viagem viagem) throws ViagemInexistenteException;

  public Viagem consultarViagemPeloID(int id) throws ViagemInexistenteException;
  
  public Viagem consultarViagem(Viagem viagem) throws ViagemInexistenteException;
  
  public Viagem consultarViagem(Local origem, Local destino, Data partida, Data chegada) throws ViagemInexistenteException;

  public String mostrarTodosAsViagens();

}
