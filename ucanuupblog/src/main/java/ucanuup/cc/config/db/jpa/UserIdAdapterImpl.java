package ucanuup.cc.config.db.jpa;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserIdAdapterImpl implements UserIdAdapter {

	@Override
	public Optional<String> getUserId() {
		
		return Optional.of("hello");
	}

}
