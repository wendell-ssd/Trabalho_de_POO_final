package entidades;

/**
 * Classe que representa uma viagem, portanto apresenta:
 * 14 objetos do tipo:
 * String que representam a cidade de origem, a cidade de destino, a classe do voo(Econômica, primeira classe) e a companhia aérea responsável pelo voo;
 * Inteiro estático, que irá gerar a identificação da viagem;
 * Inteiro que representam a identificação da viagem, a quantidade de bagagens e o numero do voo;
 * Double que representa a duração do voo;
 * Viajante que representa o cliente titular da viagem;
 * Quarto que representa o quarto do hotel ocupado pelos hóspedes;
 * Carro que representa o carro alugado pelo cliente.
 * Com seus respectivos métodos get e set;
 * Além do método calcular preço que calcula o valor total da viagem.
 * @author Weatherly
 */

/**
 * Esse é o método construtor da classe Viagem.
 * 
 * 
 * @param origem      - Representa o local de origem do viajante.
 * @param destino     - Representa o local de destino do viajante.
 * @param dataPartida - Representa a data de Partida do voo.
 * @param dataChegada - Representa a data de Chegada do voo.
 * @param duracaoVoo  - Representa a duracao do voo.
 * @param classe      - Representa a classe do voo
 * @param bagagens    - Representa a quantidade de bagagens do voo
 * @param numeroVoo   - Representa o numero do voo
 * @param empresa     - A empresa que ira prestar o serviço
 * @param quarto      - Representa os dados sobre o quarto
 * @param carro       - Representa os dados sobre carro
 */
public class Viagem {

  private static int geradorDeID = 0;
  private int id;
  private String origem;
  private String destino;
  private Data dataPartida;
  private Data dataChegada;
  private String classe;
  private int bagagens;
  private int numeroVoo;
  private String empresa;
  private Quarto quarto = null;
  private Carro carro = null;

  public Viagem(Viajante viajante, String origem, String destino, Data dataPartida,
      Data dataChegada, String classe, int bagagens, int numeroVoo,
      String empresa, Quarto quarto, Carro carro) {
    geradorDeID++;
    this.id = geradorDeID;
    this.origem = origem;
    this.destino = destino;
    this.dataPartida = dataPartida;
    this.dataChegada = dataChegada;
    this.classe = classe;
    this.bagagens = bagagens;
    this.numeroVoo = numeroVoo;
    this.empresa = empresa;
    this.quarto = quarto;
    this.carro = carro;
  }

  public Viagem(Viajante viajante, String origem, String destino,
      Data dataPartida, Data dataChegada, String classe,
      int bagagens, int numeroVoo, String empresa,
      Carro carro) {
    geradorDeID++;
    this.id = geradorDeID;
    this.origem = origem;
    this.destino = destino;
    this.dataPartida = dataPartida;
    this.dataChegada = dataChegada;
    this.classe = classe;
    this.bagagens = bagagens;
    this.numeroVoo = numeroVoo;
    this.empresa = empresa;
    this.carro = carro;
  }

  public Viagem(Viajante viajante, String origem, String destino,
      Data dataPartida, Data dataChegada, String classe,
      int bagagens, int numeroVoo, String empresa, Quarto quarto) {
    geradorDeID++;
    this.id = geradorDeID;
    this.origem = origem;
    this.destino = destino;
    this.dataPartida = dataPartida;
    this.dataChegada = dataChegada;
    this.classe = classe;
    this.bagagens = bagagens;
    this.numeroVoo = numeroVoo;
    this.empresa = empresa;
    this.quarto = quarto;
  }

  public Viagem(Viajante viajante, String origem, String destino,
      Data dataPartida, Data dataChegada, String classe,
      int bagagens, int numeroVoo, String empresa) {
    geradorDeID++;
    this.id = geradorDeID;
    this.origem = origem;
    this.destino = destino;
    this.dataPartida = dataPartida;
    this.dataChegada = dataChegada;
    this.classe = classe;
    this.bagagens = bagagens;
    this.numeroVoo = numeroVoo;
    this.empresa = empresa;
  }

  public Quarto getQuarto() {
    return this.quarto;
  }

  public int getID() {
    return this.id;
  }

  public String getOrigem() {
    return this.origem;
  }

  public String getDestino() {
    return this.destino;
  }

  public Data getDataPartida() {
    return this.dataPartida;
  }

  public Data getDataChegada() {
    return this.dataChegada;
  }

  public String getClasse() {
    return this.classe;
  }

  public int getBagagens() {
    return this.bagagens;
  }

  public int getNumeroVoo() {
    return this.numeroVoo;
  }

  public String getEmpresa() {
    return this.empresa;
  }

  public Carro getCarro() {
    return this.carro;
  }

  public void setOrigem(String origem) {
    this.origem = origem;
  }

  public void setDestino(String destino) {
    this.destino = destino;
  }

  public void setDataPartida(Data dataPartida) {
    this.dataPartida = dataPartida;
  }

  public void setDataChegada(Data dataChegada) {
    this.dataChegada = dataChegada;
  }

  public void setClasse(String classe) {
    this.classe = classe;
  }

  public void setBagagens(int bagagens) {
    this.bagagens = bagagens;
  }

  public void setNumeroVoo(int numeroVoo) {
    this.numeroVoo = numeroVoo;
  }

  public void setEmpresa(String empresa) {
    this.empresa = empresa;
  }

  public void setCarro(Carro carro) {
    this.carro = carro;
  }

  public double calcularPreco() {
    double preco = 200 * bagagens + quarto.calcularPreco() + carro.calcularPreco();
    return preco;
  }
}