package entidades;

/**
 * Classe que representa uma data
 * Contém 3 objetos do tipo inteiro que representam dia mês e ano de uma data.
 * 
 * @author Eliabe Bastos
 */

public class Data {
  private int dia;
  private int mes;
  private int ano;

  public Data(int dia, int mes, int ano) {
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
  }

  public int getDia() {
    return this.dia;
  }

  public int getMes() {
    return this.mes;
  }

  public int getAno() {
    return this.ano;
  }

  public void setDia(int dia) {
    this.dia = dia;
  }

  public void setMes(int mes) {
    this.mes = mes;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public String toString() {
    return getDia() + "/" + getMes() + "/" + getAno();
  }
}
