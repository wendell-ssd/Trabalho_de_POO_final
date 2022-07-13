package entidades;

public class Viajante {
  private String nome;
  private Data dataNascimento;
  private int idade;
  private String cpf;
  private Senha senha;

  // A validação da senha acontece no front
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
