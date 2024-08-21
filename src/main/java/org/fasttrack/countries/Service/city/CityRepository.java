package org.fasttrack.countries.Service.city;

import org.fasttrack.countries.Model.City.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
interface CityRepository extends CrudRepository<City, Long> {
    List<City> findByCountryId(Long id);

}
