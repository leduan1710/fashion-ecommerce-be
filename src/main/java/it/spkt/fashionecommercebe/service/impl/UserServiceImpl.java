package it.spkt.fashionecommercebe.service.impl;

import it.spkt.fashionecommercebe.model.entity.user.User;
import it.spkt.fashionecommercebe.repository.UserRepository;
import it.spkt.fashionecommercebe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
