package org.fasttrack.countries;

import java.util.List;

public record ExternalCountry(ExternalCountryName name, String startOfWeek) {
}
record ExternalCountryName(String common){

}
