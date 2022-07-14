/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fabrica.passagens;

import repositorios.passagens.IRepositorioPassagens;

/**
 *
 * @author Wendell
 */
public interface IFabricaPassagens {
    public IRepositorioPassagens getRepositorioPassagens();
}
