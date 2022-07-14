/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import entidades.Local;
import excecoes.locais.LocalJaCadastradoException;
import excecoes.locais.LocalNaoExisteException;
import java.util.Collection;
import repositorios.locais.IRepositorioLocais;
/**
 *
 * @author Wendell
 */
public class ControladorLocais {
    private IRepositorioLocais respositorioLocais;

    public ControladorLocais(IRepositorioLocais respositorioLocais) {
        this.respositorioLocais = respositorioLocais;
    }
    
    public void inserir(Local local) throws LocalJaCadastradoException{
        respositorioLocais.inserir(local);
    }
    
    public Local pesquisarLocal(String estado, String cidade) throws LocalNaoExisteException{
        return respositorioLocais.pesquisar(estado, cidade);
    }
    
    public Collection<Local> listarLocais(){
        return respositorioLocais.listarLocais();
    }
}
