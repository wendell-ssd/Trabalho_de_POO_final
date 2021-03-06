package repositorios.carros;

import entidades.Carro;
import entidades.Data;
import excecoes.carros.*;
import java.util.ArrayList;

/**
 * Essa Classe é uma interface que contém os métodos de carros, essa interface
 * deve ser implementada.
 * Contém um atributo de Lista de carros.
 * 
 * @see RepositorioCarrosMemoria
 * @see Carro
 * @author Eliabe Bastos
 * @since 2022-07-13
 */

public interface IRepositorioCarros {
  public ArrayList<Carro> listarCarros();

  public void cadastrarCarro(Carro carro)
      throws CarroJaCadastradoException;

  public Carro pesquisarCarro(String placa) throws CarroInexistenteException;

  public Carro alugarCarro(String placa, Data dataRetirada, Data dataDevolucao, int diasAlugado)
      throws CarroJaAlugadoException, CarroInexistenteException;

  public void devolverCarro(String placa) throws CarroNaoAlugadoException, CarroInexistenteException;

  public double calcularPreco(Carro carro);

  public String mostrarTodosCarros();
}
