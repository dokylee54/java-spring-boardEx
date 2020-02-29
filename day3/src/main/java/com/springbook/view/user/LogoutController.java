package com.springbook.view.user;

import com.springbook.view.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("로그아웃 처리");

        // 1. 브라우저와 연결된 세션 객체를 강제 종료한다.
        HttpSession session = request.getSession();
        session.invalidate();

        // 2. 세션 종료 후, 메인 화면으로 이동한다.
        return "login";
    }
}
