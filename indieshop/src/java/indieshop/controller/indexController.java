/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import org.springframework.web.portlet.ModelAndView;
import indieshop.model.UsuariosModel;
import indieshop.entities.Usuarios;
import indieshop.entities.Clientes;
import indieshop.model.ClientesModel;
import indieshop.entities.Productos;
import indieshop.model.FacturacionModel;
import indieshop.entities.Facturacion;
import indieshop.model.ProductosModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author roco_
 */
@Controller
public class indexController {
    UsuariosModel usua= new UsuariosModel();
    ClientesModel cli= new ClientesModel();
    ProductosModel pro= new ProductosModel();
    FacturacionModel fact=new FacturacionModel();
    
       @RequestMapping("inicio")
    public String inicio (Model model, HttpSession ucli)
    {
        model.addAttribute("listaP", pro.listarProductos());
        //ucli.setAttribute("uid", "1");
        return"index";
    }
    
    @RequestMapping("iniciocli")
    public String iniciocliente (Model model, HttpSession ucli)
    {
        model.addAttribute("listaP", pro.listarProductos());
        //ucli.setAttribute("uid", "1");
        return"indexcli";
    }
    
    @RequestMapping("inicioini")
    public String inicioini (Model model, HttpSession ucli)
    {
        model.addAttribute("listaP", pro.listarProductos());
        //ucli.setAttribute("uid", "1");
        return"indexini";
    }
    
      @RequestMapping("reg")
    public String pop (Model model, HttpSession ucli)
    {
        //ucli.setAttribute("uid", "1");
        return"usuarios/crearr";
    }
    
    @RequestMapping("log")
    public String pop (Model model)
    {
        return"sesion/login";
    }
    
    @RequestMapping("error")
    public ModelAndView getError()
    {
        ModelAndView modelo= new ModelAndView();
        modelo.setViewName("error");
        return modelo;
    }
    
    @RequestMapping(value="validador", method = RequestMethod.POST)
    public String getValidaLogin(HttpServletRequest req,HttpServletResponse res,Model model,
            HttpSession ucli)
    {
        List<Usuarios> u=new ArrayList<>();
        List<Clientes> c=new ArrayList<>();
        String usu=req.getParameter("usu");
        String pas=req.getParameter("pass");
        model.addAttribute("us", usu);
        model.addAttribute("pa", pas);
        u= usua.UsuarioLogin(usu, pas);
        ucli.setAttribute("nuevo", usua.ObtenerId());
        if(u.size()>0)
        {
            ucli.setAttribute("nomUsua", u.get(0).getNomUs());
            c=cli.ClientesID(u.get(0).getIdUs());
            ucli.setAttribute("idCli", c.get(0));
            ucli.setAttribute("idFac", fact.insertarFactura(c.get(0)));
            ucli.setAttribute("nicCli", u.get(0).getNicUs());
            ucli.setAttribute("", u.get(0).getIdUs());
            if(u.get(0).getTiposUsuarios().getIdTu().equals("2"))
            {
            return "indexcli";
            }
            else
            {
                //ucli.setAttribute("nomUsua", "");
            }
            
        return "index";
        }
        else
        {
                    return "error";
        }
        
    }
}
