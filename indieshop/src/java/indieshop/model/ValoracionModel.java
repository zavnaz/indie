/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop.model;

import indieshop.entities.Usuarios;
import indieshop.entities.Valoracion;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author roco_
 */
public class ValoracionModel {
    SessionFactory factory = HibernateUtil.getSessionFactory();
    
     public int insertarValoracion(Valoracion val) {
        Session ses = factory.openSession();
        try {
            Query consulta = ses.createQuery("SELECT a FROM ProductosFactura a order by idPfac desc");
            List<Valoracion> lista = consulta.list();
            int i= Integer.parseInt(lista.get(0).getIdVal());
            i++;
            val.setIdVal(Integer.toString(i));
            Transaction tran = ses.beginTransaction();
            ses.save(val);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
     }
        public int eliminarValoracion(String id) {
        int filasAfectadas = 0;
        Session ses = factory.openSession();
        try {
            Valoracion usuario = (Valoracion) ses.get(Valoracion.class, id);
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
         public List<Valoracion> listarValoracion() {
        Session ses = factory.openSession();
        try {
            Query consulta = ses.createQuery("SELECT a FROM Valoracion a");
            List<Valoracion> lista = consulta.list();
            ses.close();
            return lista;
        } catch (Exception e) {
            ses.close();
            return null;
        }
         }
      
}
