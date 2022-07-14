package repositorios.hoteis;

import java.util.ArrayList;
import entidades.Hotel;
import entidades.Quarto;
import entidades.Viajante;
import entidades.Data;
import excecoes.hoteis.*;

public class RepositorioHoteisMemoria implements IRepositorioHoteis {
    private static ArrayList<Hotel> hoteis = new ArrayList<Hotel>();

    public ArrayList<Hotel> listarHoteis() {
        return this.hoteis;
    }

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

    public void cadastrarHotel(Hotel hotel) throws HotelJaExistenteException {
        try {
            if(pesquisarHotel(hotel.getNome()) != null) throw new HotelJaExistenteException();
        } catch (HotelNaoExistenteException e) {
            hoteis.add(hotel);
        }

    }

    public void removerHotel(String nome) throws HotelNaoExistenteException {
        try {
            this.hoteis.remove(pesquisarHotel(nome));
        } catch (HotelNaoExistenteException excecao) {
            throw excecao;
        }
    }

    public void cadastrarQuarto(String nome, Quarto quarto) throws HotelNaoExistenteException {
        try {
            Hotel hotel = this.pesquisarHotel(nome);
            hotel.getQuartos().add(quarto);
        } catch (HotelNaoExistenteException excecao) {
            throw excecao;
        }
    }

    public void removerQuarto(String nome, Quarto quarto) throws HotelNaoExistenteException {
        try {
            Hotel hotel = this.pesquisarHotel(nome);
            hotel.getQuartos().remove(quarto);
        } catch (HotelNaoExistenteException excecao) {
            throw excecao;
        }
    }

    public Hotel pesquisarHotel(String nome) throws HotelNaoExistenteException {
        Hotel hotelBuscado = null;
        for (Hotel hotel : this.hoteis)
            if (hotel.getNome().equals(nome)){
                hotelBuscado = hotel;
                break;
            }
        if (hotelBuscado == null) throw new HotelNaoExistenteException();
        return hotelBuscado;
    }

    public void atualizar(Hotel hotel) throws HotelNaoExistenteException {
        try {
            Hotel toUpdate = pesquisarHotel(hotel.getNome());
            toUpdate.setlocal(hotel.getlocal());
            toUpdate.setEstrelas(hotel.getEstrelas());
        } catch (HotelNaoExistenteException excecao) {
            throw excecao;
        }
    }

    public String mostrarTodosHoteis() {
        String string = "";
        for (Hotel hotel : hoteis) {
            string = string + this.mostrarAtributosHotel(hotel);
        }
        return string;
    }

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

    public String mostrarTodosQuartos(Hotel hotel) {
        String string = "";
        ArrayList<Quarto> quartos = hotel.getQuartos();
        for (Quarto quarto : quartos) {
            string = string + this.mostrarAtributosQuarto(quarto);
        }
        return string;
    }

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