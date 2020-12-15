/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop.model;

import indieshop.entities.Clientes;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author roco_
 */
public class ClientesModel {
    SessionFactory factory = HibernateUtil.getSessionFactory();
      public int insertarClientes(Clientes clie) {
        Session ses = factory.openSession();
        try {
            Query consulta = ses.createQuery("SELECT a FROM Clientes a order by idCli desc");
            List<Clientes> lista = consulta.list();
            int i= Integer.parseInt(lista.get(0).getIdCli());
            i++;
            clie.setIdCli(Integer.toString(i));
            Transaction tran = ses.beginTransaction();
            ses.save(clie);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

    public int modificarClientes(Clientes clie) {
        Session ses = factory.openSession();
        try {
            Transaction tran = ses.beginTransaction();
            ses.update(clie);
            tran.commit();
            ses.close();
            return 1;
        } catch (Exception e) {
            ses.close();
            return 0;
        }
    }

    public int eliminarClientes(String id) {
        int filasAfectadas = 0;
        Session ses = factory.openSession();
        try {
            Clientes cliente = (Clientes) ses.get(Clientes.class, id);
            if (cliente != null) {
                Transaction tran = ses.beginTransaction();
                ses.delete(cliente);
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
    public Clientes obtenerClientes(String codigo) {
        Session ses = factory.openSession();
        try {
            Clientes clie = (Clientes) ses.get(Clientes.class, codigo);
            
            ses.close();
            return clie;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }

    public List<Clientes> listarClientes() {
        Session ses = factory.openSession();
        try {
            Query consulta = ses.createQuery("SELECT a FROM Clientes a");
            List<Clientes> lista = consulta.list();
            ses.close();
            return lista;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }
    
    public List<Clientes> ClientesID(String id) {
        Session ses = factory.openSession();
        try {
            Query consulta = ses.createQuery("SELECT a FROM Clientes a where usuarios.idUs="+id);
            List<Clientes> lista = consulta.list();
            ses.close();
            return lista;
        } catch (Exception e) {
            ses.close();
            return null;
        }
    }
    
}
