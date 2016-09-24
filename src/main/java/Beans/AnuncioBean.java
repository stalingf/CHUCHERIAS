/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
eliminar esta siempre ammaagziicngsliderh
 */
package Beans;

import Entidades.Anuncio;
import Entidades.AnuncioJoin;
import Entidades.Categoria;
import Entidades.Tipocategoria;
import Fachada.AnuncioFachada;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.AjaxBehaviorEvent;
import java.util.Date;
import javax.faces.context.FacesContext;
import Entidades.Usuario;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.servlet.http.Part;

/**
 *
 * @author STALING
 */
@Named
@ViewScoped
public class AnuncioBean implements Serializable {

  

    protected Anuncio anuncioParaGuardar = null;
    protected boolean disponible;
    private Part foto1Part = null, foto2Part = null,  foto3Part = null, foto4Part, foto5Part = null;
    
    
    protected BufferedImage foto = null;
    private String ruta, simbolo = "&";
    private List<Anuncio> getAnuncio;
    private List<Categoria> listadoCategoria = null;
    protected List<Tipocategoria> listadoTipo = null, tipoDepurado = null;
   
    private BufferedImage imagen = null;
    protected String fecha = null;

    public String limpiaString(String parametro) {

      return  parametro
                .replace("<", "")
                .replace(">", "")
                .replace("(", "")
                .replace(")", "")
                .replace(";", "")
                .replace("}", "")
                .replace("{", "");
               }

    public AnuncioBean() {
        anuncioParaGuardar = new Anuncio();
    }

    public void agregarNuenoAnuncio() throws Exception {
        anuncioParaGuardar.setPublicado(new Date());
        fecha = anuncioParaGuardar.getPublicado().toString().replace(" ", "").replace(":", "");

        if (guardarFoto(true)) {
            try {

                if (new AnuncioFachada().nuevoAnuncio(anuncioParaGuardar)) {
                    anuncioParaGuardar = new Anuncio();
                    disponible = false;
                    foto1Part = null;
                    foto = null;
                    ruta = null;
                    listadoCategoria = null;
                    listadoTipo = null;
                    tipoDepurado = null;
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Anuncio publicado con exito..!"));

                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error en los Datos del anunciio"));

                }

            } catch (IOException ex) {
                Logger.getLogger(AnuncioBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al Cargar las Fotos"));
        }
    }

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Calendar cal = Calendar.getInstance();

    String fechaActual = dateFormat.format(cal.getTime());

    public int fechas(Date fecha) {

        String saber1 = fechaActual.toString().replace("/", "").replace(" ", "").replace(":", "");
        int nueva = Integer.parseInt(saber1);
        ////  int vieja = Integer.parseInt(fecha.toString().replace("-", "").replace(" ", "").replace(":", "").replace(".0", ""));

        return 10;

        /*  int actula = Integer.parseInt(fechaActual.toString().replace("/", "").replace(" ", "").replace(":", ""));
        int vieja = Integer.parseInt(fecha.toString().replace("-", "").replace(" ", "").replace(":", "").replace(".0", ""));

       
        System.out.println(actula);
        System.out.println(vieja);
       
      int horas = 24;
        int dias = 0;
        while (total >= horas) {
            horas = +24;
            dias++;

        }
        
        if (0<=dias) {
          return "Publicado a las " + fecha.getHours() + "" + fecha.getMinutes();
        }else{
       return  "Publicado hace "+dias;
        }*/
    }

    public boolean guardarFoto(boolean ponernumero) throws IOException {

        if (foto1Part != null) {
            if (guardadorDeFotos(1, ponernumero)) {
                if (ponernumero) {
                    anuncioParaGuardar.setFoto1(anuncioParaGuardar.getUsuario().getId() + "/" + fecha);
                }
            } else {
                return false;
            }

        }
        if (foto2Part != null) {
            if (guardadorDeFotos(2, ponernumero)) {
                if (ponernumero) {
                    anuncioParaGuardar.setFoto2(anuncioParaGuardar.getUsuario().getId() + "/" + fecha);
                }
            } else {
                return false;
            }

        }
        if (foto3Part != null) {
            if (guardadorDeFotos(3, ponernumero)) {
                if (ponernumero) {
                    anuncioParaGuardar.setFoto3(anuncioParaGuardar.getUsuario().getId() + "/" + fecha);
                }
            } else {
                return false;
            }

        }
        if (foto4Part != null) {
            if (guardadorDeFotos(4, ponernumero)) {
                if (ponernumero) {
                    anuncioParaGuardar.setFoto4(anuncioParaGuardar.getUsuario().getId() + "/" + fecha);
                }
            } else {
                return false;
            }

        }
        if (foto5Part != null) {
            if (guardadorDeFotos(5, ponernumero)) {
                if (ponernumero) {
                    anuncioParaGuardar.setFoto5(anuncioParaGuardar.getUsuario().getId() + "/" + fecha);
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean guardadorDeFotos(int numero, boolean ponernumero) throws IOException {

        anuncioParaGuardar.setUsuario((Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user"));

        String rutaAGuardar = null, rutaDB = "/resources/images/";
        ruta = FacesContext.getCurrentInstance().getExternalContext().getRealPath(rutaDB);

        File salida = new File(ruta + "/" + anuncioParaGuardar.getUsuario().getId() + "/");

        if (!salida.exists()) {
            salida.mkdirs();

        }

        int ancho = 0, alto = 0, escalaAncho = 0, escalaAlto = 0, numeroFoto = 0;
        switch (numero) {
            case 1:
                imagen = ImageIO.read(foto1Part.getInputStream());

                if (ponernumero) {
                    numeroFoto = 1;
                    rutaAGuardar = ruta + "/" + anuncioParaGuardar.getUsuario().getId() + "/" + fecha + numeroFoto;
                } else {

                    rutaAGuardar = ruta + "/" + anuncioParaGuardar.getFoto1() + "1";

                }

                break;
            case 2:
                //// ancho y alto para catalogos///
                imagen = ImageIO.read(foto2Part.getInputStream());

                if (ponernumero) {
                    numeroFoto = 2;
                    rutaAGuardar = ruta + "/" + anuncioParaGuardar.getUsuario().getId() + "/" + fecha + numeroFoto;
                } else {

                    rutaAGuardar = ruta + "/" + anuncioParaGuardar.getFoto1() + "2";
                    anuncioParaGuardar.setFoto2(anuncioParaGuardar.getFoto1());
                }

                break;
            case 3:
                //// ancho y alto para catalogos///

                imagen = ImageIO.read(foto3Part.getInputStream());

                if (ponernumero) {
                    numeroFoto = 3;
                    rutaAGuardar = ruta + "/" + anuncioParaGuardar.getUsuario().getId() + "/" + fecha + numeroFoto;
                } else {

                    rutaAGuardar = ruta + "/" + anuncioParaGuardar.getFoto1() + "3";
                    anuncioParaGuardar.setFoto3(anuncioParaGuardar.getFoto1());

                }

                break;
            case 4:
                //// ancho y alto para catalogos///

                imagen = ImageIO.read(foto4Part.getInputStream());

                if (ponernumero) {
                    numeroFoto = 4;
                    rutaAGuardar = ruta + "/" + anuncioParaGuardar.getUsuario().getId() + "/" + fecha + numeroFoto;
                } else {

                    rutaAGuardar = ruta + "/" + anuncioParaGuardar.getFoto1() + "4";
                    anuncioParaGuardar.setFoto4(anuncioParaGuardar.getFoto1());
                }

                break;
            case 5:
                //// ancho y alto para catalogos///

                imagen = ImageIO.read(foto5Part.getInputStream());

                if (ponernumero) {
                    numeroFoto = 5;
                    rutaAGuardar = ruta + "/" + anuncioParaGuardar.getUsuario().getId() + "/" + fecha + numeroFoto;
                } else {

                    rutaAGuardar = ruta + "/" + anuncioParaGuardar.getFoto1() + "5";
                    anuncioParaGuardar.setFoto5(anuncioParaGuardar.getFoto1());
                }

                break;
            default:
                return false;
        }

        try {

            ancho = imagen.getWidth();
            alto = imagen.getHeight();
            escalaAncho = ancho;///(int) (porcentaje * ancho);
            escalaAlto = alto;///(int) (porcentaje * alto);

            /// Renderizacion de imagenes
            BufferedImage bufim = new BufferedImage(escalaAncho, escalaAlto, imagen.getType());
            Graphics2D g = bufim.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(imagen, 0, 0, escalaAncho, escalaAlto, 0, 0, ancho, alto, null);
            g.dispose();

            salida = new File(rutaAGuardar + ".jpg");
            ImageIO.write(bufim, "jpg", salida);

            return true;
        } catch (Exception e) {
            throw e;

        }

    }
    private boolean siguiente = false, atras = false;
    private String llamadaAsiguiente, llamadaAatras;

    public void siguienteCatalogo() {
        if (siguiente) {
            int idUltimo = getGetAnuncio().get(sizeAnuncio - 1).getId();

            try {
                setGetAnuncio(new AnuncioFachada().siguienteCatalogo(idUltimo));
                sizeAnuncio = getGetAnuncio().size();
                if (sizeAnuncio >= 13) {
                    getGetAnuncio().remove(sizeAnuncio - 1);
                    sizeAnuncio--;
                    llamadaAsiguiente = "";
                    llamadaAatras = "disabled";
                    siguiente = true;
                    atras = false;
                } else {
                    llamadaAsiguiente = "disabled";
                    llamadaAatras = "";
                    siguiente = false;
                    atras = false;

                }

            } catch (Exception ex) {

            }
        }
    }

    public void atrasCatalogo() {
        if (!atras) {
            int idUltimo = getGetAnuncio().get(0).getId();

            try {

                List<Anuncio> anunciosAtras = new AnuncioFachada().atrasCatalogo(idUltimo);

                setGetAnuncio(null);
                getAnuncio = new ArrayList();
                for (int i = anunciosAtras.size() - 1; i >= 0; i--) {
                    getAnuncio.add(anunciosAtras.get(i));

                }

                sizeAnuncio = getGetAnuncio().size();
                if (sizeAnuncio > 12) {
                    getGetAnuncio().remove(sizeAnuncio);
                    sizeAnuncio--;
                    llamadaAsiguiente = "";
                    llamadaAatras = "";
                    siguiente = true;
                    atras = true;
                } else {

                    llamadaAsiguiente = "";
                    llamadaAatras = "disabled";
                    siguiente = true;
                    atras = false;

                }
            } catch (Exception ex) {

            }
        }
    }
    int sizeAnuncio = 0;

    public void actualizarAnuncio() {
        try {

            setGetAnuncio(new AnuncioFachada().getAnuncios());
            sizeAnuncio = getGetAnuncio().size();
            if (sizeAnuncio >= 13) {
                getGetAnuncio().remove(sizeAnuncio - 1);
                sizeAnuncio--;
                llamadaAsiguiente = "";
                llamadaAatras = "disabled";
                siguiente = true;
                atras = false;
            } else {
                llamadaAsiguiente = "disabled";
                llamadaAatras = "";
                siguiente = false;
                atras = false;

            }

        } catch (Exception ex) {

        }

    }
    private AnuncioJoin galeria = null;

    public String actualizarGaleria() {

        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> parametro = fc.getExternalContext().getRequestParameterMap();

        try {
            String Buscar = parametro.get("anuncio");

            galeria = new AnuncioFachada().getGaleria(Buscar);

            /* for (Anuncio a : getGetAnuncio()) {
                if (a.getId().equals(galeri)) {

                    FacesContext contexto = FacesContext.getCurrentInstance();
                    GaleriaBean G = contexto.getApplication().evaluateExpressionGet(contexto, "#{galeriaBean}", GaleriaBean.class);
                    G.setFoto1(a.getFoto1());

                    /////erororosijfk errorr 
                    System.out.println("foto1 A " + a.getFoto1());
                    System.out.println("foto1 G " + G.getFoto1());

                    return "/galeria.xhtml?faces-redirect=true";

                }
            }*/
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            return null;
        }
        return null;
    }

    public void actualizarCategoriaYTipo() throws Exception {
        listadoCategoria = new AnuncioFachada().getCategoria();
        listadoTipo = new AnuncioFachada().getTipoCategoria();

    }

    public List<Categoria> getListadoCategoria() {
        return listadoCategoria;
    }

    public void setListadoCategoria(List<Categoria> listadoCategoria) {
        this.listadoCategoria = listadoCategoria;
    }

    public void actualizarTipo(AjaxBehaviorEvent event) {

        System.out.println(anuncioParaGuardar.getCategoria());
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

    }

    public List<Tipocategoria> getListadoTipo() {

        if (disponible) {
            return listadoTipo;
        } else {
            return null;
        }

    }

    public void setListadoTipo(List<Tipocategoria> listadoTipo) {
        this.listadoTipo = listadoTipo;
    }

    public List<Tipocategoria> getTipoDepurado() {
        return tipoDepurado;
    }

    public void setTipoDepurado(List<Tipocategoria> tipoDepurado) {
        this.tipoDepurado = tipoDepurado;
    }

    public Part getFoto1Part() {
        return foto1Part;
    }

    public void setFoto1Part(Part foto1Part) {
        this.foto1Part = foto1Part;
    }

    public Anuncio getAnuncioParaGuardar() {
        return anuncioParaGuardar;
    }

    public void setAnuncioParaGuardar(Anuncio anuncioParaGuardar) {
        this.anuncioParaGuardar = anuncioParaGuardar;
    }

    public List<Anuncio> getGetAnuncio() {
        return getAnuncio;
    }

    public void setGetAnuncio(List<Anuncio> getAnuncio) {
        this.getAnuncio = getAnuncio;
    }

    public Part getFoto2Part() {
        return foto2Part;
    }

    public void setFoto2Part(Part foto2Part) {
        this.foto2Part = foto2Part;
    }

    public Part getFoto3Part() {
        return foto3Part;
    }

    public void setFoto3Part(Part foto3Part) {
        this.foto3Part = foto3Part;
    }

    public Part getFoto4Part() {
        return foto4Part;
    }

    public void setFoto4Part(Part foto4Part) {
        this.foto4Part = foto4Part;
    }

    public Part getFoto5Part() {
        return foto5Part;
    }

    public void setFoto5Part(Part foto5Part) {
        this.foto5Part = foto5Part;
    }

    public AnuncioJoin getGaleria() {
        return galeria;
    }

    public void setGaleria(AnuncioJoin galeria) {
        this.galeria = galeria;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getLlamadaAsiguiente() {
        return llamadaAsiguiente;
    }

    public void setLlamadaAsiguiente(String llamadaAsiguiente) {
        this.llamadaAsiguiente = llamadaAsiguiente;
    }

    public String getLlamadaAatras() {
        return llamadaAatras;
    }

    public void setLlamadaAatras(String llamadaAatras) {
        this.llamadaAatras = llamadaAatras;
    }

}
