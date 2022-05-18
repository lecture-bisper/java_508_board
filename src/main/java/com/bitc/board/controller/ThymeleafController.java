package com.bitc.board.controller;

import com.bitc.board.dto.ItemDto;
import com.bitc.board.service.ThymeleafService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @RequestMapping : 해당 어노테이션을 클래스위에 사용할 경우 기본 주소로 인식을 함
@Controller
@RequestMapping(value="/thymeleaf")
public class ThymeleafController {

    @Autowired
    private ThymeleafService thService;

//    @GetMapping : 해당 어노테이션은 @RequestMapping과 동일한 기능을 가지고 있는 어노테이션
//    @RequestMapping의 경우는 GET, POST, PUT, DELETE 를 모두 지원하고, @GetMapping 은 GET 방식만 지원하는 어노테이션임
    @GetMapping(value = "/ex01")
    public String thymeleafEx01(Model model) {
        model.addAttribute("data", "타임리프 예제입니다.");
        return "thEx/thymeleafEx01";
    }

    @RequestMapping(value="/ex01-1", method = RequestMethod.GET)
    public ModelAndView thymeleafEx01() {
        ModelAndView mv = new ModelAndView("thEx/thymeleafEx01");
        mv.addObject("data", "타임리프 예제2입니다.");
        return mv;
    }

    @GetMapping(value="ex02")
    public ModelAndView thEx02() throws Exception {
        ModelAndView mv = new ModelAndView("thEx/thEx02");

        ItemDto itemDto = new ItemDto();
        itemDto.setItemDetail("상품 상세 설명");
        itemDto.setItemNm("테스트 상품1");
        itemDto.setPrice(10000);
        itemDto.setRegTime(LocalDateTime.now());

        mv.addObject("itemDto", itemDto);

        return mv;
    }

    @GetMapping(value="ex03")
    public ModelAndView thEx03() throws Exception {
        ModelAndView mv = new ModelAndView("thEx/thEx03");

        List<ItemDto> itemDtoList = new ArrayList<ItemDto>();

        for (int i = 1; i <= 10; i++) {
            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명" + i);
            itemDto.setItemNm("테스트 상품" + i);
            itemDto.setPrice(1000 * i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }

        mv.addObject("itemDtoList", itemDtoList);

        return mv;
    }

    @RequestMapping(value="ex04")
    public ModelAndView thEx04() throws Exception {
        ModelAndView mv = new ModelAndView("thEx/thEx04");

        List<ItemDto> itemDtoList = thService.createDataList();

        mv.addObject("itemDtoList", itemDtoList);

        return mv;
    }

    @GetMapping("ex05")
    public String thEx05() {
        return "thEx/thEx05";
    }

    @GetMapping("ex06")
    public String thEx06(String param1, String param2, Model model) throws Exception {
        model.addAttribute("param1", param1);
        model.addAttribute("param2", param2);
        return "thEx/thEx06";
    }

    @GetMapping("ex06-1")
    public ModelAndView thEx061(@RequestParam("param1") String str1, @RequestParam("param2") String str2) throws Exception {
        ModelAndView mv = new ModelAndView("thEx/thEx06");
        mv.addObject("param1", str1);
        mv.addObject("param2", str2);
        return mv;
    }

    @GetMapping("ex07")
    public String thEx07() {
        return "thEx/thEx07";
    }

    @GetMapping("ex07-1")
    public String thEx071() {
        return "thEx/thEx07-1";
    }

    @RequestMapping("ex08")
    public ModelAndView thEx08() throws Exception {
        ModelAndView mv = new ModelAndView("thEx/thEx08");

        ItemDto data = thService.createData();
        System.out.println(data);
        List<ItemDto> dataList = thService.createDataList();
        System.out.println(dataList);

        Map<String, String> map = new HashMap<>();
        map.put("map1", "map 방식 데이터");
        map.put("map2", "map 방식 데이터 2");

        mv.addObject("valString", "문자열 변수");
        mv.addObject("valInt", 100);
        mv.addObject("data", data);
        mv.addObject("dataList", dataList);
        mv.addObject("map", map);

        return mv;
    }
}
