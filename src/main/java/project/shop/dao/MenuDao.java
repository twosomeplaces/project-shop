package project.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import org.springframework.web.bind.annotation.RequestParam;
import project.shop.vo.MenuVo;
import project.shop.vo.OrderVo;

@Mapper
public interface MenuDao {

    List<MenuVo> doList();

    void docartadd(OrderVo ordervo);

    List<OrderVo> doorderlist();
}