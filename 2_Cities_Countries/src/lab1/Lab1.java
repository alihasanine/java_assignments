/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.List;

/**
 *
 * @author AsmaaAbdelkader
 */
public class Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 1.  reads two files for cities and countries and store each in a List
        List<City> cities = new CSVDAO<City>("cities (1).csv" , City::new).getData();
        List<Country> countries = new CSVDAO<Country>("countries.csv" , Country::new).getData();
        
        /* 1. Create a map that uses the country code as keys and a list of cities as 
        the value for each country. 
•          2. For a given country code sort the cities according to the population*/
        var countryCity = new CountryCityMap(countries, cities).getCountryCityMap();   
       // countryCity.forEach((k,v)-> System.out.println("key: "+k+" value: "+v));
        
       
        var mapper = new CountryCityMap(countries, cities);
        mapper.getHigestPopulationInEachCountry().forEach((k, v) ->
                                                System.out.println("key=" + k + ", value=" + v));

      
       
    }
    
}
