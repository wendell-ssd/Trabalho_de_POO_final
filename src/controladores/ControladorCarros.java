package controladores;

import entidades.Carro;
import entidades.Data;
import excecoes.carros.*;
import java.util.Collection;
import repositorios.carros.IRepositorioCarros;

public class ControladorCarros {
  private IRepositorioCarros repositorioCarros;

  public ControladorCarros(IRepositorioCarros repositorioCarros) {
    this.repositorioCarros = repositorioCarros;
  }

  public void cadastrarCarro(Carro carro)
      throws CarroJaCadastradoException {
    try {
      repositorioCarros.cadastrarCarro(carro);
    } catch (CarroJaCadastradoException exception) {
      throw new CarroJaCadastradoException();
    }
  }

  public Carro pesquisarCarro(String placa) throws CarroInexistenteException {
    try {
      return repositorioCarros.pesquisarCarro(placa);
    } catch (CarroInexistenteException exception) {
      throw new CarroInexistenteException();
    }
  }

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

  public void devolverCarro(String placa) throws CarroInexistenteException, CarroNaoAlugadoException {
    try {
      repositorioCarros.devolverCarro(placa);
    } catch (CarroInexistenteException exception) {
      throw new CarroInexistenteException();
    } catch (CarroNaoAlugadoException exception) {
      throw new CarroNaoAlugadoException();
    }
  }

  public double calcularPreco(Carro carro) {
    return repositorioCarros.calcularPreco(carro);
  }
  
  public Collection<Carro> listarCarros(){
    return repositorioCarros.listarCarros();
  }
  
  public String mostrarTodosCarros() {
    return repositorioCarros.mostrarTodosCarros();
  }
}
