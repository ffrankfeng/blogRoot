package com.fengf.bms.mapper;

import com.fengf.bms.pojo.Admin;
import com.fengf.bms.pojo.AdminExample;
import java.util.List;

import com.fengf.bms.pojo.AdminQueryVo;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    int countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    Admin login(Admin admin);

    List<Admin> selectAllUser();

    int adminCountByQueryVo(AdminQueryVo vo);


    List<Admin> selectAdminListByQueryVo(AdminQueryVo vo);
}