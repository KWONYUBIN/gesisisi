package com.example.prjjsp2.mapper;

import com.example.prjjsp2.dto.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Insert("""
            INSERT INTO board
            (title, content, writer)
            VALUES (#{title}, #{content}, #{writer})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Board board);

    @Select("""
            SELECT * FROM board
            ORDER BY id DESC
            """)
    List<Board> selectAll();


    @Select("""
            SELECT * FROM board
            WHERE id = #{id}
            """)
    Board selectById(Integer id);
}
