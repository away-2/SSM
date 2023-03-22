package service.impl;

import service.UserService;
import dao.UserDao;
import entity.User;

/**
 * 用户业务类，实现对User的业务管理功能
 */
public class UserServiceImpl implements UserService {

	// 声明接口类型的引用，和具体实现类解耦合
	private UserDao dao;

	// dao 属性的setter访问器，会被Spring调用，实现设值注入
	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	public void addNewUser(User user) {
		// 调用用户DAO的方法保存用户信息
		int a =2/0;
		dao.save(user);
	}
}