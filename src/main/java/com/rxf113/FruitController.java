package com.rxf113;

import io.smallrye.mutiny.Uni;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/spring-fruit")
public class FruitController {

    FruitRepository fruitRepository;

    public FruitController(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @GetMapping
    public List<Fruit> fruits(@RequestParam("season") String season) {
        if (season != null) {
            return fruitRepository.findBySeason(season);
        }
        return Fruit.listAll();
    }

    @GetMapping(value = "/all")
    public Uni<List<Fruit>> fruits() {
        return fruitRepository.findFruitsBySeason();
    }

}