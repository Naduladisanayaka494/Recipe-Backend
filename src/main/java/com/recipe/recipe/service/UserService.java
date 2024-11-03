package com.recipe.recipe.service;



import com.recipe.recipe.entity.Recipe;
import com.recipe.recipe.entity.User;
import com.recipe.recipe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public void addFavoriteRecipe(User user, Recipe recipe) {
        user.getFavorites().add(recipe);
        userRepository.save(user);
    }
}
