package com.example.hw17.Controller;

import com.example.hw17.ApiResponse.ApiResponse;
import com.example.hw17.Model.User;
import com.example.hw17.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    public ResponseEntity getAllUsers(){
        List<User> userList = userService.getAllUsers();
        return ResponseEntity.status(200).body(userList);
    }

    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){

        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (userService.updateUser(id, user)) {
            return ResponseEntity.status(200).body(new ApiResponse("updated"));

        } else {
            return ResponseEntity.status(400).body(new ApiResponse("not updated"));
        }
    }

    public ResponseEntity deleteUser(@PathVariable Integer id){

        if(userService.deleteUser(id)){
            return ResponseEntity.status(200).body(new ApiResponse("deleted"));

        }else {
            return ResponseEntity.status(400).body(new ApiResponse("not deleted"));
        }

    }
}
