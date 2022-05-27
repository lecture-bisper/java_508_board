package com.bitc.board.interceptor;

import com.bitc.board.dto.UserDto;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheck implements HandlerInterceptor {

//  HandlerInterceptorAdapter 클래스를 사용하여 구현하는 것을 스프링 5에서 HandlerInterceptor 인터페이스로 변경됨
//  preHandle() : 지정한 컨트롤러가 동작되지 직전에 먼저 수행됨
//  postHandle() : 지정한 컨터르롤가 동작 후 view가 동작하기 직전에 수행됨
//  afterCompletion() : 모든 동작이 완료된 후 수행됨
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    HttpSession session = request.getSession();

    System.out.println("===== interceptor =====");
    System.out.println("세션에 저장된 내용 : " + (String)session.getAttribute("userId"));


    UserDto userDto = new UserDto();
    userDto.setUserId((String) session.getAttribute("userId"));

    if (userDto.getUserId() == null) {
      System.out.println("===== interceptor =====");
      System.out.println("현재 상태 : 비로그인 상태");
      System.out.println("세션 정보 : " + (String) session.getAttribute("userId"));

      response.sendRedirect("/login/loginFail");

      return false;
    }
    else {
      System.out.println("===== interceptor =====");
      System.out.println("현재 상태 : 로그인 상태");
      System.out.println("세션 정보 : " + (String) session.getAttribute("userId"));
      session.setMaxInactiveInterval(300);

      return true;
    }
  }
}
