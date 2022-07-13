/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabrica.carros;

import repositorios.carros.RepositorioCarrosMemoria;

/**
 *
 * @author Wendell
 */
public class FabricaCarrosMemoria implements IFabricaCarros{
    public RepositorioCarrosMemoria getRepositorioCarros() {
    return new RepositorioCarrosMemoria();
  }
}
