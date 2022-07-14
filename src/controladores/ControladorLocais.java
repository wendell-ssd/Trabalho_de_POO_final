/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

/**
 * Controlador do repositório de locais.
 * 
 * @author Wendell
 */

import entidades.Local;
import excecoes.locais.LocalJaCadastradoException;
import excecoes.locais.LocalNaoExisteException;
import java.util.Collection;
import repositorios.locais.IRepositorioLocais;

public class ControladorLocais {
    private IRepositorioLocais respositorioLocais;

    public ControladorLocais(IRepositorioLocais respositorioLocais) {
        this.respositorioLocais = respositorioLocais;
    }

    /**
     * Insere um local no repositório de locais.
     * 
     * @param local - Local a ser registrado.
     * @throws LocalJaCadastradoException - Levantada quando local já consta no
     *                                    repositório de locais.
     */
    public void inserir(Local local) throws LocalJaCadastradoException {
        respositorioLocais.inserir(local);
    }

    /**
     * Busca um local no repositório de locais.
     * 
     * @param estado - Estado Federativo do local buscado;
     * @param cidade - Município do local.
     * @return - Local Buscado
     * @throws LocalNaoExisteException - Levantada quando o Local não consta no
     *                                 repositório de locais
     */
    public Local pesquisarLocal(String estado, String cidade) throws LocalNaoExisteException {
        return respositorioLocais.pesquisar(estado, cidade);
    }

    /**
     * Lista todos os locais cadastrados no repositório de locais.
     * 
     * @return - Lista de locais cadastrados.
     */
    public Collection<Local> listarLocais() {
        return respositorioLocais.listarLocais();
    }
}
