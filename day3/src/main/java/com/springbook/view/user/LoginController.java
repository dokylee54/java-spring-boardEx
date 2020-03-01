package com.springbook.view.user;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

import com.springbook.biz.user.impl.UserDAOSpring;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String loginView(@ModelAttribute("user") UserVO vo) {
        System.out.println("로그인 화면으로 이동");

        vo.setId("admin");
        vo.setPassword("1234");
        return "login.jsp";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
        System.out.println("로그인 처리");

        UserVO user = userDAO.getUser(vo);
        if(user != null) {
            session.setAttribute("userName", user.getName());
            return "getBoardList.do";
        }
        else return "login.jsp";
    }
}
