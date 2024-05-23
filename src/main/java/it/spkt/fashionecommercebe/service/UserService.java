package it.spkt.fashionecommercebe.service;

import it.spkt.fashionecommercebe.model.entity.user.User;

import java.util.Optional;

public interface UserService {
    public Optional<User> findByUsername(String username);
    public void save(User user);
}
