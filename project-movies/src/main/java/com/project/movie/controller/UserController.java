package com.project.movie.controller;

import com.project.movie.document.User;
import com.project.movie.payload.response.MessageResponse;
import com.project.movie.service.user.UserServiceImp;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Log4j2
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;

    @GetMapping(value = "/users",produces = "application/json")
    public ResponseEntity<List<User>> findAllUser(){
        log.info("findAllUser info");
        List<User> listUser = userServiceImp.findAll();
        return  listUser!= null ? new ResponseEntity<>(listUser, HttpStatus.OK):
                new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/user/{id}",produces = "application/json")
    public ResponseEntity<User> findUserById(@PathVariable("id")String id){
        log.info("findUserById info");
        User user = userServiceImp.findUserById(id);
        return  user!= null ? new ResponseEntity<>(user, HttpStatus.OK):
                new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/user",produces = "application/json")
    public ResponseEntity<?> insertUser(@RequestBody @Validated User user){
        log.info("insertUser information");
        if (userServiceImp.existsUserByUserName(user.getUserName())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userServiceImp.existsUserByEmail(user.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }
        return this.userServiceImp.insertUser(user) ? new ResponseEntity<>(true, HttpStatus.CREATED) :
                new ResponseEntity<>(false,HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "/user",produces = "application/json")
    public ResponseEntity<Boolean> updateUser(@RequestBody @Validated User user){
        log.info("updateUser information");
        return this.userServiceImp.updateUser(user) ? new ResponseEntity<>(true, HttpStatus.ACCEPTED) :
                new ResponseEntity<>(false,HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/user/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUser(@PathVariable(value = "id") String id){
        log.info("deltUser infor");
        this.userServiceImp.delUser(id);
    }
}
