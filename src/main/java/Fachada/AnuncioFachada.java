/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachada;

import DAO.AnuncionDAO;
import Entidades.Anuncio;
import Entidades.AnuncioJoin;
import Entidades.Categoria;
import Entidades.Tipocategoria;
import Entidades.Usuario;
import java.util.List;

/**
 *
 * @author STALING
 */
public class AnuncioFachada {

    public AnuncioFachada() {

    }
    
    public AnuncioJoin getGaleria(String Buscarr) throws Exception{
    
         return new AnuncionDAO().getGaleria(Buscarr);

        
    }

    public List<Tipocategoria> getTipoCategoria() throws Exception {

        return new AnuncionDAO().getTipoCategoria();

    }

    public boolean eliminar(int idAnuncio) throws Exception {

        return new AnuncionDAO().Eliminar(idAnuncio);

    }

    public List<Categoria> getCategoria() throws Exception {

        return new AnuncionDAO().getCategoria();

    }

    public List<Anuncio> getAnuncios() throws Exception {

        return new AnuncionDAO().getAnuncios();

    }
    public List<Anuncio> siguienteCatalogo(int idUltimo ) throws Exception {

        return new AnuncionDAO().getSiguientesAnuncios(idUltimo);

    }
    public List<Anuncio> atrasCatalogo(int idUltimo ) throws Exception {

        return new AnuncionDAO().atrasCatalogo(idUltimo);

    }

    public List<Anuncio> getMisAnuncios(int userID) throws Exception {

        return new AnuncionDAO().getMisAnuncios(userID);

    }

    public boolean nuevoAnuncio(Anuncio A) throws Exception {

        if (new AnuncionDAO().guardar(A)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean modificar(Anuncio A) throws Exception {

        if (new AnuncionDAO().modificar(A)) {
            return true;
        } else {
            return false;
        }

    }

}
