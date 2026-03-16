package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workingtech/animal")
public class AnimalController {
    @Value("${course.name}")
    private String courseName;
    @Value("${project.developer.fullname}")
    private String developerName;

    private Map<Integer, Animal> animals =new HashMap<>();

    //GET- Tüm hayvanlar
    @GetMapping
    public List<Animal> getAnimals(){
        return new ArrayList<>(animals.values());
    }

    //Get - id ile hayvan
    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable int id) {
        return animals.get(id);
    }

    //Post - yeni hayvan ekleme
    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal){
        animals.put(animal.getId(), animal);
        return animal;
    }

    // PUT - hayvan güncelleme
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal animal) {
        animals.put(id, animal);
        return animal;
    }

    // delete -hayvan silme

    @DeleteMapping("/{id}")
    public Animal deleteAnimal(@PathVariable int id) {
        return animals.remove(id);
    }

}
