/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidades.Anuncio;
import Entidades.Tipocategoria;
import Entidades.Usuario;
import Fachada.AnuncioFachada;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author STALING
 */
@Named
@ViewScoped
public class MisAnunciosBean extends AnuncioBean implements Serializable {

    private List<Anuncio> misAnuncios = null;

    public List<Anuncio> buscarMisAnuncios() {
        boolean saberpostback = FacesContext.getCurrentInstance().isPostback();

        try {
            if (!saberpostback) {
                Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
                misAnuncios = new AnuncioFachada().getMisAnuncios(user.getId());
            }
            return misAnuncios;

        } catch (Exception ex) {
            return null;
        }

    }

    public void paraModificarMetodo(int idAnuncio) {

        for (Anuncio a : misAnuncios) {
            if (a.getId() == idAnuncio) {

                setAnuncioParaGuardar(a);
                
                tipoDepurado = new ArrayList();
        if (anuncioParaGuardar.getCategoria() != null || !anuncioParaGuardar.getCategoria().equals("")) {

            for (Tipocategoria tip : listadoTipo) {
                if (tip.getCategoria().getCategoria().equals(anuncioParaGuardar.getCategoria())) {
                    System.out.println("tipo " + tip.getCategoria().getCategoria() + " equal " + anuncioParaGuardar.getCategoria());
                    tipoDepurado.add(tip);
                }

            }

            disponible = true;
        }
                break;
            }
        }

    }
    public void eliminar(int idAnuncio) {
        
        try {
            System.out.println(new AnuncioFachada().eliminar(idAnuncio));
        } catch (Exception ex) {
            Logger.getLogger(MisAnunciosBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        

    }

    public void guardarCambios() throws Exception {
        fecha = this.anuncioParaGuardar.getPublicado().toString().replace(" ", "").replace(":", "");
        if (guardarFoto(false)) {
            
           if(new AnuncioFachada().modificar(this.anuncioParaGuardar)){
              
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR , "Aviso","Anuncio Modificado con Exito..!"));

           }

        }

    }

}

