package Entidades;
// Generated 14-jul-2016 15:51:28 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Categoria generated by hbm2java
 */
public class Categoria  implements java.io.Serializable {


     private String categoria;
     private Set tipocategorias = new HashSet(0);

    public Categoria() {
    }

	
    public Categoria(String categoria) {
        this.categoria = categoria;
    }
    public Categoria(String categoria, Set tipocategorias) {
       this.categoria = categoria;
       this.tipocategorias = tipocategorias;
    }
   
    public String getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public Set getTipocategorias() {
        return this.tipocategorias;
    }
    
    public void setTipocategorias(Set tipocategorias) {
        this.tipocategorias = tipocategorias;
    }




}


