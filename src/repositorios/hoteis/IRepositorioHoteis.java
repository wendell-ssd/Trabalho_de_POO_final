package repositorios.hoteis;

import java.util.ArrayList;
import entidades.Hotel;
import entidades.Quarto;
import entidades.Data;
import entidades.Viajante;
import excecoes.hoteis.*;

/**
 * Essa Classe é uma interface que contém os métodos de Hotéis, essa interface
 * deve ser implementada.
 * Contém um atributo de Lista de Hoteis.
 * 
 * @see RepositorioHoteisMemoria
 * @see Hotel
 * @author Igor Vasconcelos
 * @since 2022-07-13
 * 
 */

public interface IRepositorioHoteis {
        public ArrayList<Hotel> listarHoteis();

        public Quarto checkIn(String nomeHotel, Viajante viajante, Data checkIn, Data checkOut, int diasAlugado)
                        throws HotelNaoExistenteException, HotelLotadoException;

        public Quarto checkOut(Viajante viajante, String nomeHotel)
                        throws HotelNaoExistenteException, ViajanteNaoEstaNoHotelException;

        public void cadastrarHotel(Hotel hotel) throws HotelJaExistenteException;

        public void removerHotel(String cep) throws HotelNaoExistenteException;

        public void cadastrarQuarto(String cep, Quarto quarto) throws HotelNaoExistenteException;

        public void removerQuarto(String cep, Quarto quarto) throws HotelNaoExistenteException;

        public Hotel pesquisarHotel(String cep) throws HotelNaoExistenteException;

        public void atualizar(Hotel hotel) throws HotelNaoExistenteException, HotelJaExistenteException;

        public String mostrarTodosHoteis();

        public String mostrarTodosQuartos(Hotel hotel);
}
