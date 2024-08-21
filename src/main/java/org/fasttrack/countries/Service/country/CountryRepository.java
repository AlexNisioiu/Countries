package org.fasttrack.countries.Service.country;

import org.fasttrack.countries.Model.Country.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
 interface CountryRepository extends CrudRepository<Country, Long> {

    List<Country> findByContinentContains(String continent);

    @Query(value = "select c from Country c where continent=?1")
    List<Country> findByContinentJPQL(String continent);

    @Query(value = "select * from country where country_continent = ?1 ", nativeQuery = true)
    List<Country> findByContinentNative(String continent);

}
