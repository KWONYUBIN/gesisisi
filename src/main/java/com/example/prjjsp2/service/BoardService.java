package com.example.prjjsp2.service;

import com.example.prjjsp2.dto.Board;
import com.example.prjjsp2.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper mapper;

    public void add(Board board) {
        mapper.insert(board);
    }

    public Map<String, Object> list(Integer page) {

        Integer offset = (page - 1) * 10;
        List<Board> list = mapper.selectAll();

        Map<String, Object> map = new HashMap<>();

        map.put("boardList", list);
        return map;
    }

    public Board get(Integer id) {
        return mapper.selectById(id);
    }


}
