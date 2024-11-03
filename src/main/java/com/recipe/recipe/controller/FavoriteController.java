package com.recipe.recipe.controller;




import com.recipe.recipe.entity.Recipe;
import com.recipe.recipe.entity.User;
import com.recipe.recipe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users/{userId}/favorites")
public class FavoriteController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> addFavorite(@PathVariable Long userId, @RequestBody Recipe recipe) {
        Optional<User> userOpt = userService.getUserById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            userService.addFavoriteRecipe(user, recipe);
            return ResponseEntity.ok("Recipe added to favorites");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    @GetMapping
    public ResponseEntity<?> getFavorites(@PathVariable Long userId) {
        Optional<User> userOpt = userService.getUserById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return ResponseEntity.ok(user.getFavorites());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
}

