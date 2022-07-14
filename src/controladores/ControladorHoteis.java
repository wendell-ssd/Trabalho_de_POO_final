package controladores;

import entidades.*;
import repositorios.hoteis.IRepositorioHoteis;
import java.util.*;
import excecoes.hoteis.*;

/**
 * Essa classe abstrai o repositório de Hoteis, tem por objetivo controlar as
 * operações feitas pelo repositório.
 * 
 * @author Igor Vasconcelos
 * @since 2022-07-13
 * @see IRepositorioHoteis
 * @see RepositorioHoteisMemoria
 * @see Hotel
 */

public class ControladorHoteis {
  private IRepositorioHoteis repositorioHoteis;

  /**
   * Esse método serve para fazer o checkIn do viajante. Utilizando a conexão com
   * o repositorio.
   * 
   * @param nomeHotel   - nome do hotel que foi escolhido.
   * @param viajante    - viajante que será hospedado.
   * @param checkIn     - data de checkin.
   * @param checkOut    - data de checkout.
   * @param diasAlugado - quantidade de dias de aluguel.
   * @return Quarto - retorna um objeto do tipo Quarto.
   * @throws HotelNaoExistenteException - é levantada quando o hotel dado não
   *                                    existe.
   * @throws HotelLotadoException       - É levantada quando o hotel está lotado.
   */
  public Quarto checkIn(String nomeHotel, Viajante viajante, Data checkIn, Data checkOut, int diasAlugado)
      throws HotelNaoExistenteException, HotelLotadoException {
    try {
      return repositorioHoteis.checkIn(nomeHotel, viajante, checkIn, checkOut, diasAlugado);
    } catch (HotelNaoExistenteException e) {
      throw e;
    } catch (HotelLotadoException e) {
      throw e;
    }
  }

  /**
   * Esse método serve para fazer o CheckOut do viajante. Utilizando a conexão com
   * o repositorio.
   * 
   * @param viajante  - O viajante que deseja fazer o CheckOut.
   * @param nomeHotel - O nome do hotel que está fazendo o CheckOut.
   * @return Quarto - o Quarto que foi feita a operação de checkout.
   * @throws HotelNaoExistenteException      - É levantada quando o Hotel não é
   *                                         achado.
   * @throws ViajanteNaoEstaNoHotelException - É levatanda quando o Viajante não
   *                                         está cadastrada no hotel.
   */
  public Quarto checkOut(Viajante viajante, String nomeHotel)
      throws HotelNaoExistenteException, ViajanteNaoEstaNoHotelException {
    try {
      return repositorioHoteis.checkOut(viajante, nomeHotel);
    } catch (HotelNaoExistenteException e) {
      throw e;
    } catch (ViajanteNaoEstaNoHotelException e) {
      throw e;
    }
  }

  public ControladorHoteis(IRepositorioHoteis repositorioHoteis) {
    this.repositorioHoteis = repositorioHoteis;
  }

  /**
   * Esse método serve para retornar todos os objetos armazenados no repositório
   * hoteis. Utilizando a conexão com o Repositório.
   * 
   * @return ArrayList<Hotel> - a lista de hoteis em questão
   */
  public ArrayList<Hotel> listarHoteis() {
    return repositorioHoteis.listarHoteis();
  }

  /**
   * Esse método serve para cadastrar um hotel. Utilizando a conexão com o
   * Repositório.
   * 
   * @param hotel - O hotel que se quer cadastrar.
   * @throws HotelJaExistenteException - É levantada quando o Hotel já está
   *                                   cadastrado.
   */
  public void cadastrarHotel(Hotel hotel) throws HotelJaExistenteException {
    try {
      repositorioHoteis.cadastrarHotel(hotel);
    } catch (HotelJaExistenteException e) {
      throw e;
    }
  }

  /**
   * Esse método serve para remover um hotel. Utilizando a conexão com o
   * Repositório.
   * 
   * @param nome - O nome do Hotel que se quer remover.
   * @throws HotelNaoExistenteException - É levantada quando o hotel não é
   *                                    encontrado.
   */
  public void removerHotel(String nome) throws HotelNaoExistenteException {
    try {
      repositorioHoteis.removerHotel(nome);
    } catch (HotelNaoExistenteException e) {
      throw e;
    }

  }

  /**
   * Esse método serve para cadastrar um quarto no hotel. Fazendo a conexão com o
   * repositório.
   * 
   * @param nome   - O nome do Hotel em que se quer cadastrar um quarto.
   * @param quarto - O quarto que se quer cadastrar.
   * @throws HotelNaoExistenteException - É levantada caso o Hotel não seja
   *                                    encontrado.
   */
  public void cadastrarQuarto(String nome, Quarto quarto) throws HotelNaoExistenteException {
    try {
      repositorioHoteis.cadastrarQuarto(nome, quarto);
    } catch (HotelNaoExistenteException e) {
      throw e;
    }

  }

  /**
   * Esse método serve para remover o quarto no hotel. Fazendo a conexão com o
   * repositório.
   * 
   * @param nome   - O nome do hotel em que se quer remover um quarto.
   * @param quarto - O quarto que se quer remover.
   * @throws HotelNaoExistenteException - É levantada quando o Hotel não é
   *                                    encontrado.
   */
  public void removerQuarto(String nome, Quarto quarto) throws HotelNaoExistenteException {
    try {
      repositorioHoteis.removerQuarto(nome, quarto);
    } catch (HotelNaoExistenteException e) {
      throw e;
    }
  }

  /**
   * Esse método é usado para procurar um hotel. Fazendo conexão com o
   * Repositório.
   * 
   * @param nome - O nome do hotel que se quer procurar.
   * @return Hotel - O hotel procurado.
   * @throws HotelNaoExistenteException - É levantada quando o Hotel não é
   *                                    encontrado.
   */
  public Hotel pesquisarHotel(String nome) throws HotelNaoExistenteException {
    try {
      return repositorioHoteis.pesquisarHotel(nome);
    } catch (HotelNaoExistenteException e) {
      throw e;
    }

  }

  /**
   * Esse método é utilizado quando se quer atualizar um dado do hotel. Fazendo
   * conexão com o Repositório.
   * 
   * @param hotel - O hotel em que se quer atualizar algum dado.
   * @throws HotelNaoExistenteException - É levantada quando o Hotel não é
   *                                    encontrado.
   * @throws HotelJaExistenteException  - É levantada quando o Hotel já está
   *                                    cadastrado.
   */
  public void atualizar(Hotel hotel) throws HotelNaoExistenteException, HotelJaExistenteException {
    try {
      repositorioHoteis.atualizar(hotel);
    } catch (HotelNaoExistenteException e) {
      throw e;
    } catch (HotelJaExistenteException e) {
      throw e;
    }
  }

  /**
   * Esse método serve para mostrar todos os hotéis. Fazendo conexão com o
   * Repositório.
   * 
   * @return String - retorna uma string com os hoteis que estão cadastrados.
   */
  public String mostrarTodosHoteis() {
    return repositorioHoteis.mostrarTodosHoteis();
  }

  /**
   * Esse método serve para mostrar todos os quartos de um hotel. Fazendo conexão
   * com o Repositório.
   * 
   * @return String - retorna uma string com os quartos que estão cadastrados de
   *         um hotel.
   */
  public String mostrarTodosQuartos(Hotel hotel) {
    return repositorioHoteis.mostrarTodosQuartos(hotel);
  }
}