package project.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.shop.dao.MenuDao;
import project.shop.vo.MenuVo;
import project.shop.vo.OrderVo;

@Service
public class MenuService {

    @Autowired
    MenuDao menuDao;


    public List<MenuVo> dolist(){

        List<MenuVo> list = menuDao.doList();

        return list;

    };

    public void docartadd(OrderVo ordervo) {

        menuDao.docartadd(ordervo);
    }

    public List<OrderVo> doorderlist() {

        List<OrderVo> list = menuDao.doorderlist();
        return list;
    }
}
