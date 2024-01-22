package net.atos.beerapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.atos.beerapi.model.Beer;
import net.atos.beerapi.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beers")
@Tag(name= "Beer API", description = "API para gerenciamento das cervejas que eu gosto!!!")
public class BeerController {

    private final BeerService beerService;

    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping(produces = "application/json")
    @Operation(
        summary = "Lista todas as cerveja",
        description = "Lista todas as cervejas cadastradas no sistema!"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "operação com sucesso | []")
    })
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
