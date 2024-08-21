package org.fasttrack.countries.Service.city;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.fasttrack.countries.Model.City.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

   public City save(City city){
       return cityRepository.save(city);

   }

   public List<City> findByCountryId(Long id){
       return cityRepository.findByCountryId(id);
   }

}
