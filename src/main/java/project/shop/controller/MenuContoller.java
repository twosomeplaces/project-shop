package project.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import project.shop.service.MenuService;


@Controller
public class MenuContoller {

    @Autowired
    MenuService menusvc;

    @GetMapping("/menu")
    public String doMenu(Model model) {
        


        return "/menu/menu";
    }
    
}
