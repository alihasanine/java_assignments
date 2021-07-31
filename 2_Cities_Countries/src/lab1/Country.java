/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AsmaaAbdelkader
 */
public class Country implements FillData<Country>{
    private String countryCode;
    public String officialName;
    private String continent;
    private List cities ;

    public List getCities() {
        return cities;
    }

    public void setCities(List cities) {
        this.cities = cities;
    }

    public Country(String countryCode, String officialName, String continent) {
        this.countryCode = countryCode;
        this.officialName = officialName;
        this.continent = continent;
        cities = new ArrayList<City>();
    }

    public Country() {
        cities = new ArrayList<City>();
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "Country{" + "countryCode=" + countryCode + ", officialName=" + officialName + ", continent=" + continent + '}';
    }

    @Override
    public Country fill(String[] row) {
        this.countryCode = row[0];
        this.officialName = row[1];
        this.continent = row[2];
        
        return this;
    }
    
    
    
}
