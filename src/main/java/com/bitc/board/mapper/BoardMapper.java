package com.bitc.board.mapper;

import com.bitc.board.dto.BoardDto;
import com.bitc.board.dto.BoardFileDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// @Mapper : MyBatis 를 사용하여 실제 xml 파일과 연동되는 파일임을 나타내는 어노테이션
@Mapper
public interface BoardMapper {

    List<BoardDto> selectBoardList() throws Exception;

    void insertBoard(BoardDto board) throws Exception;

    BoardDto selectBoardDetail(int boardIdx) throws Exception;

    void updateBoard(BoardDto board) throws Exception;

//    @Param : xml에서 사용할 파라미터의 이름을 지정하고자할 경우 사용하는 어노테이션
    void deleteBoard(@Param("boardIdx") int index) throws Exception;

    void updateHitCnt(int boardIdx) throws Exception;

//    첨부파일을 데이터 베이스에 저장할 메서드 생성
    void insertBoardFileList(List<BoardFileDto> fileList) throws Exception;

//    첨부 파일 목록을 가져올 메서드 생성
    List<BoardFileDto> selectBoardFileList(int boardIdx) throws Exception;
}
