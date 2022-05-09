package vn.aptech.demo_jwt.service.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.aptech.demo_jwt.entity.User;
import vn.aptech.demo_jwt.repository.UserRepository;
import vn.aptech.demo_jwt.service.UserService;

/**
 *
 * @author Thanh Sang
 */
@Service
public class UserServiceImpl implements UserService ,UserDetailsService{

    @Autowired
    private UserRepository repo;
    
    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return repo.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return repo.existsByEmail(email);
    }

    @Override
    public User save(User user) {
        return repo.save(user);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User not found with username: " +username));
        return UserDetailsImpl.build(user);
    }
    
}
