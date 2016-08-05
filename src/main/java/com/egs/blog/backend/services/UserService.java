/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egs.blog.backend.services;

import com.egs.blog.backend.entities.User;
import java.util.List;

/**
 *
 * @author eduardm
 */
public interface UserService {

    public List<User> getUserList(Integer start, Integer max);

    public Long saveUser(User user);

    public boolean deleteUser(Long id);

    public boolean updateUser(User user);

    public User getUserById(Long id);

    public User loadUser(Long id);

    public User getUser(Long id);

    public User getUserByEmail(String email);

    public User userLogin(String email, String password);

    public User userRegister(User user);
}
