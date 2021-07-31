package lab1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import java.util.stream.Stream;
import lab1.City;
import lab1.Country;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AsmaaAbdelkader
 */
public class CountryCityMap {
    private List<Country> countries;
    private List<City> cities;

    public CountryCityMap(List<Country> countries, List<City> cities) {
        this.countries = countries;
        this.cities = cities;
        Collections.sort(cities , Collections.reverseOrder());
    }
    
    /**
     *
     * @return
     */
    public Map<String , List<City>> getCountryCityMap(){
        return cities.stream()
                     .collect(Collectors.groupingBy(City::getCountryCode));
//        var countryCity = new HashMap<String, List<City>>();
//        
//        for(var c : cities)
//        {
//             if(countryCity.getOrDefault(c.getCountryCode(), null) == null){
//                 var listOfCities = new ArrayList<City>();
//                 listOfCities.add(c);
//                 countryCity.put(c.getCountryCode(), listOfCities);
//             }
//                
//            else
//                countryCity.get(c.getCountryCode()).add(c);
//        }
//        
//       return countryCity;
        
    }
 
   
    
    public Map<String , City> getHigestPopulationInEachCountry(){
        Map<String , City> maxCities = new HashMap<>();
         cities.stream()
                .collect(groupingBy(City::getCountryCode , Collectors.maxBy(Comparator.comparing(City::getPopulation))) )
                .forEach((k,v)-> maxCities.put(k, v.orElse(null)));
         
         return maxCities;
    }
    
    public void getHighestPopulationByContinent(){
//       Map<String , Country> countryCodes = new HashMap<>();
//       
//       List<String> not = new ArrayList<>();
//       for(var country : countries)
//           countryCodes.put(country.getCountryCode(), country);
//       
//       for(var city : cities){
//           
//           //String cont = countryCodes.getOrDefault(city.getCountryCode(),)
//           //city.setContinent(cont);
//           try{
//                String cont = countryCodes.get(city.getCountryCode()).getContinent();
//           }catch(Exception e){
//               not.add(city.getCountryCode());
//           }
//           
//          
//       }
//        System.out.println(not.stream().distinct().count());
    
        System.out.println(cities.stream()
                                    .map(City::getCountryCode)
                                    .distinct().count());
        System.out.println(countries.stream()
                                    .map(Country::getCountryCode)
                                    .distinct().count());
    
    
    }
    
    
    
       
    /**
     *
     * @return
     */
    public City hightestPopulationCapital(){
        
           return  cities.stream()
                             .filter(c -> c.isCapital())
                              .sorted(Comparator.reverseOrder())
                                .findFirst()
                                .get();
                         
       }
    
    
       
        

        }
        
   
       
              
    
       
      
                    
    
    

