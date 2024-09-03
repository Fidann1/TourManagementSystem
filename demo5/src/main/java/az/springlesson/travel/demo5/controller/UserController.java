package az.springlesson.travel.demo5.controller;

import az.springlesson.travel.demo5.dto.TourRequest;
import az.springlesson.travel.demo5.dto.UserRequest;
import az.springlesson.travel.demo5.entities.UserEntity;
import az.springlesson.travel.demo5.services.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("save")
    public void save(@RequestBody UserRequest user) {
        userService.createUser(user);
    }

    @GetMapping("id/{id}")
    public UserEntity getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }


    @GetMapping("list")
    public List<UserEntity> getUsers() {
        return userService.getAllUsers();
    }


    @PostMapping("createTrip/{id}")
    public void createTrip(@PathVariable Integer id, @RequestBody TourRequest tourRequest) {
        userService.createTrip(id,tourRequest);
    }
}
