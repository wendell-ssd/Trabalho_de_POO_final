package entidades;

/**
 * Classe que representa um quarto.
 * Contém 10 objetos do tipo:
 * Inteiro estático, getID uma variável usada para dar números aos quartos;
 * Inteiros, que representam o número do quarto, a quantidade máxima de hóspedes
 * e quantos dias ele foi alugado;
 * Double, que representa a diária do quarto;
 * String que representa o nome do hotel que contém o quarto;
 * Booleano que diz se ele está alugado (true) ou não (false);
 * Objetos da classe Data que representam a data de Check-in e a data de
 * Check-out;
 * Objeto da classe Viajante que representa o titular/representante do quarto.
 * Todos os objetos possuem seus respectivos gets e sets.
 * 
 * @author Igor de Vasconcelos
 */

public class Quarto {
  private static int geradorID = 0;
  private String nomeHotel;
  private int id;
  private double diaria;
  private Viajante representante;
  private int quantidadeMaximaDeHospedes;
  private Data dataCheckin;
  private Data dataCheckout;
  private boolean alugado;
  private int diasAlugado;

  /**
   * Construtor da classe quarto, os parâmetros são somente o nome do hotel e a
   * quantiadade de hospedes.
   * O id do quarto é gerado automaticamente, ao incrementar a variável estática;
   * Colocamos a diária como 50 por padrão;
   * Os demais objetos serão utilizados nos métodos de reservar quarto.
   * 
   * @param nomeHotel                  String que representa o nome do hotel que o
   *                                   quarto está contido;
   * @param quantidadeMaximaDeHospedes Inteiro que representa a quantidade máxima
   *                                   de pessoas que o quarto pode acomodar.
   */
  public Quarto(String nomeHotel, int quantidadeMaximaDeHospedes) {
    geradorID++;
    this.id = geradorID;
    this.nomeHotel = nomeHotel;
    this.representante = null;
    this.diaria = 50;
    this.quantidadeMaximaDeHospedes = quantidadeMaximaDeHospedes;
    this.dataCheckin = null;
    this.dataCheckout = null;
    this.alugado = false;
  }

  public int getId() {
    return id;
  }

  public double getDiaria() {
    return diaria;
  }

  public void setDiaria(double diariaHotel) {
    this.diaria = diariaHotel * this.quantidadeMaximaDeHospedes;
  }

  public Viajante getRepresentante() {
    return representante;
  }

  public void setRepresentante(Viajante representante) {
    this.representante = representante;
  }

  public int getQuantidadeMaximaDeHospedes() {
    return quantidadeMaximaDeHospedes;
  }

  public boolean getAlugado() {
    return this.alugado;
  }

  public void setQuantidadeMaximaDeHospedes(int quantidadeMaximaDeHospedes) {
    this.quantidadeMaximaDeHospedes = quantidadeMaximaDeHospedes;
  }

  public Data getDataCheckin() {
    return dataCheckin;
  }

  public void setDataCheckin(Data dataCheckin) {
    this.dataCheckin = dataCheckin;
  }

  public Data getDataCheckout() {
    return dataCheckout;
  }

  public void setDataCheckout(Data dataCheckout) {
    this.dataCheckout = dataCheckout;
  }

  public void setAlugado(boolean alugado) {
    this.alugado = alugado;
  }

  public String getNomeHotel() {
    return this.nomeHotel;
  }

  public void setNomeHotel(String nomeHotel) {
    this.nomeHotel = nomeHotel;
  }

  public void setDiasAlugado(int diasAlugado) {
    this.diasAlugado = diasAlugado;
  }

  /**
   * Método que calcula quanto o cliente irá gastar para ficar a quantidade de
   * dias desejados no hotel.
   * 
   * @return Double com o preço que o cliente deve pagar ao final da estadia.
   */
  public double calcularPreco() {
    if (this.alugado) {
      double preco = 50.0 + this.diaria * this.diasAlugado;
      return preco;
    }
    return 0;
  }
}
