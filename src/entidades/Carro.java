package entidades;

/**
 * Classe que representa um carro.
 * Que contém 9 objetos do tipo:
 * String, que representam o modelo, a placa, a empresa fabricante e a cidade
 * que ele está localizado;
 * Data, que representam a data que ele foi retirado e a data em que foi
 * devolvido;
 * Um booleano, que representa se o carro está alugado(true) ou não(false);
 * Numéricos, que representam o preço do aluguel e o tempo que foi alugado;
 * Todos esses métodos possuem seus respectivos gets e sets.
 * Além do método calcular preço.
 * 
 * @author Eliabe Bastos;
 */

public class Carro {
  private String modelo;
  private String placa;
  private String empresa;
  private Local local;
  private boolean alugado = false;
  private float precoAluguel = 0;
  private int diasAlugado;

  /**
   * Construtor para classe carro, muitas das variáveis não são recebidas como
   * parâmetros, pois serão utilizadas somente quando o carro for reservado.
   * 
   * @param modelo  modelo do carro;
   * @param placa   placa do carro;
   * @param empresa fabricante do carro;
   * @param cidade  cidade em que o carro está localizado.
   */
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

  /**
   * Método que calcula o preço que o cliente deve pagar ao alugar o carro por uma
   * certa quantidade de dias.
   * 
   * @return retorna um double, o valor do aluguel é (por padrão) R$25,00 por dia.
   */
  public double calcularPreco() {
    if (this.alugado) {
      double preco = 25.0 + this.diasAlugado;
      return preco;
    }
    return 0;
  }
}