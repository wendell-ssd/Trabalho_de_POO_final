package repositorios.carros;

import java.util.ArrayList;
import entidades.Carro;
import entidades.Data;
import excecoes.carros.*;

public class RepositorioCarrosMemoria implements IRepositorioCarros {
  private static ArrayList<Carro> carros = new ArrayList<Carro>();

  public ArrayList<Carro> listarCarros() {
    return carros;
  }

  public void cadastrarCarro(Carro carro) throws CarroJaCadastradoException {
    try {
      if(pesquisarCarro(carro.getPlaca()) != null) throw new CarroJaCadastradoException();
    } catch (CarroInexistenteException excecao) {
      carros.add(carro);
    }
  }

  public Carro pesquisarCarro(String placa) throws CarroInexistenteException {
    Carro carroBuscado = null;
    for (Carro carro : carros) {
      if (carro.getPlaca().equals(placa)) {
          carroBuscado = carro;
          break;
      }
    }
    if(carroBuscado == null) throw new CarroInexistenteException();
    return carroBuscado;
  }

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

  public double calcularPreco(Carro carro) {
    return carro.calcularPreco();
  }

  public String mostrarTodosCarros() {
    String string = "";
    for (Carro carro : carros) {
      string = string + this.mostrarAtributosCarros(carro);
    }
    return string;
  }

  private String mostrarAtributosCarros(Carro carro) {
    String string = "";
    string = string + "Placa: " + carro.getPlaca() + "\n";
    string = string + "Modelo: " + carro.getModelo().toString() + "\n";
    string = string + "Cidade: " + carro.getlocal().getCidade()+ "\n";
    string = string + "Alugado: " + carro.getAlugado() + "\n";
    string = string + "Empresa: " + carro.getEmpresa() + "\n";
    string = string + "Preco: " + carro.getPrecoAluguel() + "\n\n";
    return string;
  }
}
