/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop.model;

import indieshop.entities.CategoriaProductos;
import indieshop.entities.TiposUsuarios;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author roco_
 */
public class TipoUsuarioModel {
    SessionFactory factory = HibernateUtil.getSessionFactory();

    public List<TiposUsuarios> listarTiposUsuario() {
        Session ses = factory.openSession();
        try {
            Query cat = ses.createQuery("SELECT cat FROM TiposUsuarios cat");
            List<TiposUsuarios> lista = cat.list();
            ses.close();
            return lista;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    
    }
}
