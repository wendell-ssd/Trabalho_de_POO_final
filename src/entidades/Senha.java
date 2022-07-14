package entidades;

import excecoes.senha.*;

/**
 * Classe que representa uma senha e contém métodos para validá-la.
 * Consiste apenas um objeto do tipo String que será comparado
 * 
 * @author Eliabe Bastos.
 */

public class Senha {
  private String senha;

  /**
   * Construtor da classe senha, que joga a exceção SenhaInvalidaException se a
   * senha for muito pequena (menor que 6 caracteres) ou se não tiver maiscúlos e
   * minísculos ou se não possuir caracteres especiais.
   * 
   * @param senha String que se tornará uma senha.
   * @throws SenhaInvalidaException Exceção jogada quando a senha é muito pequena
   *                                ou não possuir maiúsculas e minúsculas ou
   *                                caracteres especiais (?/!;\|=@...)
   */
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

  /**
   * Metodo que valida se a senha é forte.
   * 
   * @param senha String que será verificada como senha forte.
   * @throws SenhaInvalidaException Exceção jogada quando a senha é muito pequena
   *                                ou não possuir maiúsculas e minúsculas ou
   *                                caracteres especiais (?/!;\|=@...)
   */
  public void validadorSenha(String senha) throws SenhaInvalidaException {
    if (senha.length() < 6)
      throw new SenhaInvalidaException();
  }
}
