/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;
import entidades.*;
import java.util.ArrayList;
import controladores.*;
import repositorios.carros.IRepositorioCarros;
import repositorios.hoteis.IRepositorioHoteis;
import repositorios.viagens.IRepositorioViagens;
import repositorios.viajantes.IRepositorioViajantes;
import excecoes.carros.*;
import excecoes.hoteis.*;
import excecoes.locais.LocalJaCadastradoException;
import excecoes.locais.LocalNaoExisteException;
import excecoes.viajante.*;
import excecoes.viagem.*;
import fabrica.carros.*;
import fabrica.viajantes.*;
import fabrica.hoteis.*;
import fabrica.locais.FabricaLocais;
import fabrica.locais.IFabricaLocais;
import fabrica.viagens.*;
import java.util.Collection;
import repositorios.locais.IRepositorioLocais;
/**
 *
 * @author Wendell
 */
public class Fachada {
    private ControladorCarros controladorCarros;
  private ControladorViajantes controladorViajantes;
  private ControladorHoteis controladorHoteis;
  private ControladorViagens controladorViagens;
  private ControladorLocais controladorLocais;
  private IFabricaCarros fabricaCarros = null;
  private IFabricaViajantes fabricaViajantes = null;
  private IFabricaHoteis fabricaHoteis = null;
  private IFabricaViagens fabricaViagens = null;
  private IFabricaLocais fabricaLocais = null;
  private static Fachada fachada = null;

  public static Fachada getInstance() {
    if (fachada == null)
      fachada = new Fachada();
    return fachada;
  }

  private Fachada() {
    // Para viajantes
    this.fabricaViajantes = new FabricaViajantesMemoria();
    IRepositorioViajantes repositorioViajantes = fabricaViajantes.getRepositorioViajantes();
    this.controladorViajantes = new ControladorViajantes(repositorioViajantes);
    // Para carros
    this.fabricaCarros = new FabricaCarrosMemoria();
    IRepositorioCarros repositorioCarros = fabricaCarros.getRepositorioCarros();
    this.controladorCarros = new ControladorCarros(repositorioCarros);
    // Para hoteis
    this.fabricaHoteis = new FabricaHoteisMemoria();
    IRepositorioHoteis repositorioHoteis = fabricaHoteis.getRepositorioHoteis();
    this.controladorHoteis = new ControladorHoteis(repositorioHoteis);
    // Para viagens
    this.fabricaViagens = new FabricaViagensMemoria();
    IRepositorioViagens repositorioViagens = fabricaViagens.getRepositorioViagens();
    this.controladorViagens = new ControladorViagens(repositorioViagens);
    this.fabricaLocais = new FabricaLocais();
    IRepositorioLocais repositorioLocais = fabricaLocais.getRepositorioLocais();
    this.controladorLocais = new ControladorLocais(repositorioLocais);
  }

  // viajante
  public void cadastrarViajante(Viajante viajante) throws ViajanteJaCadastradoException {
    try {
      controladorViajantes.cadastrarViajante(viajante);
    } catch (ViajanteJaCadastradoException excecao) {
      throw new ViajanteJaCadastradoException();
    }
  }

  public Viajante pesquisarViajante(String cpf) throws ViajanteInexistenteException {
    try {
      return controladorViajantes.pesquisarViajante(cpf);
    } catch (ViajanteInexistenteException excecao) {
      throw new ViajanteInexistenteException();
    }
  }
  
  public ArrayList<Viajante> listarViajantes() {
    return controladorViajantes.listarViajantes();
  }

  public String mostrarTodosViajantes() {
    return this.controladorViajantes.mostrarTodosViajantes();
  }

  // carros
  public void cadastrarCarro(Carro carro) throws CarroJaCadastradoException {
    try {
      controladorCarros.cadastrarCarro(carro);
    } catch (CarroJaCadastradoException exception) {
      throw new CarroJaCadastradoException();
    }
  }

  public Carro pesquisarCarro(String placa) throws CarroInexistenteException {
    try {
      return controladorCarros.pesquisarCarro(placa);
    } catch (CarroInexistenteException excecao) {
      throw new CarroInexistenteException();
    }
  }

  public Carro alugarCarro(String placa, Data dataRetirada, Data dataDevolucao, int diasAlugado)
      throws CarroJaAlugadoException, CarroInexistenteException {
    try {
      return controladorCarros.alugarCarro(placa, dataRetirada, dataDevolucao, diasAlugado);
    } catch (CarroJaAlugadoException excecao) {
      throw new CarroJaAlugadoException();
    } catch (CarroInexistenteException excecao) {
      throw new CarroInexistenteException();
    }
  }

  public void devolver(String placa) throws CarroInexistenteException, CarroNaoAlugadoException {
    try {
      controladorCarros.devolverCarro(placa);
    } catch (CarroInexistenteException excecao) {
      throw new CarroInexistenteException();
    } catch (CarroNaoAlugadoException excecao) {
      throw new CarroNaoAlugadoException();
    }
  }

  public double calcularPreco(Carro carro) {
    return controladorCarros.calcularPreco(carro);
  }

  public String mostrarTodosCarros() {
    return controladorCarros.mostrarTodosCarros();

  }

  // hoteis
  public void cadastrarHotel(Hotel hotel) throws HotelJaExistenteException {
    try {
      controladorHoteis.cadastrarHotel(hotel);
    } catch (HotelJaExistenteException e) {
      throw e;
    }
  }

  public ArrayList<Hotel> listarHoteis() {
    return controladorHoteis.listarHoteis();
  }

  public Quarto checkIn(String nomeHotel, Viajante viajante, Data checkIn, Data checkOut, int diasAlugado)
      throws HotelNaoExistenteException, HotelLotadoException {
    try {
      return controladorHoteis.checkIn(nomeHotel, viajante, checkIn, checkOut, diasAlugado);
    } catch (HotelNaoExistenteException e) {
      throw e;
    } catch (HotelLotadoException e) {
      throw e;
    }
  }

  public Quarto checkOut(Viajante viajante, String nomeHotel)
      throws HotelNaoExistenteException, ViajanteNaoEstaNoHotelException {
    try {
      return controladorHoteis.checkOut(viajante, nomeHotel);
    } catch (HotelNaoExistenteException e) {
      throw e;
    } catch (ViajanteNaoEstaNoHotelException e) {
      throw e;
    }
  }

  public void removerHotel(String nome) throws HotelNaoExistenteException {
    try {
      controladorHoteis.removerHotel(nome);
    } catch (HotelNaoExistenteException e) {
      throw e;
    }
  }

  public void cadastrarQuarto(String nome, Quarto quarto) throws HotelNaoExistenteException {
    try {
      controladorHoteis.cadastrarQuarto(nome, quarto);
    } catch (HotelNaoExistenteException e) {
      throw e;
    }
  }

  public void removerQuarto(String nome, Quarto quarto) throws HotelNaoExistenteException {
    try {
      controladorHoteis.removerQuarto(nome, quarto);
    } catch (HotelNaoExistenteException e) {
      throw e;
    }
  }

  public Hotel pesquisarHotel(String nome) throws HotelNaoExistenteException {
    try {
      return controladorHoteis.pesquisarHotel(nome);
    } catch (HotelNaoExistenteException e) {
      throw e;
    }
  }

  public void atualizar(Hotel hotel) throws HotelNaoExistenteException, HotelJaExistenteException {
    try {
      controladorHoteis.atualizar(hotel);
    } catch (HotelNaoExistenteException e) {
      throw e;
    } catch (HotelJaExistenteException e) {
      throw e;
    }
  }

  public String mostrarTodosHoteis() {
    return controladorHoteis.mostrarTodosHoteis();
  }

  public String mostrarTodosQuartos(Hotel hotel) {
    return controladorHoteis.mostrarTodosQuartos(hotel);
  }

  // viagens
  public ArrayList<Viagem> listaViagens() {
    return controladorViagens.listaViagens();
  }

  public void cadastrarViagem(Viagem viagem) {
    controladorViagens.cadastrarViagem(viagem);
  }

  public void removerViagem(Viagem viagem) throws ViagemInexistenteException {
    try {
      controladorViagens.removerViagem(viagem);
    } catch (ViagemInexistenteException excecao) {
      throw excecao;
    }
  }

  public Viagem consultarViagemPeloID(int id) throws ViagemInexistenteException {
    try {
      return controladorViagens.consultarViagemPeloID(id);
    } catch (ViagemInexistenteException excecao) {
      throw excecao;
    }
  }

  public String mostrarTodosAsViagens() {
    return controladorViagens.mostrarTodosAsViagens();
  }
  /**
   * 
   */
  public void cadastrarLocal(Local local) throws LocalJaCadastradoException{
      controladorLocais.inserir(local);
  }
  
  public Local pesquisarLocal(String estado, String cidade) throws LocalNaoExisteException{
      return controladorLocais.pesquisarLocal(estado, cidade);
  }
  
  public Collection<Local> listarLocais(){
      return controladorLocais.listarLocais();
  }
}
