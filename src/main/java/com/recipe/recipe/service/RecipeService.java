package com.recipe.recipe.service;



import com.example.recipefinder.dto.RecipeResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RecipeService {

    @Value("${spoonacular.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<RecipeResponse> searchRecipes(String query) {
        String url = "https://api.spoonacular.com/recipes/complexSearch?query=" + query + "&apiKey=" + apiKey;
        return restTemplate.getForObject(url, RecipeResponse.class).getResults();
    }

    public RecipeResponse getRecipeDetails(Long id) {
        String url = "https://api.spoonacular.com/recipes/" + id + "/information?apiKey=" + apiKey;
        return restTemplate.getForObject(url, RecipeResponse.class);
    }
}
