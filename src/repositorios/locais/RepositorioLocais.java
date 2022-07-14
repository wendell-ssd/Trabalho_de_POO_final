/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorios.locais;

import entidades.Local;
import excecoes.locais.LocalJaCadastradoException;
import excecoes.locais.LocalNaoExisteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Wendell
 */
public class RepositorioLocais implements IRepositorioLocais{
    
    private static List<Local> locais = new ArrayList<>();
    
    @Override
    public void inserir(Local local) throws LocalJaCadastradoException{
        try {
            if(pesquisar(local.getEstado(), local.getCidade()) != null) throw new LocalJaCadastradoException();
        } catch (LocalNaoExisteException e) {
            locais.add(local);
        }
    }

    @Override
    public Local pesquisar(String estado, String cidade) throws LocalNaoExisteException{
        Local localBuscado = null;
        for (Local local : locais) {
            if(local.getEstado().equals(estado) && local.getCidade().equals(cidade)){
                localBuscado = local;
                break;
            }
        }
        if(localBuscado == null) throw new LocalNaoExisteException();
        return localBuscado;
    }

    @Override
    public Collection<Local> listarLocais() {
        return locais;
    }
    
}
