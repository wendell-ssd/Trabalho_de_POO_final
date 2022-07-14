/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorios.locais;

import entidades.Local;
import excecoes.locais.LocalJaCadastradoException;
import excecoes.locais.LocalNaoExisteException;
import java.util.Collection;

/**
 *
 * @author Wendell
 */
public interface IRepositorioLocais {
    public void inserir(Local local) throws LocalJaCadastradoException;
    public Local pesquisar(String estado, String cidade) throws LocalNaoExisteException;
    public Collection<Local> listarLocais();
}
