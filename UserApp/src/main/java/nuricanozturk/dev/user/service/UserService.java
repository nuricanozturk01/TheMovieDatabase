package nuricanozturk.dev.user.service;

import nuricanozturk.dev.user.data.entity.User;
import nuricanozturk.dev.user.data.repository.IUserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Lazy
public class UserService {
    private final IUserRepository m_repo;

    public UserService(IUserRepository mRepo) {
        m_repo = mRepo;
    }

    public List<User> findAlll() {
        return m_repo.findAll();
    }

    public User saveUser(User user)
    {
       return m_repo.save(user);
    }
}
