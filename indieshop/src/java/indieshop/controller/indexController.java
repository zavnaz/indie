/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indieshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author roco_
 */
@Controller
public class indexController {
       @RequestMapping("inicio")
    public String inicio (Model model)
    {
        return"index";
    }
    
    @RequestMapping("p")
    public String pop (Model model)
    {
        return"pop";
    }
}
