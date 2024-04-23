package Tai_solution_kdtree;

public class Application {
    public static void main(String[] args) {
        Map2D map = new Map2D(); // Assuming the TwoDimensionTree constructor accepts a size parameter

        // Add some places with services to the map
        map.add(100, 200, "Coffee Shop", new String[] { "Coffee", "Tea", "Pastries" });
        map.add(300, 400, "Bookstore", new String[] { "Books", "Magazines", "Stationery" });
        map.add(500, 600, "Restaurant", new String[] { "Food", "Beverages", "Desserts" });
        map.add(100, 200, "Tea House", new String[] { "Tea", "Cookies" });

    }
}
