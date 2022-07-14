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
import excecoes.passagens.PassagemInexistenteException;
import excecoes.passagens.PassagemJaCadastradaException;
import excecoes.viajante.*;
import excecoes.viagem.*;
import fabrica.carros.*;
import fabrica.viajantes.*;
import fabrica.hoteis.*;
import fabrica.locais.FabricaLocais;
import fabrica.locais.IFabricaLocais;
import fabrica.passagens.FabricaPassagens;
import fabrica.passagens.IFabricaPassagens;
import fabrica.viagens.*;
import java.util.Collection;
import repositorios.locais.IRepositorioLocais;
import repositorios.passagens.IRepositorioPassagens;

/**
 * Classe de padrão singleton criada para interagir com a interface gráfica de
 * usuário.
 * Possui 8 objetos do tipo controlador e fábrica, referentes às entidades
 * Carro, Viajante, Viagem e Hotel.
 * Inclui métodos para cadastrar, remover, listar e pesquisar para todas essas
 * entidades.
 * 
 * @author Eliabe, Igor, Gabriel, Wendell, Weatherly
 */

public class Fachada {
  private ControladorCarros controladorCarros;
  private ControladorViajantes controladorViajantes;
  private ControladorHoteis controladorHoteis;
  private ControladorViagens controladorViagens;
  private ControladorLocais controladorLocais;
  private ControladorPassagens controladorPassagens;
  private IFabricaCarros fabricaCarros = null;
  private IFabricaViajantes fabricaViajantes = null;
  private IFabricaHoteis fabricaHoteis = null;
  private IFabricaViagens fabricaViagens = null;
  private IFabricaLocais fabricaLocais = null;
  private IFabricaLocais fabricaFabricaLocais = null;
  private IFabricaPassagens fabricaPassagens = null;
  private static Fachada fachada = null;

  /**
   * Metodo estático que configura a fachada como singleton. Só pode ser iniciado
   * uma vez no programa, do contrário o método retorna a mesma fachada que foi
   * criada antes.
   * 
   * @return - Uma fachada.
   */
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
    // Para locais
    this.fabricaLocais = new FabricaLocais();
    IRepositorioLocais repositorioLocais = fabricaLocais.getRepositorioLocais();
    this.controladorLocais = new ControladorLocais(repositorioLocais);
    // Para passagens
    this.fabricaPassagens = new FabricaPassagens();
    IRepositorioPassagens repositorioPassagens = fabricaPassagens.getRepositorioPassagens();
    this.controladorPassagens = new ControladorPassagens(repositorioPassagens);
  }

  // viajante
  /**
   * Metodo que cadastra um viajante no repositório viajantes chamando seu
   * controlador.
   * 
   * @param viajante - Viajante que será cadastrado
   * @throws ViajanteJaCadastradoException - Viajante já consta na lista de
   *                                       viajantes cadastrados.
   */
  public void cadastrarViajante(Viajante viajante) throws ViajanteJaCadastradoException {
    try {
      controladorViajantes.cadastrarViajante(viajante);
    } catch (ViajanteJaCadastradoException excecao) {
      throw new ViajanteJaCadastradoException();
    }
  }

  /**
   * Metodo que busca um viajante no repositorio viajantes, a partir de seu
   * controlador
   * 
   * @param cpf - CPF do viajante que queremos buscar.
   * @return - O cliente que buscamos, se ele estiver registrado.
   * @throws ViajanteInexistenteException - Levanta essa exceção quando o viajante
   *                                      que buscamos não consta no sistema.
   */
  public Viajante pesquisarViajante(String cpf) throws ViajanteInexistenteException {
    try {
      return controladorViajantes.pesquisarViajante(cpf);
    } catch (ViajanteInexistenteException excecao) {
      throw new ViajanteInexistenteException();
    }
  }

  /**
   * Metodo que lista todos os viajantes registrados a partir de seu controlador.
   * 
   * @return - Lista de viajantes contidos no programa.
   */
  public ArrayList<Viajante> listarViajantes() {
    return controladorViajantes.listarViajantes();
  }

  /**
   * Metodo que retorna um String referente a todos os viajantes registrados.
   * 
   * @return - String referente a cada viajante
   * @deprecated
   */
  public String mostrarTodosViajantes() {
    return this.controladorViajantes.mostrarTodosViajantes();
  }

  // carros
  /**
   * Metodo que cadastra um carro em repositorioCarros chamando seu controlador.
   * 
   * @param carro - Carro que será cadastrado
   * @throws CarroJaCadastradoException - Carro já consta na lista de carros
   *                                    cadastrados.
   */
  public void cadastrarCarro(Carro carro) throws CarroJaCadastradoException {
    try {
      controladorCarros.cadastrarCarro(carro);
    } catch (CarroJaCadastradoException exception) {
      throw new CarroJaCadastradoException();
    }
  }

  /**
   * Metodo que busca um carro em repositórioCarros a partir do seu controlador.
   * 
   * @param placa - Placa do carro que buscamos
   * @return - Carro com a placa buscada
   * @throws CarroInexistenteException - Exceção levantada quando o carro que
   *                                   buscamos não consta na lista de carros
   *                                   cadastrados
   */
  public Carro pesquisarCarro(String placa) throws CarroInexistenteException {
    try {
      return controladorCarros.pesquisarCarro(placa);
    } catch (CarroInexistenteException excecao) {
      throw new CarroInexistenteException();
    }
  }

  public Collection<Carro> listarCarros() {
    return controladorCarros.listarCarros();
  }

  /**
   * Metodo que aluga um carro a partir do controlador.
   * 
   * @param placa         - placa do carro que desejamos alugar.
   * @param dataRetirada  - Data referente ao dia que o carro foi retirado do
   *                      local.
   * @param dataDevolucao - Data referente ao dia da devolução.
   * @param diasAlugado   - Quantidade de dias que o carro ficará indisponível.
   * @return - O carro alugado.
   * @throws CarroJaAlugadoException   - Levantada quando o carro com essa placa
   *                                   tem atributo alugado true.
   * @throws CarroInexistenteException - Levantada quando o carro com essa placa
   *                                   não está registrado no sistema.
   */
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

  /**
   * Metodo que "devolve" um carro que tinha sido alugado anteriormente a partir
   * do controlador.
   * 
   * @param placa - Placa do carro que já foi alugado.
   * @throws CarroInexistenteException - Levantada quando a placa do carro não
   *                                   consta no repositório.
   * @throws CarroNaoAlugadoException  - Levantada quando o carro não foi alugado.
   */
  public void devolver(String placa) throws CarroInexistenteException, CarroNaoAlugadoException {
    try {
      controladorCarros.devolverCarro(placa);
    } catch (CarroInexistenteException excecao) {
      throw new CarroInexistenteException();
    } catch (CarroNaoAlugadoException excecao) {
      throw new CarroNaoAlugadoException();
    }
  }

  /**
   * Metodo que calcula o preço que o cliente irá pagar ao alugar o carro por uma
   * quantidade de dias.
   * 
   * @param carro - Carro que está alugado.
   * @return - Preço do calculo.
   */
  public double calcularPreco(Carro carro) {
    return controladorCarros.calcularPreco(carro);
  }

  /**
   * Metodo auxiliar que mostra todos os carros como strings chamando o
   * controlador
   * 
   * @return - Todos os carros registrados
   * @deprecated
   */
  public String mostrarTodosCarros() {
    return controladorCarros.mostrarTodosCarros();

  }

  // hoteis
  /**
   * Metodo que cadastra um Hotel em repositorioHoteis chamando seu controlador.
   * 
   * @param Hotel - Hotel que será cadastrado
   * @throws HotelJaExistenteException - Hotel já consta na lista de Hoteis
   *                                   cadastrados.
   */
  public void cadastrarHotel(Hotel hotel) throws HotelJaExistenteException {
    try {
      controladorHoteis.cadastrarHotel(hotel);
    } catch (HotelJaExistenteException e) {
      throw e;
    }
  }

  /**
   * Metodo que lista todos os hoteis cadastrados no sistema a partir do
   * controlador.
   * 
   * @return - Todos hoteis registrados.
   */
  public ArrayList<Hotel> listarHoteis() {
    return controladorHoteis.listarHoteis();
  }

  /**
   * Metodo que reserva um quarto de hotel a partir do controlador.
   * 
   * @param nomeHotel   - nome do hotel em que o quarto está contido.
   * @param viajante    - nome do cliente que será responsável pelo quarto.
   * @param checkIn     - Data que o cliente pretende reservar o quarto.
   * @param checkOut    - Data que o cliente pretende liberar o quarto.
   * @param diasAlugado - Dias entre a data de check-in e a data de checkout.
   * @return - Quarto reservado.
   * @throws HotelNaoExistenteException - Levantada quando o Hotel não está
   *                                    registrado em sua lista.
   * @throws HotelLotadoException       - Levantada quando não existem quartos
   *                                    disponíveis para serem alugados.
   */
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

  /**
   * Metodo que libera um quarto de hotel a partir do controlador.
   * 
   * @param viajante  - Viajante titular do quarto
   * @param nomeHotel - Hotel que o quarto está contido
   * @return - Quarto liberado
   * @throws HotelNaoExistenteException      Levantada quando o hotel não consta
   *                                         na lista de hoteis
   * @throws ViajanteNaoEstaNoHotelException Levantada quando o viajante não está
   *                                         hospedado em nenhum quarto do hotel.
   */
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

  /**
   * Metodo que remove um Hotel do sistema, chamando seu controlador.
   * 
   * @param nome - Nome do hotel que será removido.
   * @throws HotelNaoExistenteException Nome do hotel não consta no sistema.
   */
  public void removerHotel(String nome) throws HotelNaoExistenteException {
    try {
      controladorHoteis.removerHotel(nome);
    } catch (HotelNaoExistenteException e) {
      throw e;
    }
  }

  /**
   * Metodo que cadastra um Quarto em um hotel chamando o controlador do hotel.
   * 
   * @param quarto - Quarto que será cadastrado
   * @param nome   - String que representa o nome de um hotel
   * @throws HotelNaoExistenteException - Hotel em que desejamos registrar o
   *                                    quarto não consta na lista de hoteis.
   */
  public void cadastrarQuarto(String nome, Quarto quarto) throws HotelNaoExistenteException {
    try {
      controladorHoteis.cadastrarQuarto(nome, quarto);
    } catch (HotelNaoExistenteException e) {
      throw e;
    }
  }

  /**
   * Metodo que remove um Quarto em um hotel do sistema, chamando o controlador do
   * hotel
   * 
   * @param nome   - Nome do hotel que contém o quarto
   * @param quarto - Quarto que será removido
   * @throws HotelNaoExistenteException - Levantada quando o nome do hotel não
   *                                    corresponde a um hotel já cadastrado
   */
  public void removerQuarto(String nome, Quarto quarto) throws HotelNaoExistenteException {
    try {
      controladorHoteis.removerQuarto(nome, quarto);
    } catch (HotelNaoExistenteException e) {
      throw e;
    }
  }

  /**
   * Metodo que busca um hotel registrado, chamando seu controlador
   * 
   * @param nome - Nome do hotel que será buscado
   * @return - Hotel buscado
   * @throws HotelNaoExistenteException - Levantado se o retorno for nulo, o hotel
   *                                    não está registrado no sistema.
   */
  public Hotel pesquisarHotel(String nome) throws HotelNaoExistenteException {
    try {
      return controladorHoteis.pesquisarHotel(nome);
    } catch (HotelNaoExistenteException e) {
      throw e;
    }
  }

  /**
   * Metodo que atualiza as informações de um hotel já registrado, a partir do
   * controlador
   * 
   * @param hotel - Hotel que terá as informações atualizadas
   * @throws HotelNaoExistenteException - Levantado quando o hotel não consta no
   *                                    sistema
   */
  public void atualizar(Hotel hotel) throws HotelNaoExistenteException, HotelJaExistenteException {
    try {
      controladorHoteis.atualizar(hotel);
    } catch (HotelNaoExistenteException e) {
      throw e;
    } catch (HotelJaExistenteException e) {
      throw e;
    }
  }

  /**
   * Metodo que mostra todos os hoteis registrados em forma de string, a partir do
   * controlador
   * 
   * @return - Todos os nomes dos hoteis cadastrados
   * @deprecated
   */
  public String mostrarTodosHoteis() {
    return controladorHoteis.mostrarTodosHoteis();
  }

  /**
   * Metodo que mostra todos os quartos registrados em um hotel, a partir do
   * controlador de hoteis
   * 
   * @param hotel - Hotel que estão contidos os quartos
   * @return - Todos os Quartos no hotel
   */
  public String mostrarTodosQuartos(Hotel hotel) {
    return controladorHoteis.mostrarTodosQuartos(hotel);
  }

  // viagens
  /**
   * Metodo que retorna todas as viagens cadastradas no sistema, a partir do
   * controlador de viagens.
   * 
   * @return - Todas as viagens registradas no sistema.
   */
  public ArrayList<Viagem> listaViagens() {
    return controladorViagens.listaViagens();
  }

  /**
   * Metodo que cadastra uma viagem no sistema, a partir do controlador de
   * viagens.
   * 
   * @param viagem - Viagem que precisa ser cadastrada
   */
  public void cadastrarViagem(Viagem viagem) throws ViagemJaCadastradaException {
    controladorViagens.cadastrarViagem(viagem);
  }

  /**
   * Metodo que remove uma viagem da lista de viagens, usando o controlador
   * 
   * @param viagem - Viagem que será removida
   * @throws ViagemInexistenteException - Levantada quando a viagem não consta na
   *                                    lista de viagens
   */
  public void removerViagem(Viagem viagem) throws ViagemInexistenteException {
    try {
      controladorViagens.removerViagem(viagem);
    } catch (ViagemInexistenteException excecao) {
      throw excecao;
    }
  }

  /**
   * Metodo que verifica a existência de uma viagem na lista de viagens a partir
   * do id, usando o controlador de viagens
   * 
   * @param id - ID da viagem que será buscada
   * @return - Viagem buscada
   * @throws ViagemInexistenteException - Levantada quando a viagem buscada não
   *                                    consta na lista de viagens
   */
  public Viagem consultarViagemPeloID(int id) throws ViagemInexistenteException {
    try {
      return controladorViagens.consultarViagemPeloID(id);
    } catch (ViagemInexistenteException excecao) {
      throw excecao;
    }
  }

  /**
   * Metodo que consulta a viagem baseada nos parametros abaixo
   * 
   * @param origem
   * @param destino
   * @param partida
   * @param chegada
   * @return - Viagem buscada
   * @throws ViagemInexistenteException - Levantada quando a viagem buscada não
   *                                    consta na lista de viagens
   */
  public Viagem consultarViagem(Local origem, Local destino, Data partida, Data chegada)
      throws ViagemInexistenteException {
    return controladorViagens.consultarViagem(origem, destino, partida, chegada);
  }

  /**
   * Metodo que mostra todas as viagens no formato de String
   * 
   * @return - Todas as viagens registradas
   * @deprecated
   */
  public String mostrarTodosAsViagens() {
    return controladorViagens.mostrarTodosAsViagens();
  }

  // Locais
  /**
   * Metodo que cadastra um local na lista de locais, a partir de seu controlador
   * 
   * @param local - Local que será cadastrado
   * @throws LocalJaCadastradoException - Local Já consta na coleção de locais
   */
  public void cadastrarLocal(Local local) throws LocalJaCadastradoException {
    controladorLocais.inserir(local);
  }

  /**
   * Metodo que busca um local na lista de locais, a partir de seu controlador.
   * 
   * @param estado - Estado federativo do local buscado.
   * @param cidade - Município do local buscado.
   * @return - Local buscado.
   * @throws LocalNaoExisteException - Levantado quando o local não consta na
   *                                 coleção de locais.
   */
  public Local pesquisarLocal(String estado, String cidade) throws LocalNaoExisteException {
    return controladorLocais.pesquisarLocal(estado, cidade);
  }

  /**
   * Metodo que lista todos os locais registrados, a partir do seu controlador.
   * 
   * @return - Todos os locais da coleção de locais
   */
  public Collection<Local> listarLocais() {
    return controladorLocais.listarLocais();
  }

  /**
   * Metodo que cadastra passagem
   * 
   * @param - o objeto passagem que será cadastradao
   * @return - a passagem cadastrada
   */
  public void cadastrarPassagem(Passagem passagem) throws PassagemJaCadastradaException {
    controladorPassagens.inserir(passagem);
  }

  /**
   * Metodo que lista passagens
   * 
   * @return - o array list de passagens cadastradas
   */
  public Collection<Passagem> listarPassagens() {
    return controladorPassagens.listarPessoas();
  }

  /**
   * Metodo que pesquisa passagem
   * 
   * @param - passa o id da passagem
   * @return - a passagem cadastrada
   */
  public Passagem pesquisarPassagem(int idPassagem) throws PassagemInexistenteException {
    return controladorPassagens.pesquisarPassagem(idPassagem);
  }
}
