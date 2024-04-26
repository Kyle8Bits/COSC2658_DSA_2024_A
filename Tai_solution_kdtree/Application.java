package Tai_solution_kdtree;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Map2D map = new Map2D(); // Assuming the TwoDimensionTree constructor accepts
        // a size parameter

        // Add some places with services to the map
        map.add(30, 40, "Coffee Shop", new String[] { "Coffee", "Tea", "Pastries" });
        map.add(5, 25, "Restaurant", new String[] { "Food", "Beverages", "Desserts" });
        map.add(70, 70, "Restaurant2", new String[] { "Food", "Beverages", "Desserts" });
        map.add(50, 30, "Restaurant1", new String[] { "Food", "Beverages", "Desserts" });
        map.add(10, 12, "Bookstore", new String[] { "Books", "Magazines", "Stationery" });
        map.add(25, 30, "Bookstore", new String[] { "Books", "Magazines", "Stationery" });
        // map.add(35, 45, "Tea House", new String[] { "Tea", "Cookies" });
        map.add(22, 45, "Bookstore", new String[] { "Books", "Magazines", "Stationery" });
        // map.add(35, 35, "Bookstore", new String[] { "Books", "Magazines",
        // "Stationery" });
        map.add(26, 35, "Bookstore", new String[] { "Books", "Magazines", "Stationery" });
        map.add(35, 80, "Bookstore", new String[] { "cc", "Books", "Magazines", "Stationery" });
        map.add(13, 14, "Bookstore", new String[] { "cc", "Books", "Magazines", "Stationery", "CCCCC" });
        map.add(11, 15, "Bookstore", new String[] { "cc", "Books", "Magazines", "Stationery", "CCCCC" });
        map.add(8, 20, "Bookstore", new String[] { "cc", "Books", "Magazines", "Stationery", "CCCCC" });



        List<PlaceNode> nearestPlaces = map.searchPlaces(10, 20, 7, "cc");

        if (nearestPlaces.isEmpty()) {
            System.out.println("No places found within the walking distance that offer the service.");
        } else {
            // Display the results
            System.out.println("Places offering tea within 450 meter");
            for (PlaceNode place : nearestPlaces) {
                System.out.println(place.data.toString());
            }
        }

    }

    // public static void main(String[] args) {
    // // Create the tree
    // TwoDimensionTree tree = new TwoDimensionTree();

    // // Add nodes to the tree
    // tree.add(new Place(50, 75, "Cafe", new ServiceList()));
    // tree.add(new Place(25, 40, "Library", new ServiceList()));
    // tree.add(new Place(70, 80, "Supermarket", new ServiceList()));
    // tree.add(new Place(10, 10, "Post Office", new ServiceList()));

    // // Search for a node
    // PlaceNode foundNode = tree.find(10, 10);

    // // Output results
    // if (foundNode != null) {
    // System.out.println("Node found: " + foundNode.data);
    // } else {
    // System.out.println("Node not found.");
    // }

    // // Try to find a node that does not exist
    // PlaceNode notFoundNode = tree.find(100, 100);

    // // Output results
    // if (notFoundNode != null) {
    // System.out.println("Node found: " + notFoundNode.data.toString());
    // } else {
    // System.out.println("Node not found.");
    // }
    // }
}
