package ucanuup.cc.config.db.jpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;


/**
 * Description: TODO[描述该类概要功能介绍]
 *
 * @author guwenbin
 * @date 2017年11月24日
 * @version 1.0
 */
@Configuration
public class UserIDAuditorBean implements AuditorAware<String>{
	
	@Autowired
	private UserIdAdapter userIdAdapter;

	@Override
	public Optional<String> getCurrentAuditor() {
		
		return userIdAdapter.getUserId();
	}
}
