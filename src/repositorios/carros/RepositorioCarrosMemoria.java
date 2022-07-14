package repositorios.carros;

import java.util.ArrayList;
import entidades.Carro;
import entidades.Data;
import excecoes.carros.*;

/**
 * Essa é uma classe que implementa a interface IRepositorioCarros que contém os
 * métodos de carros.
 * 
 * @see IRepositorioCarros
 * @see Carro
 * @author Eliabe Bastos
 * @since 2022-07-13
 */

public class RepositorioCarrosMemoria implements IRepositorioCarros {
  private static ArrayList<Carro> carros = new ArrayList<Carro>();

  /**
   * Esse método serve para listar os carros possíveis.
   * 
   * @return ArrayList - uma lista de carros.
   */
  public ArrayList<Carro> listarCarros() {
    return carros;
  }

  /**
   * Esse método possibilita o cadastro de carros.
   * 
   * @param carro - carro que deve ser cadastrado.
   * @throws CarroJaCadastradoException
   */
  public void cadastrarCarro(Carro carro) throws CarroJaCadastradoException {
    try {
      if (pesquisarCarro(carro.getPlaca()) != null)
        throw new CarroJaCadastradoException();
    } catch (CarroInexistenteException excecao) {
      carros.add(carro);
    }
  }

  /**
   * Esse método consiste em pesquisar, fazer uma busca pelo carro com base na
   * placa dele.
   * 
   * @param placa - placa do carro para ser pesquisado
   * @return
   * @throws CarroInexistenteException é levantada caso o carro não seja achado.
   */
  public Carro pesquisarCarro(String placa) throws CarroInexistenteException {
    Carro carroBuscado = null;
    for (Carro carro : carros) {
      if (carro.getPlaca().equals(placa)) {
        carroBuscado = carro;
        break;
      }
    }
    if (carroBuscado == null)
      throw new CarroInexistenteException();
    return carroBuscado;
  }

  /**
   * Esse método consiste em alugar um carro.
   * 
   * @param placa         - placa do carro a ser alugado.
   * @param dataRetirada  - data de retirada do carro.
   * @param dataDevolucao - data de devolucao.
   * @param diasAlugado   - dias que ficará alugado.
   * @return
   * @throws CarroJaAlugadoException   é levantada caso o carro já esteja alugado.
   * @throws CarroInexistenteException é levantada caso o carro não seja achado.
   */
  public Carro alugarCarro(String placa, Data dataRetirada, Data dataDevolucao, int diasAlugado)
      throws CarroJaAlugadoException, CarroInexistenteException {
    try {
      Carro carro = this.pesquisarCarro(placa);
      if (carro.getAlugado()) {
        throw new CarroJaAlugadoException();
      } else {
        carro.setAlugado(true);
        carro.setDiasAlugado(diasAlugado);
        return carro;
      }
    } catch (CarroInexistenteException exception) {
      throw new CarroInexistenteException();
    }
  }

  /**
   * Esse método consiste em devolver um carro que já foi alugado.
   * 
   * @param placa - placa do carro que irá ser devolvido.
   * @throws CarroNaoAlugadoException  é levantada caso o carro não esteja
   *                                   alugado.
   * @throws CarroInexistenteException é levantada caso o carro não seja achado.
   */
  public void devolverCarro(String placa) throws CarroNaoAlugadoException, CarroInexistenteException {
    try {
      Carro carro = this.pesquisarCarro(placa);
      if (carro.getAlugado()) {
        carro.setAlugado(false);
        carro.setDiasAlugado(0);
      } else {
        throw new CarroNaoAlugadoException();
      }
    } catch (CarroInexistenteException exception) {
      throw new CarroInexistenteException();
    }
  }

  /**
   * Esse método é para calcular o preço do aluguel do carro com base nos seus
   * atributos.
   * 
   * @param carro - carro que foi alugado.
   * @return Double - o preço do aluguel do carro.
   */
  public double calcularPreco(Carro carro) {
    return carro.calcularPreco();
  }

  /**
   * Esse método é utilizado para mostrar a lista de carros.
   * 
   * @return String mostrará o carro e os seus atributos. Um por um.
   */
  public String mostrarTodosCarros() {
    String string = "";
    for (Carro carro : carros) {
      string = string + this.mostrarAtributosCarros(carro);
    }
    return string;
  }

  /**
   * Esse método é para mostrar os atributos do carro, com base na placa, modelo,
   * cidade, se ele foi alugado,
   * a qual o carro pertence, a sua data de retirada, a sua data de devolucao e o
   * preço do seu aluguel.
   * 
   * @param carro - o carro no qual quer que os seus atributos sejam mostrados.
   * @return String - referente aos atributos do carro.
   */
  private String mostrarAtributosCarros(Carro carro) {
    String string = "";
    string = string + "Placa: " + carro.getPlaca() + "\n";
    string = string + "Modelo: " + carro.getModelo().toString() + "\n";
    string = string + "Cidade: " + carro.getlocal().getCidade() + "\n";
    string = string + "Alugado: " + carro.getAlugado() + "\n";
    string = string + "Empresa: " + carro.getEmpresa() + "\n";
    string = string + "Preco: " + carro.getPrecoAluguel() + "\n\n";
    return string;
  }
}
