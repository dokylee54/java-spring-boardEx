package com.springbook.biz.user.impl;

import com.springbook.biz.user.UserVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserVO> {

    public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {

        UserVO user = new UserVO();
        user.setId(rs.getString("ID"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setName(rs.getString("NAME"));
        user.setRole(rs.getString("ROLE"));

        return user;
    }




}
