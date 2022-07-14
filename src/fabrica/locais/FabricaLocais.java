/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabrica.locais;

import repositorios.locais.IRepositorioLocais;
import repositorios.locais.RepositorioLocais;

/**
 *
 * @author Wendell
 */
public class FabricaLocais implements IFabricaLocais{

    @Override
    public IRepositorioLocais getRepositorioLocais() {
        return new RepositorioLocais();
    }
    
}
