package com.recipe.recipe.service;




import com.recipe.recipe.dto.RecipeResponse;
import com.recipe.recipe.entity.Recipe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class RecipeService {
    private final String apiKey = "2b1c0b5b3a9e458cb3a0bfeed6fd6698";

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Recipe> searchRecipes(String query) {
        String url = "https://api.spoonacular.com/recipes/complexSearch?query=" + query + "&apiKey=" + apiKey;
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        return (List<Recipe>) response.getBody().get("results");
    }

    public RecipeResponse getRecipeDetails(Long id) {
        String url = "https://api.spoonacular.com/recipes/" + id + "/information?apiKey=" + apiKey;
        return restTemplate.getForObject(url, RecipeResponse.class);
    }
}
