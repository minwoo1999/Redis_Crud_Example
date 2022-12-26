package com.example.realjpa.controller;

import com.example.realjpa.Service.BoardService;
import com.example.realjpa.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BoardController {


    //정리 forword 와 redirect의 차이

    //forword:이동한 페이지의 url정보를 확인할수없다.
    //redirect:웹브라우저는 url을 지시된 주소로 바꾸고 해당주소로 이동.
    @Autowired
    private BoardService boardService;

    //게시글상세

    @GetMapping("/getBoard")
    public String getBoard(Board board, Model model){
        model.addAttribute("board",boardService.getBoard(board));
        return "/getBoard";
    }
    //게시글목록
    @RequestMapping("/getBoardList")
    public String getBoardList(Model model, Board board){
        List<Board> boardList = boardService.getBoardList(board);

        model.addAttribute("boardList", boardList);
        return "getBoardList";
    }
    /*---------CREATE---------*/
    //게시글등록
    @GetMapping("/insertBoard")
    public String insertBoardView(){
        return "insertBoard";
    }
    //게시글등록
    @PostMapping("/insertBoard")
    public String insertBoard(Board board){
        System.out.println(board.getTitle());
        System.out.println(board.getWriter());
        System.out.println(board.getSeq());
        System.out.println(board.getTitle());
        boardService.insertBoard(board);
        return "redirect:getBoardList";
    }
    /*---------UPDATE---------*/
    //게시글수정
    @PostMapping("/updateBoard")
    public String updateBoard(Board board){
        boardService.updateBoard(board);
        return "forward:getBoardList";
    }
    /*---------DELETE---------*/
    //게시글삭제
    @GetMapping("/deleteBoard")
    public String deleteBoard(Board board){
        boardService.deleteBoard(board);
        return "forward:getBoardList";
    }
}
