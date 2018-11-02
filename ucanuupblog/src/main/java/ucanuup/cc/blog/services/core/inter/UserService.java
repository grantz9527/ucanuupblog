package ucanuup.cc.blog.services.core.inter;

import org.springframework.stereotype.Service;

import ucanuup.cc.blog.services.core.entity.User;

@Service
public interface UserService {

	User findOne(String id);
	
	User findLogin(User user);
	
	User save(User entity);
}
