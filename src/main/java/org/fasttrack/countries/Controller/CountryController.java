package org.fasttrack.countries.Controller;

import lombok.RequiredArgsConstructor;
import org.fasttrack.countries.Model.City.City;
import org.fasttrack.countries.Model.Country.Country;
import org.fasttrack.countries.Model.Exception.EntityNotFoundException;
import org.fasttrack.countries.Model.Country.ExternalCountry;
import org.fasttrack.countries.Service.country.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/countries")
public class CountryController {
    private final CountryService countryService;

    @GetMapping// GET http://host:port/countries?continent=Asia
    public List<Country> getAll(@RequestParam(required = false) String continent) {
        if (continent != null) {
            return countryService.getByContinent(continent);
        } else {
            return countryService.getAll();
        }
    }

    @GetMapping("/{id}") //GET http://host:port/countries/id
    public Country getById(@PathVariable long id) {
        return countryService.getById(id).orElseThrow(() -> new EntityNotFoundException("Can't find country", id));

    }

    @DeleteMapping("/{id}")
    public Country delete(@PathVariable long id) {
        return countryService.delete(id);
    }

    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        return countryService.add(country);
    }

    @PutMapping("/{id}")
    public Country update(@PathVariable long id, @RequestBody Country country) {
        if (id != country.getId()) {
            throw new RuntimeException();
        }
        return countryService.update(country);
    }

    @GetMapping("/{id}/external")
    public ExternalCountry getCountriesFromExternal(@PathVariable long id) {
        return countryService.getExternalDataById(id);

    }

    @PostMapping("/{id}/neighbours/{neighbourId}")
    Country addNeighbourToCountry(@PathVariable Long id, @PathVariable Long neighbourId) {
        return countryService.addNeighbourToCountry(id, neighbourId);
    }

    @PostMapping("/{id}/cities")
    City addCityToCountry(@PathVariable Long id, @RequestBody City city) {
        return countryService.addCityToCountry(id, city);
    }

    @GetMapping("/{id}/cities")
    List<City> getCitiesForCountry(@PathVariable Long id){
        return countryService.getCitiesForCountry(id);
    }


}
