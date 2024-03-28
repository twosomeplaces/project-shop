package project.shop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("form", new BoardVo());
        return "board/addBoardForm";
    }

    @PostMapping("/add")
    public String addBoradForm(BoardVo form){
        log.info("addBoradForm = {}", form.toString());
        boardService.save(form);
        return "redirect:/board";
    }

    @GetMapping("/{boardNo}/edit")
    public String updateItemForm(@PathVariable("boardNo") int boardNo, Model model){
        BoardVo book = boardService.findOne(boardNo);
        log.info("updateBoardForm = {}", book.toString());
        // BookForm form  = new BookForm();
        // form.setId(book.getId());
        // form.setName(book.getName());
        // form.setPrice(book.getPrice());
        // form.setStockQuantity(book.getStockQuantity());
        // form.setAuthor(book.getAuthor());
        // form.setIsbn(book.getIsbn());

        model.addAttribute("form", book);

        return "board/updateBoardForm";
    }
    
}
