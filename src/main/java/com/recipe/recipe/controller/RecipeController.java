package com.recipe.recipe.controller;


import com.recipe.recipe.dto.RecipeResponse;
import com.recipe.recipe.entity.Recipe;
import com.recipe.recipe.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/search")
    public ResponseEntity<List<Recipe>> searchRecipes(@RequestParam String query) {
        List<Recipe> recipes = recipeService.searchRecipes(query);
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeResponse> getRecipeDetails(@PathVariable Long id) {
        RecipeResponse recipe = recipeService.getRecipeDetails(id);
        return ResponseEntity.ok(recipe);
    }
}
