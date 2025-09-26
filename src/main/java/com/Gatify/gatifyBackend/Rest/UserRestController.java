package com.Gatify.gatifyBackend.Rest;

import com.Gatify.gatifyBackend.Entity.User;
import com.Gatify.gatifyBackend.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private final UserService userService;
    private final ObjectMapper objectMapper;

    @Autowired
    public UserRestController(UserService userService, ObjectMapper objectMapper) {
        this.userService = userService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable int userId) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new RuntimeException("User id not found - " + userId);
        }
        return user;
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        user.setId(0); // Force save of new item
        return userService.save(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PatchMapping("/{userId}")
    public User patchUser(@PathVariable int userId, @RequestBody Map<String, Object> patchPayload) {
        User tempUser = userService.findById(userId);
        if (tempUser == null) {
            throw new RuntimeException("User id not found - " + userId);
        }
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("User id not allowed in request body - " + userId);
        }
        User patchedUser = apply(patchPayload, tempUser);
        return userService.save(patchedUser);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId) {
        User tempUser = userService.findById(userId);
        if (tempUser == null) {
            throw new RuntimeException("User id not found - " + userId);
        }
        userService.deleteById(userId);
        return "Deleted user id - " + userId;
    }

    private User apply(Map<String, Object> patchPayload, User tempUser) {
        ObjectNode userNode = objectMapper.convertValue(tempUser, ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);
        userNode.setAll(patchNode);
        return objectMapper.convertValue(userNode, User.class);
    }
}