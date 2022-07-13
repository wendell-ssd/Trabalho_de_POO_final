package entidades;

public class Carro {
  private String modelo;
  private String placa;
  private String empresa;
  private Local local;
  private boolean alugado = false;
  private float precoAluguel = 0;
  private int diasAlugado;

  public Carro(String modelo, String placa, String empresa, Local local) {
    this.modelo = modelo;
    this.placa = placa;
    this.empresa = empresa;
    this.local = local;
  }

  public String getModelo() {
    return this.modelo;
  }

  public String getPlaca() {
    return this.placa;
  }

  public String getEmpresa() {
    return this.empresa;
  }

  public Local getlocal() {
    return this.local;
  }

  public boolean getAlugado() {
    return this.alugado;
  }

  public float getPrecoAluguel() {
    return this.precoAluguel;
  }

  public void setAlugado(boolean alugado) {
    this.alugado = alugado;
  }

  public void setPrecoAluguel(float preco) {
    this.precoAluguel = preco;
  }

  public void setDiasAlugado(int diasAlugado) {
    this.diasAlugado = diasAlugado;
  }

  public double calcularPreco() {
    if (this.alugado) {
      double preco = 25.0 + this.diasAlugado;
      return preco;
    }
    return 0;
  }
}