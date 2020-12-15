/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop.model;


import indieshop.entities.Clientes;
import indieshop.entities.Usuarios;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author roco_
 */
public class UsuariosModel {
     SessionFactory factory = HibernateUtil.getSessionFactory();
    
         
     public int insertarUsuarios(Usuarios usu) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.save(usu);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

    public int modificarUsuarios(Usuarios usu) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.update(usu);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

    public int eliminarUsuarios(String id) {
        int filasAfectadas = 0;
        Session ses = factory.openSession();
        try {
            Usuarios usuario = (Usuarios) ses.get(Usuarios.class, id);
            if (usuario != null) {
                Transaction tran = ses.beginTransaction();
                ses.delete(usuario);
                tran.commit();
                filasAfectadas = 1;
            }
            ses.close();
            return filasAfectadas;
        } catch (Exception e) {
            ses.close();
            return filasAfectadas;
        }
    }
    public Usuarios obtenerUsuarios(String codigo) {
        Session ses = factory.openSession();
        try {
            Usuarios usuario = (Usuarios) ses.get(Usuarios.class, codigo);
            
            ses.close();
            return usuario;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }
    public List<Usuarios> listarUsuarios() {
        Session ses = factory.openSession();
        try {
            Query consulta = ses.createQuery("SELECT a FROM Usuarios a");
            List<Usuarios> lista = consulta.list();
            ses.close();
            return lista;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    
    }
    
    public List<Usuarios> UsuarioLogin(String us,String pa) {
        Session ses = factory.openSession();
        try {
            Query consulta = ses.createQuery("SELECT a FROM Usuarios a where nicUs='"+us+"' AND passUs='"+pa+"'");
            List<Usuarios> lista = consulta.list();
            ses.close();
            return lista;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }
}
