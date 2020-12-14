/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop.controller;

import indieshop.entities.Clientes;
import indieshop.entities.Usuarios;
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
     
@RequestMapping("usuarios")
public class UsuariosController {
          
  ClientesModel clientesModel = new ClientesModel();
  UsuariosModel usuariosModel = new UsuariosModel();
  TipoUsuarioModel tipoUsuarioModel = new TipoUsuarioModel();

    @RequestMapping("cat")
    public String listarUsuarios(Model model) {
        model.addAttribute("listarUsuarios", usuariosModel.listarUsuarios());
         model.addAttribute("listarTiposUsuarios", tipoUsuarioModel.listarTiposUsuario());
        return "usuarios/listar";
    }

    @RequestMapping(value = "crear", method = RequestMethod.GET)
    public String nuevoUsuarios(Model model) {
        model.addAttribute("listarTiposUsuarios", tipoUsuarioModel.listarTiposUsuario());
        model.addAttribute("listarUsuarios", usuariosModel.listarUsuarios());
        model.addAttribute("usuarios", new Usuarios());
        return "usuarios/nuevo";
    }

    @RequestMapping(value = "crear", method = RequestMethod.POST)
    public String insertarUsuarios(@ModelAttribute("clientes") Usuarios usuario, Model model, RedirectAttributes atributos) {
        if (usuariosModel.insertarUsuarios(usuario) > 0) {
            atributos.addFlashAttribute("exito", "usuario registrado exitosamente");
            return "redirect:/usuarios/cat";
        } else {
            model.addAttribute("listarUsuarios", usuariosModel.listarUsuarios());
             model.addAttribute("listarTiposUsuarios", tipoUsuarioModel.listarTiposUsuario());
            model.addAttribute("usuarios", usuario);
                       return "usuarios/nuevo";

        }
    }
    @RequestMapping (value = "edit/{codigo}", method = RequestMethod.GET)
         public String obtenerUsuarios(@PathVariable("codigo") String codigo, Model model)
         {
             model.addAttribute("usuarios", usuariosModel.obtenerUsuarios(codigo));
              model.addAttribute("listarTiposUsuarios", tipoUsuarioModel.listarTiposUsuario());
             model.addAttribute("listarUsuarios", usuariosModel.listarUsuarios());
             return "usuarios/editar";
         }
         @RequestMapping (value = "edit/{codigo}", method = RequestMethod.POST)
         public String modificarUsuarios(Usuarios usuario, Model model, RedirectAttributes atributos){
             if (usuariosModel.modificarUsuarios(usuario)>0)
             {
                 atributos.addFlashAttribute("exito", "editorial modificada con exito");
                 return "redirect:/usuarios/cat";
             }
             else
             {
                  model.addAttribute("listarTiposUsuarios", tipoUsuarioModel.listarTiposUsuario());
                 model.addAttribute("listarUsuarios", usuariosModel.listarUsuarios());
                 model.addAttribute("usuarios", usuario);
                 return "usuarios/editar";
             }
         }
         
         @RequestMapping("delete/{codigo}")
         public String eliminarClientes(@PathVariable("codigo") String codigo, Model model, RedirectAttributes atributos)
         {
             if (usuariosModel.eliminarUsuarios(codigo)>0)
             {
                 atributos.addFlashAttribute("exito", "editorial eliminada exitosamente");
             }
             else
             {
                 atributos.addFlashAttribute("fracaso", "no se puede eliminar");
             }
             return "redirect:/usuarios/cat";
         }
    
}
    

