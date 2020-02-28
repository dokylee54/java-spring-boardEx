package com.springbook.biz.user.impl;

import com.springbook.biz.board.impl.BoardRowMapper;
import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository("userDAOSpring")
public class UserDAOSpring {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // SQL 명령어들
    private final String USER_GET = "select * from users where id=? and password=?";

    // CRUD 기능의 메소드 구현
    //회원 등록
    public UserVO getUser(UserVO vo) {
        System.out.println("===> JDBC로 getUser() 기능 처리");

        Object[] args = {vo.getId(), vo.getPassword()};

        return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
    }

}