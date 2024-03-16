package project.shop.dao;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import project.shop.vo.MemberVo;

@Mapper
public interface MemberDao {

    void save(MemberVo memberVo);
    Optional<MemberVo> findOne(String insertedId);
    
}
