/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorios.viagens;

import entidades.Viagem;
import java.util.ArrayList;
import excecoes.viagem.*;
/**
 *
 * @author Eliabe
 */
public interface IRepositorioViagens {
  public ArrayList<Viagem> listarViagens();

  public void cadastrarViagem(Viagem viagem);

  public void removerViagem(Viagem viagem) throws ViagemInexistenteException;

  public Viagem consultarViagemPeloID(int id) throws ViagemInexistenteException;

  public String mostrarTodosAsViagens();
    
}
