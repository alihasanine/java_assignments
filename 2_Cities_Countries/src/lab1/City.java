/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author AsmaaAbdelkader
 */
public class City implements  FillData<City> , Comparable<City>{
    private String name;
    private String countryCode;
    private int population;
    private boolean Capital;
    private String continent;

   
    
    public City(){
        
    }

    public City(String name, String countryCode, int population, boolean isCapital) {
        this.name = name;
        this.countryCode = countryCode;
        this.population = population;
        this.Capital = isCapital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isCapital() {
        return Capital;
    }

    public void setCapital(boolean isCapital) {
        this.Capital = isCapital;
    }

    @Override
    public String toString() {
        return "City{" + "name=" + name + ", countryCode=" + countryCode + ", population=" + population + ", isCapital=" + Capital + '}';
    }

    @Override
    public City fill( String[] row) {
        this.name = row[1];
        this.countryCode = row[6];
        
        if(row[8].equalsIgnoreCase("primary"))
            this.Capital=  true;
        else
            this.Capital = false;
        try{
        this.population = Integer.parseInt(row[9]);
        }catch(Exception e){
            this.population=0;
            //System.out.println("null");
        }
        
        return this;
    }

    @Override
    public int compareTo(City o) {
        return Integer.valueOf(population).compareTo(o.population);
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
    
    

   
    
}
