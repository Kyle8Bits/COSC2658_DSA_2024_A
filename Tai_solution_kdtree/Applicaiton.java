package Tai_solution_kdtree;

public class Applicaiton {
    public static void main(String[] args) {
        // Initialize the KDTree
        TwoDimensionTree kdTree = new TwoDimensionTree();

        // Test data
        Place[] places = new Place[] {
                new Place(30, 40, "Place1", new ServiceList()),
                new Place(5, 25, "Place2", new ServiceList()),
                new Place(70, 70, "Place3", new ServiceList()),
                new Place(10, 12, "Place4", new ServiceList()),
                new Place(50, 30, "Place5", new ServiceList()),
                new Place(35, 45, "Place6", new ServiceList()), // Same coordinates as Place1 to test duplicate handling
                new Place(80, 90, "Place7", new ServiceList()) // Same coordinates as Place1 to test duplicate handling

        };

        // Insert elements into the KDTree and print results
        for (Place place : places) {
            kdTree.add(place);
        }
        kdTree.printBreadthFirst();

        // Verify structure and properties of the KDTree
        // This would normally involve a more complex function that checks the integrity
        // of the tree.
        // For simplicity, here we are just printing the sizes and root information.
        System.out.println("Total nodes in KDTree: " + kdTree.size());
        if (kdTree.root != null) {
            System.out.println("Root of KDTree: " + kdTree.root.data);
        }
    }
}
