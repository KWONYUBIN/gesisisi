package com.example.prjjsp2.controller;

import com.example.prjjsp2.dto.Board;
import com.example.prjjsp2.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {

    private final BoardService service;

    @GetMapping("new")
    public void newBoard() {

    }

    @PostMapping("new")
    public String newBoard(Board board, RedirectAttributes rttr) {
        service.add(board);

        rttr.addFlashAttribute("message",
                Map.of("type", "success",
                        "text", "새 게시물이 등록되었습니다"));
        rttr.addAttribute("id", board.getId());


        return null;
    }

    @GetMapping("list")
    public void listBoard(@RequestParam(name = "page", defaultValue = "1") Integer page,
                          Model model) {
        // 한 페이지에 10개의 게시물

        Map<String, Object> result = service.list(page);
        model.addAllAttributes(result);

    }

    @GetMapping("view")
    public void viewBoard(Integer id, Model model) {
        Board board = service.get(id);
        model.addAttribute("board", board);
    }

}
