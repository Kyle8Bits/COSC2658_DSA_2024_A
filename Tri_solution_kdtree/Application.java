package Tri_solution_kdtree;

public class Application {
    public static void main(String[] args) {
        Map2D map = new Map2D(); // Assuming the TwoDimensionTree constructor accepts
        // a size parameter

        // Add some places with services to the map
        map.add(100, 200, "Coffee Shop", new String[] { "Coffee", "Tea", "Pastries" });
        map.add(300, 400, "Bookstore", new String[] { "Books", "Magazines", "Stationery" });
        map.add(500, 600, "Restaurant", new String[] { "Food", "Beverages","Desserts" });
        map.add(100, 2503, "Tea House", new String[] { "Tea", "Cookies" });
        map.remove(500, 600);
        map.remove(100, 200);

        map.printBreadthFirst();

         
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
