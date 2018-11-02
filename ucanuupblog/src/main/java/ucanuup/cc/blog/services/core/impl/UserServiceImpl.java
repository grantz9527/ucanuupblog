package ucanuup.cc.blog.services.core.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucanuup.cc.blog.services.core.dao.UserDao;
import ucanuup.cc.blog.services.core.entity.User;
import ucanuup.cc.blog.services.core.inter.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User findOne(String id) {
		Optional<User> user = userDao.findById(id);
		return user.get();
	}

	@Override
	public User findLogin(User user) {
		
		return userDao.findUserByEmailOrAccountOrPhoneWithPassword(user.getUserAccount(),user.getEmail(),user.getPhone(),user.getUserPassword());
	}

	@Override
	public User save(User entity) {
		return userDao.save(entity);
	}

}
