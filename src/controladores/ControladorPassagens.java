/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import entidades.Passagem;
import excecoes.passagens.PassagemInexistenteException;
import excecoes.passagens.PassagemJaCadastradaException;
import java.util.Collection;
import repositorios.passagens.IRepositorioPassagens;

/**
 *
 * @author Wendell
 */
public class ControladorPassagens {
    private IRepositorioPassagens repositorioPassagens;

    public ControladorPassagens(IRepositorioPassagens repositorioPassagens) {
        this.repositorioPassagens = repositorioPassagens;
    }
    
    public void inserir(Passagem passagem) throws PassagemJaCadastradaException{
        repositorioPassagens.inserir(passagem);
    }
    
    public Passagem pesquisarPassagem(int idPassagem) throws PassagemInexistenteException{
        return repositorioPassagens.pesquisarPassagem(idPassagem);
    }
    
    public Collection<Passagem> listarPessoas(){
        return repositorioPassagens.listarPassagens();
    }
}
