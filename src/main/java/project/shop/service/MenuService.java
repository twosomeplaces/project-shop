package project.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestParam;
import project.shop.dao.MenuDao;
import project.shop.vo.MenuVo;
import project.shop.vo.OrderVo;

@Service
public class MenuService {

    @Autowired
    MenuDao menuDao;


//    메뉴리스트 조회
    public List<MenuVo> dolist(){

        List<MenuVo> list = menuDao.doList();

        return list;

    };

//    장바구니 담기
    public void docartadd(OrderVo ordervo) {

        menuDao.docartadd(ordervo);
    }


//장바구니 조회
    public List<OrderVo> doorderlist() {
        String id = "aa1";// 시큐리티에서 아이디 받아오면 그걸로 변경예정. 임시로 넣어둔거임.
        List<OrderVo> list = menuDao.doorderlist(id);

        return list;
    }

//    장바구니전체삭제
    public void dodeletecart() {
        String id = "aa1"; // 시큐리티에서 아이디 받아오면 그걸로 변경예정. 임시로 넣어둔거임.
        menuDao.dodeletecart(id);
    }

//    장바구니 한줄삭제
    public void dodeleteone(String orderid, String ordermenu) {
        menuDao.dodeleteone(orderid,ordermenu);
    }
}
