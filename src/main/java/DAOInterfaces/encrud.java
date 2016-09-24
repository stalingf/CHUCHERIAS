/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOInterfaces;

/**
 *
 * @author STALING
 */
public interface encrud<T> {

    public boolean guardar(T tipo) throws Exception;

    public boolean eleminar(T tipo) throws Exception;

    public boolean modificar(T tipo) throws Exception;

}
