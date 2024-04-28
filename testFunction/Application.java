package testFunction;

public class Application {
    public static void main(String[] args) {
        Map2D map = new Map2D(); // Assuming the TwoDimensionTree constructor accepts
        // a size parameter
        Place[] places = {
                new Place(90, 10, "Coffee Shop", new String[] { "Coffee", "Tea", "Pastries" }),
                new Place(15, 80, "Restaurant", new String[] { "Food", "Beverages", "Desserts" }),
                new Place(5, 5, "Restaurant2", new String[] { "Food", "Beverages", "Desserts" }),
                new Place(50, 70, "Restaurant1", new String[] { "Food", "Beverages", "Desserts" }),
                new Place(70, 30, "Bookstore", new String[] { "Books", "Magazines", "Stationery" }),
                new Place(85, 20, "Library", new String[] { "Books", "Study Rooms", "Free WiFi" }),
                new Place(40, 60, "Bakery", new String[] { "Bread", "Coffee", "Pastries" }),
                new Place(95, 5, "Pharmacy", new String[] { "Medicine", "Vitamins", "Health Supplements" }),
                new Place(10, 40, "Supermarket", new String[] { "Groceries", "Household Items", "Beverages" }),
                new Place(60, 10, "Florist", new String[] { "Flowers", "Plants", "Gifts" })
        };

        System.out.println(map.tree.isBalanced());
        map.add(places);
        map.tree.printBreadthFirst();

        // int walkingDistance = 100;
        // String serviceOfInterest = "Coffee";
        // PlaceList foundPlaces = map.searchPlaces(50, 50, walkingDistance, serviceOfInterest);

        // if (foundPlaces.isEmpty()) {
        //     System.out.println(
        //             "No places found within " + walkingDistance + " meters offering " + serviceOfInterest + ".");
        // } else {
        //     System.out
        //             .println("Found places offering " + serviceOfInterest + " within " + walkingDistance + " meters:");
        //     System.out.println(foundPlaces.toString());
        // }

    }
}
