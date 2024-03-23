package project.shop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import project.shop.service.BoardService;
import project.shop.vo.BoardVo;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
   

    @GetMapping
    public String boardList(Model model){
        List<BoardVo> items = boardService.findAll();
        log.info("boardList = {}", items.size());
        model.addAttribute("items", items);
        return "board/boardList";
    }

    @GetMapping("/{boardNo}")
    public String board(@PathVariable int boardNo, Model model){
        BoardVo findOne = boardService.findOne(boardNo);
        model.addAttribute("board", findOne);
        return "board/board";
    }

    @GetMapping("/add")
    public String addBoard(Model model){
        model.addAttribute("boardVo", new BoardVo());
        return "board/addBoard";
    }
    
}
