package com.fengf.bms.mapper;

import com.fengf.bms.pojo.UserQueryVo;
import com.fengf.bms.pojo.Users;
import com.fengf.bms.pojo.UsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersMapper {
    int countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

	Users selectByusername(String userName);

	void addUserArticleCount(Integer userId);

    List<Users> selectAllUserList();

    int userCountByQueryVo(UserQueryVo vo);

    List<Users> selectUserListByQueryVo(UserQueryVo vo);
}