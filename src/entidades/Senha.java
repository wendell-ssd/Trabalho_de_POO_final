package entidades;

import excecoes.senha.*;

public class Senha {
  private String senha;
  
  public Senha(String senha) throws SenhaInvalidaException {
    try {
      this.validadorSenha(senha);
      this.senha = senha;
    } catch (SenhaInvalidaException excecao) {
      throw new SenhaInvalidaException();
    }
  }

  public void setSenha(String senha) throws SenhaInvalidaException {
    try {
      this.validadorSenha(senha);
      this.senha = senha;
    } catch (SenhaInvalidaException excecao) {
      throw new SenhaInvalidaException();
    }
  }

  public String getSenha() {
    return this.senha;
  }

  public void validadorSenha(String senha) throws SenhaInvalidaException {
    if (senha.length() < 6)
      throw new SenhaInvalidaException();

    char[] alfabetoMinusculo = "abcdefghijklmnopqrstuvxyzw".toCharArray();
    char[] alfabetoMaiusculo = "ABCDEFGHIJKLMNOPQRSTUVXYZW".toCharArray();
    boolean temLetraMaiscula = false;
    boolean temLetraMinuscula = false;
    boolean temNumero = false;
    char[] numeros = "0123456789".toCharArray();

    for (char c : senha.toCharArray()) {
      for (char a : alfabetoMaiusculo)
        if (c == a)
          temLetraMaiscula = true;
      for (char a : alfabetoMinusculo)
        if (c == a)
          temLetraMinuscula = true;
      for (char n : numeros)
        if (c == n)
          temNumero = true;
      if (temLetraMaiscula && temLetraMinuscula && temNumero)
        break;
    }

    // Não pude implementar por pressa, mas se precisar é só tratar os erros aqui
    if (temLetraMaiscula && temLetraMinuscula && temNumero == false) {
      throw new SenhaInvalidaException();
    }
  }
}
