/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachada;

/**
 *
 * @author STALING
 */
import Entidades.Usuario;

import DAO.UsuarioDAO;

public class UsuarioFachada {

    public boolean crearCuenta(Usuario usuario) throws Exception {
        UsuarioDAO userdao = new UsuarioDAO();

        if (!userdao.verificar(usuario)) {
            return userdao.guardar(usuario);
        } else {
            throw new Exception("Telefono o Email Esta En Uso..!");
        }

    }

    public Usuario iniciarSession(Usuario usuario) throws Exception {
        UsuarioDAO userdao = new UsuarioDAO();
        return userdao.iniciarSession(usuario);

    }

}
