package com.bitc.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/outer")
public class OuterController {

  @RequestMapping("/image")
  public ModelAndView outerFolder() throws Exception {
    ModelAndView mv = new ModelAndView("outer/folder");

    mv.addObject("img", "images/20220520/521228446650800.jpg");

    return mv;
  }
}
