/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import org.springframework.web.portlet.ModelAndView;
import indieshop.model.UsuariosModel;
import indieshop.entities.Usuarios;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author roco_
 */
@Controller
public class indexController {
    UsuariosModel usua= new UsuariosModel();
       @RequestMapping("inicio")
    public String inicio (Model model, HttpSession ucli)
    {
        ucli.setAttribute("uid", "1");
        return"index";
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
    public String getValidaLogin(HttpServletRequest req,HttpServletResponse res,Model model)
    {
        String usu=req.getParameter("usu");
        String pas=req.getParameter("pass");
        model.addAttribute("us", usu);
        model.addAttribute("pa", pas);
        Usuarios u= usua.usuarioLogin(usu, pas);
        model.addAttribute("idu", usua.usuarioLogin(usu, pas));
        
                    return "error";

        
    }
}
