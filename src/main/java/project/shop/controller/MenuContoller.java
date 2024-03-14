package project.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import project.shop.service.MenuService;
import project.shop.vo.MenuVo;


@Controller
@RequiredArgsConstructor
@Slf4j
public class MenuContoller {

    @Autowired
    MenuService menusvc;

    // 메뉴리스트
    @RequestMapping("/menu")
    public String doMenu(Model model) {
        
        List<MenuVo> menulist = menusvc.dolist();

        model.addAttribute("list", menulist);
        return "/menu/menu";
    }

}
