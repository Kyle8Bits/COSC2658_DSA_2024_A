package Tri_solution_kdtree;

public class Application {
    public static void main(String[] args) {
        Map2D map = new Map2D(); // Assuming the TwoDimensionTree constructor accepts
        // a size parameter

        // Add some places with services to the map
        map.add(30, 40, "Coffee Shop", new String[] { "Coffee", "Tea", "Pastries" });
        map.add(5, 25, "Restaurant", new String[] { "Food", "Beverages","Desserts" });
        map.add(70, 70, "Restaurant2", new String[] { "Food", "Beverages","Desserts" });
        map.add(50, 30, "Restaurant1", new String[] { "Food", "Beverages","Desserts" });
        map.add(10, 12, "Bookstore", new String[] { "Books", "Magazines", "Stationery" });
        map.add(35, 45, "Tea House", new String[] { "Tea", "Cookies" });
       

        map.remove(30,40 );

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
