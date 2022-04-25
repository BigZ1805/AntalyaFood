package test.blueprint.controller;

import org.springframework.web.bind.annotation.*;
import test.blueprint.entity.Ingredient;
import test.blueprint.exceptions.IngredientNotFoundException;
import test.blueprint.repository.IngredientRepository;

import java.util.List;

@RestController
public class IngredientController {

    private final IngredientRepository ingredientRepository;

    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/ingredients")
    List<Ingredient> all() {
        return ingredientRepository.findAll();
    }

    @PostMapping("/ingredients")
    Ingredient newIngredient(@RequestBody Ingredient newIngredient) {
        return ingredientRepository.save(newIngredient);
    }

    @GetMapping("/ingredients/{id}")
    Ingredient one(@PathVariable Long id) {
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new IngredientNotFoundException(id));
    }

    @PostMapping("/ingredients/{id}")
    Ingredient replaceIngredient(@RequestBody Ingredient newIngredient, @PathVariable Long id) {
        return ingredientRepository.findById(id)
                .map( ingredient -> {
                    ingredient.setLabel(newIngredient.getLabel());
                    ingredient.setUnit(newIngredient.getUnit());
                    ingredient.setUsedQuantity(newIngredient.getUsedQuantity());
                    return ingredientRepository.save(ingredient);
                })
                .orElseGet(() -> {
                    newIngredient.setId(id);
                    return ingredientRepository.save(newIngredient);
                });
    }

    @DeleteMapping("/ingredients/{id}")
    void deleteIngredient(@PathVariable Long id) {
        ingredientRepository.deleteById(id);
    }

}
