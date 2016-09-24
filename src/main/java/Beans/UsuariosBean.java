/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidades.Usuario;
import Fachada.UsuarioFachada;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author STALING
 */
@Named
@ViewScoped
public class UsuariosBean implements Serializable {

    private Usuario usuario = null;

    public UsuariosBean() {
        usuario = new Usuario();
    }

    public void crearCuentaBean() {

        if (usuario.getEmail().contains("@") && usuario.getEmail().contains(".")) {
            int arrobalugar = usuario.getEmail().indexOf("@") + 1;
            int puntolugar = usuario.getEmail().indexOf(".") + 1;
            if (puntolugar < arrobalugar) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correo no valido"));

            } else {
                try {
                  /*  EncryptPasswordWithPBKDF2WithHmacSHA1
                            usuario.setClave();*/
                    if (!new UsuarioFachada().crearCuenta(usuario)) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Crear la Cuenta"));

                    } else {
                       
                         ExternalContext cont = FacesContext.getCurrentInstance().getExternalContext();
                         cont.getSessionMap().put("user", usuario);
                          usuario = new Usuario();
                        //////FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cuenta Creada con Exito.!"));
                       
                        cont.redirect("../CHUCHERIAS");
                        

                    }
                } catch (Exception ex) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error " + ex.getMessage()));
                }
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correo no valido"));

        }

    }
    private Usuario usuarioSession = null, usuarioSessionanterior = null;

    public Usuario getUsuarioSession() {
        return usuarioSession;
    }

    public void setUsuarioSession(Usuario usuarioSession) {
        this.usuarioSession = usuarioSession;
    }

    public void iniciarSession() {
        try {
            usuarioSession = new UsuarioFachada().iniciarSession(usuario);
            if (usuarioSession != null) {

                usuarioSessionanterior = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
                if (usuarioSessionanterior == null) {
                    ExternalContext ext = FacesContext.getCurrentInstance().getExternalContext();
                    ext.getSessionMap().put("user", usuarioSession);

                    usuarioSession = null;
                    usuario = new Usuario();
                    ext.redirect("../CHUCHERIAS");

                } else {
                    usuarioSessionanterior = null;
                    usuarioSession = null;

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Debe Cerrar session"));
                }

            } else {
                usuarioSession = null;

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Email o Clave Incorrecto"));
            }
        } catch (Exception e) {
            usuarioSession = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error " + e.getMessage()));
        }

    }

    public boolean getSession() {
        if (usuarioSession == null) {
            usuarioSession = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

        }
        if (usuarioSession != null) {
            if (usuarioSession.getId() != null) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    public void cerrarSession() throws IOException {
        System.out.println("entro a salir");

        ExternalContext cerrar = FacesContext.getCurrentInstance().getExternalContext();

        cerrar.invalidateSession();
        cerrar.redirect("../CHUCHERIAS");

    }

    public void verificarSession() throws IOException {

        Usuario usesr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

        if (usesr == null) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../CHUCHERIAS");
        }

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
