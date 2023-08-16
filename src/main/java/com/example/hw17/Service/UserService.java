package com.example.hw17.Service;

import com.example.hw17.Model.User;
import com.example.hw17.Repository.UserRespository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRespository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public Boolean updateUser(Integer id, User user){

        User oldName = userRepository.getById(id);

        if(oldName == null) {
            return false;

        }
        oldName.setName(user.getName());
        userRepository.save(oldName);

        return true;
    }

    public Boolean deleteUser(Integer id){
        User user = userRepository.getById(id);
        if(user == null) {
            return false;

        }
        userRepository.delete(user);
        return true;
    }


}
