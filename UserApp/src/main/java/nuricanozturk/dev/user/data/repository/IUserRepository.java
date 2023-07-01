package nuricanozturk.dev.user.data.repository;

import nuricanozturk.dev.user.data.entity.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface IUserRepository extends MongoRepository<User, String> {
}
