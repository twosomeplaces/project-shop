// package project.shop.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;

// import project.shop.service.MenuService;
// import project.shop.vo.MenuVo;


// @Controller
// public class MenuContoller {

//     @Autowired
//     MenuService menusvc;
//     MenuVo menuvo;

//     @GetMapping("/menu")
//     public String doMenu(Model model) {
        
//         List<menuvo> menulist = menusvc.dolist();

//         model.addAttribute("list", menulist);


//         return "/menu/menu";
//     }
    
// }
