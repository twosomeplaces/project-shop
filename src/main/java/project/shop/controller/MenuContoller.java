package project.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import project.shop.service.MenuService;
import project.shop.vo.MenuVo;
import project.shop.vo.OrderVo;


@Controller
@Slf4j
public class MenuContoller {

    @Autowired
    MenuService menusvc;

    @GetMapping("/menu")
    public String doMenu(Model model) {
        List<MenuVo> menulist = menusvc.dolist();
        log.info("doMenuList = {}", menulist.size());
        model.addAttribute("list", menulist);

        return "menu/menu";
    }


    @GetMapping("/coffeeorderOne")
    public String doOrder(@RequestParam String menuname, @RequestParam String menuprice, Model model) {

        model.addAttribute("menuname",menuname);
        model.addAttribute("menuprice",menuprice);


        return "menu/coffeeorder";
    }


    @GetMapping("/pay_seccess")
    public String payment() {
        return "menu/paysuccess";
    }


    @GetMapping("/cart")
    public String cartadd(@ModelAttribute OrderVo ordervo){

        menusvc.docartadd(ordervo);

        return "redirect:/menu";
    }
}