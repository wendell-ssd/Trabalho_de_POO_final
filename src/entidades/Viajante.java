package entidades;

/**
 * Esta classe implementa a entidade viajante. Logo, apresentará:
 * Uma String contendo o nome e o cpf, um atributo do tipo Data contendo a data
 * de nascimento, um inteiro contendo a idade
 * e um atributo do tipo Senha contendo a senha de acesso do Viajante.
 * Em conjunto tem os seus métodos getters e setters.
 * 
 * @author Gabriel Pinheiro
 * @version 1.0
 * @since 2022-07-13
 * 
 * 
 */

public class Viajante {
  private String nome;
  private Data dataNascimento;
  private int idade;
  private String cpf;
  private Senha senha;

  /**
   * Esse é o método construtor da classe viajante.
   * 
   * @param nome           - Representa o nome do viajante.
   * @param dataNascimento - Representa a data de Nascimento do viajante.
   * @param cpf            - Representa o Cadastro de Pessoa Física (cpf) do
   *                       viajante.
   * @param senha          - Um atributo do tipo senha, que representa a senha de
   *                       acesso do viajante.
   */
  public Viajante(String nome, Data dataNascimento, String cpf, Senha senha) {
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.cpf = cpf;
    this.senha = senha;
  }

  public String getNome() {
    return this.nome;
  }

  public Data getdataNascimento() {
    return this.dataNascimento;
  }

  public int getIdade() {
    return idade;
  }

  public String getCpf() {
    return cpf;
  }

  public Senha getSenha() {
    return senha;
  }

  public void setSenha(Senha senha) {
    this.senha = senha;
  }
}
