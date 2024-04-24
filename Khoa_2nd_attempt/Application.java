package Khoa_2nd_attempt;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Map2D map = new Map2D(); // Assuming the TwoDimensionTree constructor accepts
        // a size parameter

        // Add some places with services to the map
        map.add(100, 200, "Coffee Shop", new String[] { "Coffee", "Tea", "Pastries" });
        map.add(300, 400, "Bookstore", new String[] { "Books", "Magazines", "Stationery" });
        map.add(350, 450, "FAHASA", new String[] { "Books", "Magazines", "Stationery" });
        map.add(500, 600, "Restaurant", new String[] { "Food", "Beverages", "Desserts" });
        map.add(100, 253, "Tea House", new String[] { "Tea", "Cookies" });
        map.add(100, 400, "Coffee House", new String[] { "Tea", "Coffee" });
        map.add(100, 500, "GongCha", new String[] { "Tea", "MilkTea" });

        List<PlaceNode> nearestPlaces = map.findNearsetPlace(100, 200,354 , "Books");

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
