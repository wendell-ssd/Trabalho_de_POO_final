package repositorios.hoteis;

import java.util.ArrayList;
import entidades.Hotel;
import entidades.Quarto;
import entidades.Viajante;
import entidades.Data;
import excecoes.hoteis.*;

/**
 * Essa é uma classe que implementa a interface IRepositorioHoteis que contém os
 * métodos de Hotel.
 * 
 * @see Hotel
 * @see IRepositorioHoteis
 * @author Igor Vasconcelos
 * @since 2022-07-13
 */

public class RepositorioHoteisMemoria implements IRepositorioHoteis {
    private static ArrayList<Hotel> hoteis = new ArrayList<Hotel>();

    /**
     * Esse método serve para listar os Hoteis.
     * 
     * @return ArrayList - uma lista de Hoteis.
     * 
     */
    public ArrayList<Hotel> listarHoteis() {
        return hoteis;
    }

    /**
     * Esse método serve para fazer o CheckIn do viajante no Hotel, ou seja, caso o
     * viajante tenha escolhido
     * um hotel / quarto.
     * 
     * @param nomeHotel   - nome do hotel que foi escolhido.
     * @param viajante    - viajante que será hospedado.
     * @param checkIn     - data de checkin.
     * @param checkOut    - data de checkout.
     * @param diasAlugado - quantidade de dias de aluguel.
     * @return Quarto - retorna um objeto do tipo Quarto.
     * @throws HotelNaoExistenteException - é levantada quando o hotel dado não
     *                                    existe.
     */
    public Quarto checkIn(String nomeHotel, Viajante viajante, Data checkIn, Data checkOut, int diasAlugado)
            throws HotelNaoExistenteException, HotelLotadoException {
        try {
            Hotel hotel = pesquisarHotel(nomeHotel);
            ArrayList<Quarto> quartos = hotel.getQuartos();
            for (Quarto quarto : quartos) {
                if (quarto.getAlugado() == false) {
                    quarto.setRepresentante(viajante);
                    quarto.setDataCheckin(checkIn);
                    quarto.setDataCheckout(checkOut);
                    quarto.setDiasAlugado(diasAlugado);
                    return quarto;
                }
            }
        } catch (HotelNaoExistenteException e) {
            throw e;
        }
        throw new HotelLotadoException();
    }

    /**
     * Esse método serve para fazer o CheckOut do viajante no hotel, retirar os
     * dados de status de alugado.
     * 
     * @param viajante  - o viajante que será feito o seu checkout.
     * @param nomeHotel - o nome do hotel que é para fazer o checkout.
     * @throws HotelNaoExistenteException      - é levantada quando o hotel dado não
     *                                         existe
     * @throws ViajanteNaoEstaNoHotelException - é levantada quando o viajante nao
     *                                         esta no hotel indicado.
     * @return Quarto - retorna um objeto do tipo Quarto.
     */
    public Quarto checkOut(Viajante viajante, String nomeHotel)
            throws HotelNaoExistenteException, ViajanteNaoEstaNoHotelException {
        try {
            Hotel hotel = pesquisarHotel(nomeHotel);
            ArrayList<Quarto> quartos = hotel.getQuartos();
            for (Quarto quarto : quartos) {
                if (quarto.getRepresentante() == viajante) {
                    quarto.setRepresentante(null);
                    quarto.setDataCheckin(null);
                    quarto.setDataCheckout(null);
                    return quarto;
                }
            }
        } catch (HotelNaoExistenteException e) {
            throw e;
        }
        throw new ViajanteNaoEstaNoHotelException();
    }

    /**
     * Esse método serve para cadastrar um hotel.
     * 
     * @param hotel - objeto do tipo hotel, para realizar o seu cadastro.
     * @throws HotelJaExistenteException - É levantada quando se tenta cadastrar um
     *                                   hotel que já está cadastrado.
     * 
     */
    public void cadastrarHotel(Hotel hotel) throws HotelJaExistenteException {
        try {
            if (pesquisarHotel(hotel.getNome()) != null)
                throw new HotelJaExistenteException();
        } catch (HotelNaoExistenteException e) {
            hoteis.add(hotel);
        }

    }

    /**
     * Esse método serve para remover um hotel.
     * 
     * @param nome - o nome do hotel que deve ser removido.
     * @throws HotelNaoExistenteException - é levantaod quando o hotel procurado não
     *                                    existe.
     * 
     */
    public void removerHotel(String nome) throws HotelNaoExistenteException {
        try {
            hoteis.remove(pesquisarHotel(nome));
        } catch (HotelNaoExistenteException excecao) {
            throw excecao;
        }
    }

    /**
     * Esse método serve para cadastrar um quarto no hotel.
     * 
     * @param nome   - nome do hotel que se quer cadastrar o quarto.
     * @param quarto - o quarto que deve ser adicionado.
     * @throws HotelNaoExistenteException - é levantada quando o hotel procurado não
     *                                    está cadastrado...
     */
    public void cadastrarQuarto(String nome, Quarto quarto) throws HotelNaoExistenteException {
        try {
            Hotel hotel = this.pesquisarHotel(nome);
            hotel.getQuartos().add(quarto);
        } catch (HotelNaoExistenteException excecao) {
            throw excecao;
        }
    }

    /**
     * Esse método serve para remover um quarto do hotel.
     * 
     * @param nome   - nome do hotel que se quer remover o quarto.
     * @param quarto - o quarto que se quer remover.
     * @throws HotelNaoExistenteException - é levantada quando o hotel procurado não
     *                                    está cadastrado.
     */
    public void removerQuarto(String nome, Quarto quarto) throws HotelNaoExistenteException {
        try {
            Hotel hotel = this.pesquisarHotel(nome);
            hotel.getQuartos().remove(quarto);
        } catch (HotelNaoExistenteException excecao) {
            throw excecao;
        }
    }

    /**
     * Esse método serve para a pesquisa ou busca de um hotel em específico.
     * 
     * @param nome - nome do hotel que se quer achar.
     * @throws HotelNaoExistenteException - é levantada quando o hotel procurado não
     *                                    está cadastrado.
     * @return Hotel - retorna um objeto do tipo hotel que está sendo procurado.
     */
    public Hotel pesquisarHotel(String nome) throws HotelNaoExistenteException {
        Hotel hotelBuscado = null;
        for (Hotel hotel : hoteis)
            if (hotel.getNome().equals(nome)) {
                hotelBuscado = hotel;
                break;
            }
        if (hotelBuscado == null)
            throw new HotelNaoExistenteException();
        return hotelBuscado;
    }

    /**
     * Esse método serve para atualizar algum dado do hotel.
     * 
     * @param hotel - o hotel que se quer atualizar.
     * @throws HotelNaoExistenteException - é levantada quando o hotel não está
     *                                    cadastrado.
     */
    public void atualizar(Hotel hotel) throws HotelNaoExistenteException {
        try {
            Hotel toUpdate = pesquisarHotel(hotel.getNome());
            toUpdate.setlocal(hotel.getlocal());
            toUpdate.setEstrelas(hotel.getEstrelas());
        } catch (HotelNaoExistenteException excecao) {
            throw excecao;
        }
    }

    /**
     * Esse método serve para mostrar os hoteis cadastrados.
     * 
     * @return String - retorna um objeto do tipo String com os hoteis cadastrados e
     *         os seus atributos.
     */
    public String mostrarTodosHoteis() {
        String string = "";
        for (Hotel hotel : hoteis) {
            string = string + this.mostrarAtributosHotel(hotel);
        }
        return string;
    }

    /**
     * Esse método serve para mostrar os atributos, ou seja, características do
     * hotel.
     * 
     * @param hotel - o hotel que se quer ver os atributos.
     * @return String - retorna um objeto do tipo String com os atributos do hotel.
     */
    private String mostrarAtributosHotel(Hotel hotel) {
        String string = "";
        string = string + "Nome: " + hotel.getNome() + "\n";
        string = string + "CEP: " + hotel.getCep() + "\n";
        string = string + "Estrelas: " + hotel.getEstrelas() + "\n";
        string = string + "Diaria: " + hotel.getDiaria() + "\n";
        string = string + "Quantidade de quartos: " + hotel.getQuantidadeQuartos() + "\n";
        string = string + "Quartos disponiveis: " + hotel.getQuartosDisponiveis() + "\n";
        return string;
    }

    /**
     * Esse método serve para mostrar os quartos que estão no hotel.
     * 
     * @param hotel - O hotel que se quer saber os quartos.
     * @return String - retorna um objeto do tipo String com os quartos cadastrados
     *         no hotel e os seus atributos.
     */
    public String mostrarTodosQuartos(Hotel hotel) {
        String string = "";
        ArrayList<Quarto> quartos = hotel.getQuartos();
        for (Quarto quarto : quartos) {
            string = string + this.mostrarAtributosQuarto(quarto);
        }
        return string;
    }

    /**
     * Esse método serve para mostrar os atributos do quarto escolhido.
     * 
     * @param quarto - o quarto no qual se quer saber os atributos.
     * @return String - retorna um objeto do tipo String com os atributos do quarto,
     *         ou seja, suas características.
     */
    private String mostrarAtributosQuarto(Quarto quarto) {
        String string = "";
        string = string + "ID: " + quarto.getId() + "\n";
        string = string + "Nome: " + quarto.getNomeHotel() + "\n";
        string = string + "Alugado: " + quarto.getAlugado() + "\n";
        string = string + "Representante: " + quarto.getRepresentante() + "\n";
        string = string + "Quantidade maxima de hospedes: " + quarto.getQuantidadeMaximaDeHospedes() + "\n";
        string = string + "DataCheckIn: " + quarto.getDataCheckin() + "\n";
        string = string + "DataCheckOut: " + quarto.getDataCheckout() + "\n";
        return string;
    }
}