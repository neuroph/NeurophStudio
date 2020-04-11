package com.deepnetts.virsim;

import java.util.HashMap;
import java.util.Map;

class Region {
    private Region parentRegion; // zemlja, grad, opstina
    private String name; // naziv mesta
    private int population; // broj stanovnika u mestu
    private int area; // povrsina
    private Map<String, Region> subRegions = new HashMap();

    public Region(String name, int population) {
        this.name = name;
        this.population = population;
        this.parentRegion = null;
    }

    public Region(Region parentRegion, String name, int population, int area) {
        this.parentRegion = parentRegion;
        this.name = name;
        this.population = population;
        this.area = area;
    }
    
    public Region addSubRegion(String name, int population, int area) {
        Region newRegion = new Region(this, name, population, area);
        subRegions.put(name, newRegion);
        return this;
    }    

    public Region getParentLocation() {
        return parentRegion;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public Map<String, Region> getLocations() {
        return subRegions;
    }
    
    
    
}
