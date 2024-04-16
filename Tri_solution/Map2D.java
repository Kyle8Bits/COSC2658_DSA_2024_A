package Tri_solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Map2D {
    private Map<String, Set<Place>> serviceIndex;
    private Map<Integer, Map<Integer, Place>> places;

    public Map2D() {
        this.serviceIndex = new HashMap<>();
        this.places = new HashMap<>();
    }

    public void addPlace(int x, int y, Set<String> services) {
        Place newPlace = new Place(x, y, services);
        places.putIfAbsent(x, new HashMap<>());
        places.get(x).put(y, newPlace);

        for (String service : services) {
            serviceIndex.putIfAbsent(service, new HashSet<>());
            serviceIndex.get(service).add(newPlace);
        }
    }

    public void editPlace(int x, int y, Set<String> newServices) {
        if (!places.containsKey(x) || !places.get(x).containsKey(y)) {
            return; // Place does not exist
        }
        Place place = places.get(x).get(y);
        Set<String> oldServices = place.getServices();

        // Remove from old service indices
        for (String service : oldServices) {
            if (serviceIndex.containsKey(service)) {
                serviceIndex.get(service).remove(place);
            }
        }

        // Set new services and add to new service indices
        place.setServices(newServices);
        for (String service : newServices) {
            serviceIndex.putIfAbsent(service, new HashSet<>());
            serviceIndex.get(service).add(place);
        }
    }

    public void removePlace(int x, int y) {
        if (!places.containsKey(x) || !places.get(x).containsKey(y)) {
            return; // Place does not exist
        }
        Place place = places.get(x).get(y);

        // Remove place from serviceIndex
        for (String service : place.getServices()) {
            if (serviceIndex.containsKey(service)) {
                serviceIndex.get(service).remove(place);
            }
        }

        // Remove place from places
        places.get(x).remove(y);
        if (places.get(x).isEmpty()) {
            places.remove(x);
        }
    }

    public Set<Place> search(int topLeftX, int topLeftY, int width, int height, String serviceType) {
        Set<Place> result = new HashSet<>();
        int bottomRightX = topLeftX + width;
        int bottomRightY = topLeftY + height;

        if (!serviceIndex.containsKey(serviceType)) {
            return result; // No places with the given service type
        }

        for (Place place : serviceIndex.get(serviceType)) {
            if (place.getX() >= topLeftX && place.getX() <= bottomRightX &&
                place.getY() >= topLeftY && place.getY() <= bottomRightY) {
                result.add(place);
                if (result.size() == 50) { // Limit to 50 places
                    break;
                }
            }
        }
        return result;
    }
}

