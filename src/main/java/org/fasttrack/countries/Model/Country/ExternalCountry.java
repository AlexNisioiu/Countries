package org.fasttrack.countries.Model.Country;

public record ExternalCountry(ExternalCountryName name, String startOfWeek) {
}
record ExternalCountryName(String common){

}
