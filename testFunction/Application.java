package testFunction;

public class Application {
    public static void main(String[] args) {
        Map2D map = new Map2D(); // Assuming the TwoDimensionTree constructor accepts
        // a size parameter
        Place[] places = {
                new Place(90, 10, "Coffee Shop", new String[] { "Coffee", "Tea", "Pastries", "test" }),
                new Place(15, 80, "Restaurant", new String[] { "Food", "Beverages", "Desserts", "test" }),
                new Place(5, 5, "Restaurant2", new String[] { "Food", "Beverages", "Desserts", "test" }),
                new Place(50, 70, "Restaurant1", new String[] { "Food", "Beverages", "Desserts", "test" }),
                new Place(70, 30, "Bookstore", new String[] { "Books", "Magazines", "Stationery", "test" }),
                new Place(85, 20, "Library", new String[] { "Books", "Study Rooms", "Free WiFi", "test" }),
                new Place(40, 60, "Bakery", new String[] { "Bread", "Coffee", "Pastries", "test" }),
                new Place(95, 5, "Pharmacy", new String[] { "Medicine", "Vitamins", "Health Supplements", "test" }),
                new Place(10, 40, "Supermarket", new String[] { "Groceries", "Household Items", "Beverages", "test" }),
                new Place(60, 10, "Florist", new String[] { "Flowers", "Plants", "Gifts", "test" })
        };

        map.add(places);
        System.out.println(map.tree.isBalanced());

        int location_x = 75;
        int location_y = 15;
        int half_width = 100;
        int half_height = 100;
        String service = "test";

        PlaceList foundPlaces = map.searchPlaces(location_x, location_y, half_width, half_height, service);

        // Output the results
        if (foundPlaces.isEmpty()) {
            System.out.println("No places found within the specified area that offer the service: " + service);
        } else {
            System.out
                    .println("Found " + foundPlaces.getSize() + " places offering '" + service + "' within the area.");
            System.out.println(foundPlaces.toString(location_x, location_y));
        }

    }
}
