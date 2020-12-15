/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop.controller;

import indieshop.entities.Clientes;
import indieshop.entities.Valoracion;
import indieshop.model.ClientesModel;
import indieshop.model.ProveedorModel;
import indieshop.model.UsuariosModel;
import indieshop.model.ValoracionModel;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;
/**
 *
 * @author roco_
 */
@Controller

@RequestMapping("valoracion")
public class ValoracionController {
    UsuariosModel usuarioM = new UsuariosModel();
    ClientesModel clienteM = new ClientesModel();
    ProveedorModel proveedorM = new ProveedorModel();
    ValoracionModel valoracionM = new ValoracionModel();

    @RequestMapping("cat")
    public String listarValoracion(Model model) {
        model.addAttribute("listarValoracion", valoracionM.listarValoracion());
        model.addAttribute("listarProveedor", proveedorM.listarProveedor());
       model.addAttribute("listarUsuario", usuarioM.listarUsuarios());
       model.addAttribute("listarCliente", clienteM.listarClientes());
       
        return "valoracion/listar";
    }
    
    @RequestMapping("catcli")
    public String listarValoracioncli(Model model) {
        model.addAttribute("listarValoracion", valoracionM.listarValoracion());
        model.addAttribute("listarProveedor", proveedorM.listarProveedor());
       model.addAttribute("listarUsuario", usuarioM.listarUsuarios());
       model.addAttribute("listarCliente", clienteM.listarClientes());
       
        return "valoracion/listarcli";
    }

    @RequestMapping(value = "crear", method = RequestMethod.GET)
    public String nuevoValoracion(Model model, HttpSession a) {
       
        model.addAttribute("listarValoracion", valoracionM.listarValoracion());
        model.addAttribute("listarProveedor", proveedorM.listarProveedor());
        model.addAttribute("listarUsuario", usuarioM.listarUsuarios());
        model.addAttribute("listarCliente", clienteM.listarClientes());
        model.addAttribute("valoracion", new Valoracion());
        return "valoracion/nuevo";
    }

    @RequestMapping(value = "crear", method = RequestMethod.POST)
    public String insertarValoracion(@ModelAttribute("valoracion") Valoracion usuario, Model model,
            RedirectAttributes atributos, HttpSession scli) {
        usuario.setClientes((Clientes)scli.getAttribute("idCli"));
        if (valoracionM.insertarValoracion(usuario) > 0) {
            atributos.addFlashAttribute("exito", "usuario registrado exitosamente");
            return "redirect:/valoracion/catcli";
        } else {
            model.addAttribute("listarValoracion", valoracionM.listarValoracion());
            model.addAttribute("listarProveedor", proveedorM.listarProveedor());
            model.addAttribute("listarUsuario", usuarioM.listarUsuarios());
            model.addAttribute("listarCliente", clienteM.listarClientes());
            
            
            model.addAttribute("usuarios", usuario);
            return "valoracion/listarcli";

        }
    }

    @RequestMapping("delete/{codigo}")
    public String eliminarValoracion(@PathVariable("codigo") String codigo, Model model, RedirectAttributes atributos) {
        if (valoracionM.eliminarValoracion(codigo) > 0) {
            atributos.addFlashAttribute("exito", "editorial eliminada exitosamente");
        } else {
            atributos.addFlashAttribute("fracaso", "no se puede eliminar");
        }
        return "redirect:/valoracion/cat";
    }

}
