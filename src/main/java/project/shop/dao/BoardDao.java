package project.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import project.shop.vo.BoardVo;

@Mapper
public interface BoardDao {

    List<BoardVo> findAll();

    BoardVo findOne(int boardNo);

    void save(BoardVo form);

    BoardVo updateBoard(int boardNo, String title, String content, String file);
    
}
