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

//    장바구니조회
    List<OrderVo> doorderlist(@RequestParam String id);

//    장바구니 전체삭제
    void dodeletecart(@RequestParam String id);

//    장바구니 한줄삭제
    void dodeleteone(String orderid, String ordermenu);
}