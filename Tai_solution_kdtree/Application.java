package Tai_solution_kdtree;

public class Application {
    public static void main(String[] args) {
        Map2D map = new Map2D(); // Assuming the TwoDimensionTree constructor accepts
        // a size parameter

        // Add some places with services to the map
        // map.add(30, 40, "Coffee Shop", new String[] { "Coffee", "Tea", "Pastries" });
        // map.add(5, 25, "Restaurant", new String[] { "Food", "Beverages", "Desserts"
        // });
        // map.add(70, 70, "Restaurant2", new String[] { "Food", "Beverages", "Desserts"
        // });
        // map.add(50, 30, "Restaurant1", new String[] { "Food", "Beverages", "Desserts"
        // });
        // map.add(10, 12, "Bookstore", new String[] { "Books", "Magazines",
        // "Stationery" });
        // map.add(25, 30, "Bookstore", new String[] { "Books", "Magazines",
        // "Stationery" });
        // // map.add(35, 45, "Tea House", new String[] { "Tea", "Cookies" });
        // map.add(22, 45, "Bookstore", new String[] { "Books", "Magazines",
        // "Stationery" });
        // // map.add(35, 35, "Bookstore", new String[] { "Books", "Magazines",
        // // "Stationery" });
        // map.add(26, 35, "Bookstore", new String[] { "Books", "Magazines",
        // "Stationery" });
        // map.add(35, 80, "Bookstore", new String[] { "cc", "Books", "Magazines",
        // "Stationery" });
        // map.add(13, 14, "Bookstore", new String[] { "cc", "Books", "Magazines",
        // "Stationery", "CCCCC" });
        map.add(40, 25, "Bookstore", new String[] { "cc", "Books", "Magazines", "Stationery" });
        map.add(26, 35, "Bookstore", new String[] { "cc", "Magazines", "Stationery" });
        map.add(35, 80, "Bookstore", new String[] { "cc", "Books", "Magazines", "Stationery" });
        map.add(30, 15, "Bookstore", new String[] { "cc", "Books", "Magazines", "Stationery" });
        map.add(30, 10, "Bookstore", new String[] { "cc", "Books", "Magazines", "Stationery" });
        map.add(21, 29, "Bookstore", new String[] { "cc", "Books", "Magazines", "Stationery" });

        int walking = 20;
        String findService = "cc";
        PlaceList foundPlaces = map.searchPlaces(40, 20, walking, findService);

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
