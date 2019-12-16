package com.fengf.bms.service;

import com.fengf.bms.pojo.Admin;
import com.fengf.bms.pojo.AdminQueryVo;
import com.fengf.common.utils.Page;

public interface AdminService {

    int getIndexAdminCount();
    Admin login(String userName, String userPwd, String ip);

    Page<Admin> selectAllPage(AdminQueryVo vo);

    Admin getAdminByUsername(String username);
}
