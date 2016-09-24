/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.HibernateUtil;
import DAOInterfaces.encrud;
import Entidades.Anuncio;
import Entidades.AnuncioJoin;
import Entidades.Categoria;
import Entidades.Tipocategoria;
import Entidades.Usuario;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

/**
 *
 * @author STALING
 */
public class AnuncionDAO implements encrud<Anuncio> {

    public static void main(String[] args) {
        try {
            System.out.println(new AnuncionDAO().getGaleria("3"));
        } catch (Exception e) {
            System.out.println("este es mi error " + e.getMessage());
        }

    }

    public AnuncioJoin getGaleria(String Buscar) throws Exception {
        Session session = null;
        SessionFactory sf = null;

        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            //// Anuncio A = (Anuncio) session.get(Anuncio.class, Integer.parseInt(Buscar));

            AnuncioJoin A = (AnuncioJoin) session.createCriteria(Anuncio.class, "A")
                    .createAlias("A.usuario", "user")
                    .add(Restrictions.idEq(Integer.parseInt(Buscar)))
                    .setProjection(
                            Projections.projectionList()
                            .add(Projections.property("A.id").as("id"))
                            .add(Projections.property("A.categoria").as("categoria"))
                            .add(Projections.property("A.descripcion").as("descripcion"))
                            .add(Projections.property("A.precio").as("precio"))
                            .add(Projections.property("A.moneda").as("moneda"))
                            .add(Projections.property("A.precio").as("precio"))
                            .add(Projections.property("A.whatsap").as("whatsap"))
                            .add(Projections.property("A.tipo").as("tipo"))
                            .add(Projections.property("A.titulo").as("titulo"))
                            .add(Projections.property("A.publicado").as("publicado"))
                            .add(Projections.property("user.id").as("idusuario"))
                            .add(Projections.property("user.nombre").as("nombreusuario"))
                            .add(Projections.property("user.apellidos").as("apellidosusuario"))
                            .add(Projections.property("user.sexo").as("sexousuario"))
                            .add(Projections.property("user.edad").as("edadusuario"))
                            .add(Projections.property("user.telefono").as("telefonousuario"))
                            .add(Projections.property("user.email").as("emailusuario"))
                            .add(Projections.property("A.foto1").as("foto1"))
                            .add(Projections.property("A.foto2").as("foto2"))
                            .add(Projections.property("A.foto3").as("foto3"))
                            .add(Projections.property("A.foto4").as("foto4"))
                            .add(Projections.property("A.foto5").as("foto5"))
                    )
                    .setResultTransformer(Transformers.aliasToBean(AnuncioJoin.class))
                    .uniqueResult();
            session.close();
            sf.close();

            return A;
        } catch (Exception e) {

            session.close();
            sf.close();
            throw new Exception(e.getMessage());

        }

    }

    public List<Tipocategoria> getTipoCategoria() throws Exception {
        Session session = null;
        SessionFactory sf = null;
        List<Tipocategoria> listado = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            listado = session.createCriteria(Tipocategoria.class).list();

            session.close();
            sf.close();

            return listado;

        } catch (Exception e) {
            session.close();
            sf.close();
            throw new Exception(e.getMessage());

        }

    }

    public boolean Eliminar(int idAnuncio) throws Exception {
        Session session = null;
        SessionFactory sf = null;
        Transaction tx = null;

        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();

            Anuncio A = (Anuncio) session.get(Anuncio.class, idAnuncio);

            System.out.println(A.getCategoria());

            session.delete(A);
            tx.commit();
            session.close();
            sf.close();

            return true;

        } catch (Exception e) {
            tx.rollback();
            session.close();
            sf.close();
            throw e;

        }

    }

    public List<Categoria> getCategoria() throws Exception {
        Session session = null;
        SessionFactory sf = null;
        List<Categoria> listado = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            listado = session.createCriteria(Categoria.class).list();

            session.close();
            sf.close();

            return listado;

        } catch (Exception e) {
            session.close();
            sf.close();
            throw new Exception(e.getMessage());

        }

    }

    public List<Anuncio> getMisAnuncios(int IDUsuario) throws Exception {
        Session session = null;
        SessionFactory sf = null;
        List<Anuncio> listado = null;
        Usuario us = new Usuario();
        us.setId(52);
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            listado = session.createCriteria(Anuncio.class)
                    .add(Restrictions.eq("usuario.id", IDUsuario))
                    .setMaxResults(10)
                    .addOrder(Order.desc("id"))
                    .list();

            session.close();
            sf.close();

            return listado;

        } catch (Exception e) {
            session.close();
            sf.close();
            throw new Exception(e.getMessage());

        }

    }

    public List<Anuncio> getAnuncios() throws Exception {
        Session session = null;
        SessionFactory sf = null;
        List<Anuncio> listado = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            listado = session.createCriteria(Anuncio.class)
                    .setMaxResults(13)
                    .addOrder(Order.desc("id"))
                    .list();

            session.close();
            sf.close();

            return listado;

        } catch (Exception e) {
            session.close();
            sf.close();
            throw new Exception(e.getMessage());

        }

    }

    public List<Anuncio> getSiguientesAnuncios(int idUltimo) throws Exception {
        Session session = null;
        SessionFactory sf = null;
        List<Anuncio> listado = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            SQLQuery sql = session.createSQLQuery("select * from anuncio where id < ? ORDER BY id DESC");
            sql.addEntity(Anuncio.class);
            sql.setInteger(0, idUltimo);
            sql.setMaxResults(13);
            listado = sql.list();

            session.close();
            sf.close();

            return listado;

        } catch (Exception e) {
            session.close();
            sf.close();
            throw new Exception(e.getMessage());

        }

    }

    public List<Anuncio> atrasCatalogo(int idUltimo) throws Exception {
        Session session = null;
        SessionFactory sf = null;
        List<Anuncio> listado = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
           listado = session.createCriteria(Anuncio.class)
                    .add(
                            Restrictions.gt("id", idUltimo)
                    )
                    .setMaxResults(13)
                    .addOrder(Order.asc("id"))
                   
                    .list();

            return listado;

        } catch (Exception e) {
            session.close();
            sf.close();
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public boolean guardar(Anuncio tipo) throws Exception {
        SessionFactory sf = null;
        Session session = null;

        Transaction tx = null;

        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(tipo);
            tx.commit();
            session.close();
            sf.close();
            return true;

        } catch (Exception e) {
            tx.rollback();
            session.close();
            sf.close();
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean eleminar(Anuncio tipo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Anuncio tipo) throws Exception {
        SessionFactory sf = null;
        Session session = null;

        Transaction tx = null;

        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.update(tipo);
            tx.commit();
            session.close();
            sf.close();
            return true;

        } catch (Exception e) {
            tx.rollback();
            session.close();
            sf.close();
            throw new Exception(e.getMessage());
        }
    }
}
