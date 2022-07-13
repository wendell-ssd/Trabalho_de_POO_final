package entidades;

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

  public double calcularPreco() {
    if (this.alugado) {
      double preco = 50.0 + this.diaria * this.diasAlugado;
      return preco;
    }
    return 0;
  }
}
