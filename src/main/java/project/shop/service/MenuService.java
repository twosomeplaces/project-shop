package project.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.shop.dao.MenuDao;
import project.shop.vo.MenuVo;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuDao menuDao;


    public List<MenuVo> dolist(){

        List<MenuVo> list = menuDao.doList();

        return list;

    };
}
