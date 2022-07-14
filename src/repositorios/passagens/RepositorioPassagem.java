/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorios.passagens;

import entidades.Passagem;
import excecoes.passagens.PassagemInexistenteException;
import excecoes.passagens.PassagemJaCadastradaException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Wendell
 */
public class RepositorioPassagem implements IRepositorioPassagens{
    private static List<Passagem> passagens = new ArrayList<>();
    
    @Override
    public void inserir(Passagem passagem) throws PassagemJaCadastradaException{
        try {
            if(pesquisarPassagem(passagem.getId()) != null) throw new PassagemJaCadastradaException();
        } catch (PassagemInexistenteException e) {
            passagens.add(passagem);
        }
    }

    @Override
    public Passagem pesquisarPassagem(int idPassagem) throws PassagemInexistenteException{
        Passagem passagemBuscada = null;
        for (Passagem passagem : passagens) {
            if(passagem.getId() == idPassagem){
                passagemBuscada = passagem;
            }
        }
        if(passagemBuscada == null) throw new PassagemInexistenteException();
        return passagemBuscada;
    }

    @Override
    public Collection<Passagem> listarPassagens() {
        return passagens;
    }
    
}
