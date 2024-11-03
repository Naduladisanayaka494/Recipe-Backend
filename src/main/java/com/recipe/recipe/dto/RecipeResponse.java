package com.recipe.recipe.dto;

import com.recipe.recipe.entity.Recipe;
import lombok.Data;

import java.util.List;
@Data
public class RecipeResponse {
    private List<Recipe> results;

    public List<Recipe> getResults() {
        return results;
    }

    public void setResults(List<Recipe> results) {
        this.results = results;
    }
}
