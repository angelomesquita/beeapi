package net.atos.beerapi.controller;

import net.atos.beerapi.model.Beer;
import net.atos.beerapi.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beers")
public class BeerController {

    private final BeerService beerService;

    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping
    public List<Beer> getAllBeer() {
        return beerService.getAllBeers();
    }

    @GetMapping("/{id}")
    public Beer getBeerById(@PathVariable Long id) {
        return beerService.getBeerById(id);
    }

    @PostMapping
    public Beer saveBeer(@RequestBody Beer beer) {
        return beerService.saveBeer(beer);
    }

    @DeleteMapping("/{id}")
    public void deleteBeer(@PathVariable Long id) {
        beerService.deleteBeer(id);
    }
}
