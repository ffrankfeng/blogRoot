package com.fengf.bms.service;

import com.fengf.bms.pojo.Admin;
import com.fengf.bms.pojo.UserQueryVo;
import com.fengf.bms.pojo.Users;
import com.fengf.common.utils.Page;

public interface UserService {


    Users userLogin(Users user);

    boolean userInsert(Users user);

    boolean checkUsername(String userName);

    String getJoinday(Users current_user);

    boolean personEdit(Users user);

    Page<Users> selectAllPage(UserQueryVo vo);

    boolean deleteUserByID(String single);
}
