package project.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.shop.service.MenuService;
import project.shop.vo.MenuVo;


@Controller
public class MenuContoller {

    @Autowired
    MenuService menusvc;

    @GetMapping("/menu")
    public String doMenu(Model model) {
        
        List<MenuVo> menulist = menusvc.dolist();

        model.addAttribute("list", menulist);


        return "/menu/menu";
    }


    @GetMapping("/Coffee_orderOne")
    public String doOrder(@RequestParam String menuname, @RequestParam String menuprice, Model model) {

        model.addAttribute("menuname",menuname);
        model.addAttribute("menuprice",menuprice);


        return "/menu/Coffee_order";
    }


    @GetMapping("/pay_seccess")
    public String payment() {
        return "/menu/pay_success";
    }
}
