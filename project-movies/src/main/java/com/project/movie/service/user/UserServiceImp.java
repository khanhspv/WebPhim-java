package com.project.movie.service.user;

import com.project.movie.dao.UserRepository;
import com.project.movie.document.User;
import com.project.movie.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean insertUser(User user) {
        return  userRepository.save(user) instanceof User? true : false;
    }

    @Override
    public boolean updateUser(User user) {
        User user1 =userRepository.findById(user.getId()).orElseThrow(() -> new ResourceNotFoundException());
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setBirthDay(user.getBirthDay());
        user1.setCreate_At(user.getCreate_At());
        user1.setModify_At(user.getModify_At());
        user1.setEmail(user.getEmail());
        user1.setMember(user.getMember());
        user1.setPhone(user.getPhone());
        user1.setUserName(user.getUserName());
        user1.setRole(user.getRole());
        user1.setSaved_video(user.getSaved_video());
        return userRepository.save(user1) instanceof User;
    }

    @Override
    public void delUser(String user) {
         User user1 =userRepository.findById(user).orElseThrow(ResourceNotFoundException::new);
         userRepository.deleteById(user1.getId());
    }

    @Override
    public User findUserById(String id) {
        return userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public boolean existsUserByUserName(String username) {
        return userRepository.existsUserByUserName(username);
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return userRepository.existsUserByEmail(email);
    }
}
