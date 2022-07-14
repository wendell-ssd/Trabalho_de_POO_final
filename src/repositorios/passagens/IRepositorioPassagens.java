/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorios.passagens;

import entidades.Passagem;
import excecoes.passagens.PassagemInexistenteException;
import excecoes.passagens.PassagemJaCadastradaException;
import java.util.Collection;

/**
 *
 * @author Wendell
 */
public interface IRepositorioPassagens {
    
    public void inserir(Passagem passagem)throws PassagemJaCadastradaException;
    public Passagem pesquisarPassagem(int idPassagem) throws PassagemInexistenteException;
    public Collection<Passagem> listarPassagens();
}
