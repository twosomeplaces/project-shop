package project.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import project.shop.dao.BoardDao;
import project.shop.vo.BoardVo;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardDao boardDao;

    public List<BoardVo> findAll() {
        List<BoardVo> items = boardDao.findAll();
        return items;
    }

    public BoardVo findOne(int boardNo) {
        BoardVo item = boardDao.findOne(boardNo);
        return item;
    }

    public void save(BoardVo form) {
        boardDao.save(form);
    }


    @Transactional
    public BoardVo updateBoard(int boardNo, String title, String content, int file) {
        BoardVo findBoard =  boardDao.updateBoard(boardNo, title, content, file );
        return findBoard;
    }
    
}
