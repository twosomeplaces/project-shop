package project.shop.dao;

import org.apache.ibatis.annotations.Mapper;

import project.shop.vo.MemberVo;

@Mapper
public interface MemberDao {

    void save(MemberVo memberVo);
    
}
