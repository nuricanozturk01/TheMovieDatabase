package nuricanozturk.dev.user.repository;

import nuricanozturk.dev.user.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface IUserRepository extends MongoRepository<User, UUID>
{
    Optional<User> findByUuid(UUID uuid);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);


}
