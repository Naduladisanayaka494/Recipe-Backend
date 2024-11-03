package com.recipe.recipe.service.Auth;


import com.recipe.recipe.dto.UserDto;
import com.recipe.recipe.entity.SignUpRequest;

public interface AuthService {
    UserDto createdCustomer(SignUpRequest signuprequest);
    boolean hascustomerwithemail(String email);
}
