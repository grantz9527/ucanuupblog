package ucanuup.cc.config.db.jpa;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface UserIdAdapter {

	Optional<String> getUserId();
}
