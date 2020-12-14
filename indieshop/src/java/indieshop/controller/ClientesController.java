/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop.controller;

import indieshop.entities.Clientes;
import indieshop.model.ClientesModel;
import indieshop.model.TipoUsuarioModel;
import indieshop.model.UsuariosModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author roco_
 */
 @Controller
     
@RequestMapping("clientes")
public class ClientesController {
    
      
  ClientesModel clientesModel = new ClientesModel();
  UsuariosModel usuariosModel = new UsuariosModel();
  TipoUsuarioModel tipoUsuarioModel = new TipoUsuarioModel();

    @RequestMapping("cat")
    public String listarClientes(Model model) {
       
        model.addAttribute("listarClientes", clientesModel.listarClientes());
      
        return "clientes/cat_clie";
    }

    @RequestMapping(value = "crear", method = RequestMethod.GET)
    public String nuevoClientes(Model model) {
        model.addAttribute("listarUsuarios", usuariosModel.listarUsuarios());
        model.addAttribute("clientes", new Clientes());
        return "clientes/nuevo";
    }

    @RequestMapping(value = "crear", method = RequestMethod.POST)
    public String insertarClientes(@ModelAttribute("clientes") Clientes clie, Model model, RedirectAttributes atributos) {
        if (clientesModel.insertarClientes(clie) > 0) {
            atributos.addFlashAttribute("exito", "Cliente registrado exitosamente");
            return "redirect:/clientes/cat";
        } else {
            model.addAttribute("listarTiposUsuarios", tipoUsuarioModel.listarTiposUsuario());
            model.addAttribute("listarUsuarios", usuariosModel.listarUsuarios());
            model.addAttribute("clientes", clie);
                       return "clientes/nuevo";

        }
    }
    @RequestMapping (value = "edit/{codigo}", method = RequestMethod.GET)
         public String obtenerCliente(@PathVariable("codigo") String codigo, Model model)
         {
             model.addAttribute("clientes", clientesModel.obtenerClientes(codigo));
            model.addAttribute("listarTiposUsuarios", tipoUsuarioModel.listarTiposUsuario());
            model.addAttribute("listarUsuarios", usuariosModel.listarUsuarios());
             return "clientes/editar";
         }
         @RequestMapping (value = "edit/{codigo}", method = RequestMethod.POST)
         public String modificarClientes(Clientes clie, Model model, RedirectAttributes atributos){
             if (clientesModel.modificarClientes(clie)>0)
             {
                 atributos.addFlashAttribute("exito", "editorial modificada con exito");
                 return "redirect:/clientes/cat";
             }
             else
             {
                 model.addAttribute("listarUsuarios", usuariosModel.listarUsuarios());
                 model.addAttribute("clientes", clie);
                 return "clientes/editar";
             }
         }
         
         @RequestMapping("delete/{codigo}")
         public String eliminarClientes(@PathVariable("codigo") String codigo, Model model, RedirectAttributes atributos)
         {
             if (clientesModel.eliminarClientes(codigo)>0)
             {
                 atributos.addFlashAttribute("exito", "editorial eliminada exitosamente");
             }
             else
             {
                 atributos.addFlashAttribute("fracaso", "no se puede eliminar");
             }
             return "redirect:/clientes/cat";
         }
    
}
