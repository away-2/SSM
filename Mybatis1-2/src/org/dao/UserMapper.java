package org.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.model.User;
public interface UserMapper {
	public List<User>getAddressListByUserId(Integer id);
 public List<User>getUserListByRoleId(Integer id);
 
		
		
		// 查询用户列表(分页显示)
		 
		public List<User> getUserList(@Param("userName")String userName,
									  @Param("userRole")Integer roleId,
									  @Param("from")Integer currentPageNo,
									  @Param("pageSize")Integer pageSize);
		
 
}
