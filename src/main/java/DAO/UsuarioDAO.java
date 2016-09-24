/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author STALING
 */
import Conexion.HibernateUtil;
import DAOInterfaces.encrud;
import Entidades.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class UsuarioDAO implements encrud<Usuario> {

    @Override
    public boolean guardar(Usuario tipo) throws Exception {
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

    public static void main(String[] args) {
        UsuarioDAO user = new UsuarioDAO();
        //Usuario use = new Usuario(null, null, null, 0, telefono, cedula, null, email, null);

        try {
            System.out.println(user.verificar(null));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean verificar(Usuario usuario) throws Exception {
        Session session = null;
        SessionFactory sf = null;
        Usuario listado = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            listado = (Usuario) session.createCriteria(Usuario.class)
                    .add(
                            Restrictions.eq("telefono", usuario.getTelefono())
                    ).uniqueResult();

            session.close();
            sf.close();
            if (listado == null) {
                return false;

            } else {

                return true;
            }
        } catch (Exception e) {
            session.close();
            sf.close();
            throw new Exception(e.getMessage());

        }

    }

    public Usuario iniciarSession(Usuario user) throws Exception {
        Session session = null;
        SessionFactory sf = null;
        Usuario listado = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();

            listado = (Usuario) session.createCriteria(Usuario.class).add(
                    Restrictions.and(
                            Restrictions.eq("email", user.getEmail()),
                            Restrictions.eq("clave", user.getClave())
                    ))
                    .uniqueResult();
            session.close();
            sf.close();
            return listado;

        } catch (Exception e) {
            session.close();
            sf.close();
            throw new Exception(e.getMessage());

        }

    }

    @Override
    public boolean eleminar(Usuario tipo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Usuario tipo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
