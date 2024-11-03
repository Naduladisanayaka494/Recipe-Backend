package com.recipe.recipe.service.Auth;


import com.recipe.recipe.dto.UserDto;
import com.recipe.recipe.entity.SignUpRequest;


import com.recipe.recipe.entity.User;
import com.recipe.recipe.enums.UserRole;
import com.recipe.recipe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;

    @Override
    public UserDto createdCustomer(SignUpRequest signuprequest) {
        User user = new User();
        user.setName(signuprequest.getName());
        user.setEmail(signuprequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signuprequest.getPassword()));
        user.setUserRole(UserRole.ADMIN);
        User createduser  =userRepository.save(user);
        UserDto userdto = new UserDto();
        userdto.setId(createduser.getId());
        return userdto;
    }

    @Override
    public boolean hascustomerwithemail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}


