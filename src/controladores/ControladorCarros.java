package controladores;

import entidades.Carro;
import entidades.Data;
import excecoes.carros.*;
import java.util.Collection;
import repositorios.carros.IRepositorioCarros;

/**
 * Essa classe abstrai o repositório de Carros, tem por objetivo controlar as
 * operações feitas pelo repositório.
 * 
 * @author Eliabe Bastos
 * @since 2022-07-13
 * @see IRepositorioCarros
 * @see RepositorioCarrosMemoria
 * @see Carro
 */

public class ControladorCarros {
  private IRepositorioCarros repositorioCarros;

  public ControladorCarros(IRepositorioCarros repositorioCarros) {
    this.repositorioCarros = repositorioCarros;
  }

  /**
   * Esse método tem o intuito de cadastrar os carros utilizando o repositorio,
   * bem como tratar a exceção.
   * 
   * @param carro - O carro que se quer cadastrar.
   * @throws CarroJaCadastradoException - é levantada caso o carro já esteja
   *                                    cadastrado.
   */
  public void cadastrarCarro(Carro carro)
      throws CarroJaCadastradoException {
    try {
      repositorioCarros.cadastrarCarro(carro);
    } catch (CarroJaCadastradoException exception) {
      throw new CarroJaCadastradoException();
    }
  }

  /**
   * Esse método serve para pesquisar/buscar um carro, tendo a sua placa. Faz a
   * conexão com o repositório.
   * 
   * @param placa - placa do carro que se quer pesquisar
   * @return Carro - retorna um tipo Carro, que é o carro que se quer buscar.
   * @throws CarroInexistenteException - é levantada quando o carro não é
   *                                   encontrado.
   */
  public Carro pesquisarCarro(String placa) throws CarroInexistenteException {
    try {
      return repositorioCarros.pesquisarCarro(placa);
    } catch (CarroInexistenteException exception) {
      throw new CarroInexistenteException();
    }
  }

  /**
   * Esse método é usado quando se quer alugar um carro. Faz uma conexão com o
   * repositório(Por intermédio dele).
   * 
   * @param placa         - a placa do carro que se quer alugar.
   * @param dataRetirada  - a data que se quer retirar o carro.
   * @param dataDevolucao - a data que se quer devolver o carro.
   * @param diasAlugado   - a quantidade de dias que o carro foi alugado.
   * @return Carro - o carro alugado.
   * @throws CarroJaAlugadoException   - É levantada quando o carro já está
   *                                   alugado.
   * @throws CarroInexistenteException - É levantada quando o carro que se quer
   *                                   alugar não existe.
   */
  public Carro alugarCarro(String placa, Data dataRetirada, Data dataDevolucao, int diasAlugado)
      throws CarroJaAlugadoException, CarroInexistenteException {
    try {
      return repositorioCarros.alugarCarro(placa, dataRetirada, dataDevolucao, diasAlugado);
    } catch (CarroJaAlugadoException exception) {
      throw new CarroJaAlugadoException();
    } catch (CarroInexistenteException exception) {
      throw new CarroInexistenteException();
    }
  }

  /**
   * Esse método serve quando se quer devolver um carro que já foi alugado, faz
   * uma conexão com o repositório.
   * 
   * @param placa - placa do carro que se quer devolver.
   * @throws CarroInexistenteException - É levantada quando o carro que se quer
   *                                   devolver não existe.
   * @throws CarroNaoAlugadoException  - É levantada quando o carro que se quer
   *                                   devolver não foi alugado.
   */
  public void devolverCarro(String placa) throws CarroInexistenteException, CarroNaoAlugadoException {
    try {
      repositorioCarros.devolverCarro(placa);
    } catch (CarroInexistenteException exception) {
      throw new CarroInexistenteException();
    } catch (CarroNaoAlugadoException exception) {
      throw new CarroNaoAlugadoException();
    }
  }

  /**
   * Esse método faz uma conexão com o repositório para calcular o preço do
   * aluguel do carro.
   * 
   * @param carro - O carro que foi alugado.
   * @return Double - O preço do aluguel do carro.
   */
  public double calcularPreco(Carro carro) {
    return repositorioCarros.calcularPreco(carro);
  }

  public Collection<Carro> listarCarros() {
    return repositorioCarros.listarCarros();
  }

  /**
   * Esse método serve para mostrar todos os carros, faz uma conexão com o
   * repositório.
   * 
   * @return String - retorna todos os carros.
   */
  public String mostrarTodosCarros() {
    return repositorioCarros.mostrarTodosCarros();
  }
}
