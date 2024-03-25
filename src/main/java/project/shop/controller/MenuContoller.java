package project.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
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

    @GetMapping("/pay_seccess")
    public String payment(@RequestParam String sf) {
        if(sf.equals("success")){
            menusvc.dodeletecart();
        }
        return "menu/paysuccess";
    }

//    인덱스 -> 카트 이동
    @GetMapping("coffeeorder")
    public String order(Model model){

        List<OrderVo> orderlist = menusvc.doorderlist();
        model.addAttribute("list", orderlist);
        return "menu/coffeeorder";
    }

//장바구니 리스트 중 한줄만 삭제
    @GetMapping("deleteOne")
    public String deleteOne(@RequestParam String orderid, @RequestParam String ordermenu){

        menusvc.dodeleteone(orderid, ordermenu);

        return "redirect:/coffeeorder";
    }


//    장바구니에 물건 담은 후 장바구니로 이동
    @GetMapping("/cart")
    public String cartadd(@ModelAttribute OrderVo ordervo, Model model){

        menusvc.docartadd(ordervo);

        List<OrderVo> orderlist = menusvc.doorderlist();
        model.addAttribute("list", orderlist);
        return "menu/coffeeorder";
    }

//    장바구니에 물건 담은 후 메뉴로 이동
    @GetMapping("/cartback")
    public String cartaddback(@ModelAttribute OrderVo ordervo){

        menusvc.docartadd(ordervo);

        return "redirect:/menu";
    }
}