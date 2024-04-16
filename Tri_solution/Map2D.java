package Tri_solution;

import java.util.ArrayList;
import java.util.List;

public class Map2D {
    private List<Place> places;

    public Map2D() {
        places = new ArrayList<>();
    }

    public void add(Place place) {
        places.add(place);
    }
    
    public void edit(Place place, String newServices) {
        place.setServices(newServices);
    }
    
    public void remove(Place place) {
    }
    
    public List<Place> search(double topLeftX, double topLeftY, double width, double height, String service) {
        List<Place> rectangle = new ArrayList<>();
        for (Place place : places) {
            if (place.getServices().contains(service) &&
                place.getX() >= topLeftX && place.getX() <= topLeftX + width &&
                place.getY() >= topLeftY && place.getY() <= topLeftY + height) {
                rectangle.add(place);
            }
        }
        return rectangle.subList(0, Math.min(rectangle.size(), 50)); // Limit to 50 places
    }
}