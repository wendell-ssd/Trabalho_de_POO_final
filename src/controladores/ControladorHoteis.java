package controladores;

import entidades.*;
import repositorios.hoteis.IRepositorioHoteis;
import java.util.*;
import excecoes.hoteis.*;

public class ControladorHoteis {
  private IRepositorioHoteis repositorioHoteis;

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

  public ArrayList<Hotel> listarHoteis() {
    return repositorioHoteis.listarHoteis();
  }

  public void cadastrarHotel(Hotel hotel) throws HotelJaExistenteException {
    try {
      repositorioHoteis.cadastrarHotel(hotel);
    } catch (HotelJaExistenteException e) {
      throw e;
    }
  }

  public void removerHotel(String nome) throws HotelNaoExistenteException {
    try {
      repositorioHoteis.removerHotel(nome);
    } catch (HotelNaoExistenteException e) {
      throw e;
    }

  }

  public void cadastrarQuarto(String nome, Quarto quarto) throws HotelNaoExistenteException {
    try {
      repositorioHoteis.cadastrarQuarto(nome, quarto);
    } catch (HotelNaoExistenteException e) {
      throw e;
    }

  }

  public void removerQuarto(String nome, Quarto quarto) throws HotelNaoExistenteException {
    try {
      repositorioHoteis.removerQuarto(nome, quarto);
    } catch (HotelNaoExistenteException e) {
      throw e;
    }
  }

  public Hotel pesquisarHotel(String nome) throws HotelNaoExistenteException {
    try {
      return repositorioHoteis.pesquisarHotel(nome);
    } catch (HotelNaoExistenteException e) {
      throw e;
    }

  }

  public void atualizar(Hotel hotel) throws HotelNaoExistenteException, HotelJaExistenteException {
    try {
      repositorioHoteis.atualizar(hotel);
    } catch (HotelNaoExistenteException e) {
      throw e;
    } catch (HotelJaExistenteException e) {
      throw e;
    }
  }

  public String mostrarTodosHoteis() {
    return repositorioHoteis.mostrarTodosHoteis();
  }

  public String mostrarTodosQuartos(Hotel hotel) {
    return repositorioHoteis.mostrarTodosQuartos(hotel);
  }
}