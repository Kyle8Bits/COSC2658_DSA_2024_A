package Tai_solution_kdtree;

public class Application {
    public static void main(String[] args) {
        Map2D map = new Map2D(); // Assuming the TwoDimensionTree constructor accepts
        // a size parameter

        // Add some places with services to the map
        map.add(90, 10, "Coffee Shop", new String[] { "Coffee", "Tea", "Pastries" });
        map.add(15, 80, "Restaurant", new String[] { "Food", "Beverages", "Desserts" });
        map.add(5, 5, "Restaurant2", new String[] { "Food", "Beverages", "Desserts" });
        map.add(50, 70, "Restaurant1", new String[] { "Food", "Beverages", "Desserts" });
        map.add(70, 30, "Bookstore", new String[] { "Books", "Magazines", "Stationery" });
        map.add(85, 20, "Library", new String[] { "Books", "Study Rooms", "Free WiFi" });
        map.add(40, 60, "Bakery", new String[] { "Bread", "Coffee", "Pastries" });
        map.add(95, 5, "Pharmacy", new String[] { "Medicine", "Vitamins", "Health Supplements" });
        map.add(10, 40, "Supermarket", new String[] { "Groceries", "Household Items", "Beverages" });
        map.add(60, 10, "Florist", new String[] { "Flowers", "Plants", "Gifts" });
        System.out.println(map.tree.isBalanced());

        // int walking = 100;
        // String findService = "cc";
        // PlaceList foundPlaces = map.searchPlaces(10, 20, walking, findService);

        // if (foundPlaces.isEmpty()) {
        // System.out.println("No places found within the walking distance that offer
        // the service.");
        // } else {
        // // Display the results
        // System.out.println("There are " + foundPlaces.getSize() + " offering " +
        // findService + " within " + walking
        // + " meter");
        // System.out.println(foundPlaces.toString());
        // }
    }
}
