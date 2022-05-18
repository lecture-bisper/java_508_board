package com.bitc.board.service;

import com.bitc.board.dto.ItemDto;

import java.util.List;

public interface ThymeleafService {
    ItemDto createData() throws Exception;

    List<ItemDto> createDataList() throws Exception;
}
