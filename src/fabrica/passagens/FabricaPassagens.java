/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fabrica.passagens;

import repositorios.passagens.IRepositorioPassagens;
import repositorios.passagens.RepositorioPassagem;

/**
 *
 * @author Wendell
 */
public class FabricaPassagens implements IFabricaPassagens{

    @Override
    public IRepositorioPassagens getRepositorioPassagens() {
        return new RepositorioPassagem();
    }
    
}
