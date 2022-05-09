package vn.aptech.demo_jwt.service;

import java.util.List;
import java.util.Optional;
import vn.aptech.demo_jwt.entity.User;


/**
 *
 * @author Thanh Sang
 */
public interface UserService {
    List<User> findAll();
    Optional<User> findById(int id);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    User save(User user);
    void deleteById(int id);
}
