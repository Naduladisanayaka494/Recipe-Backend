package com.recipe.recipe.service;



import com.recipe.recipe.entity.Recipe;
import com.recipe.recipe.entity.User;
import com.recipe.recipe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public void addFavoriteRecipe(User user, Recipe recipe) {
        user.getFavorites().add(recipe);
        userRepository.save(user);
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }



    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("user not found"));
    }


}
