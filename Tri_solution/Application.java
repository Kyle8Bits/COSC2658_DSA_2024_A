package Tri_solution;

public class Application {
    public static void main(String[] args) {
        // Create a new Map2D instance
        Map2D map = new Map2D();

        // Define some places to add
        Place place1 = new Place(100, 200, "RMIT University", new ServiceList());
        Place place2 = new Place(300, 400, "Melbourne Museum", new ServiceList());
        Place place3 = new Place(500, 600, "Federation Square", new ServiceList());

        // Add places to the map
        map.addPlace(place1);
        map.addPlace(place2);
        map.addPlace(place3);

        // Retrieve and print out the details of a place
        Place retrievedPlace1 = map.getPlace(place1);
        if (retrievedPlace1 != null) {
            System.out.println("Retrieved: " + retrievedPlace1.toString());
        } else {
            System.out.println("Place1 not found.");
        }

        // Attempt to retrieve a place that does not exist
        Place nonExistentPlace = new Place(999, 999, "Nowhere Land", new ServiceList());
        Place retrievedPlace2 = map.getPlace(nonExistentPlace);
        if (retrievedPlace2 != null) {
            System.out.println("Retrieved: " + retrievedPlace2.toString());
        } else {
            System.out.println("Non-existent place not found.");
        }

    }
}