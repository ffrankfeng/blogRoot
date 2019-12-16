package com.fengf.bms.service;

import com.fengf.bms.mapper.AdminMapper;
import com.fengf.bms.pojo.Admin;
import com.fengf.bms.pojo.AdminQueryVo;
import com.fengf.bms.pojo.Users;
import com.fengf.common.utils.Page;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements  AdminService {

    @Autowired
    private AdminMapper adminMapper;
    public String getupDate() throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=sdf.format(new Date());
        return date;
    }

    @Override
    public Admin login(String userName, String userPwd, String ip) {
        Admin admin = new Admin();
        admin.setUsername(userName);
        admin.setPassword(userPwd);
        Admin admin1 = adminMapper.login(admin);
        System.out.println("login sucess? "+admin1);
        if (admin1 != null){
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName,userPwd);
            try {
                subject.login(token);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("token 登录失败");
                return null;
            }
            System.out.println("token 登录成功");
            admin.setIp(ip);
            admin.setUserid(admin1.getUserid());
            admin.setAuthority(admin1.getAuthority());
            admin.setPhone(admin1.getPhone());
            try {
                admin.setLasttime(getupDate());

            } catch (ParseException e) {
                e.printStackTrace();
            }finally {
                int flag = adminMapper.updateByPrimaryKey(admin);
                return admin1;
            }
        }else return admin1 ;
    }

    @Override
    public Page<Admin> selectAllPage(AdminQueryVo vo) {
        Page<Admin> page=new Page<Admin>();
        //每页数
        page.setSize(10);
        vo.setSize(10);

        if(vo!=null ){
            //判断当前页
            if(vo.getPage()!=null){
                page.setPage(vo.getPage());
                vo.setStartRow((vo.getPage()-1)*vo.getSize());
            }
            //总条数
            page.setTotal(adminMapper.adminCountByQueryVo(vo));
            page.setRows(adminMapper.selectAdminListByQueryVo(vo));
        }
        return page;
    }

    @Override
    public Admin getAdminByUsername(String username) {
        AdminQueryVo adminQueryVo = new AdminQueryVo();
        adminQueryVo.setUsername(username);
        List<Admin> admins = adminMapper.selectAdminListByQueryVo(adminQueryVo);
        if (admins != null)
            return admins.get(0);
        else return null;
    }

    @Override
    public int getIndexAdminCount() {
        List<Admin> lists = adminMapper.selectAllUser();
//        System.out.println(lists.toArray());
        return lists.size();
    }
}
