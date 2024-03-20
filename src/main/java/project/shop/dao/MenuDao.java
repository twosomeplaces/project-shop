package project.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import project.shop.vo.MenuVo;

@Mapper
public interface MenuDao {

    List<MenuVo> doList();

}