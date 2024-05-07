public class addFunctionTest {
    public static void main(String[] args) {
        Place[] places = new Place[] {
                new Place(15, 80, "Restaurant", new String[] { "Food", "Beverages", "Desserts", "test" }),
                new Place(20, 50, "Restaurant2", new String[] { "Food", "Beverages", "Desserts", "test" }),
                new Place(50, 70, "Restaurant1", new String[] { "Food", "Beverages", "Desserts", "test" }),
                new Place(70, 90, "Bookstore", new String[] { "Books", "Magazines", "Stationery", "test" }),
                new Place(85, 95, "Library", new String[] { "Books", "Study Rooms", "Free WiFi", "test" }),
        };

        Map2D map = new Map2D();
        map.add(places);
        // System.out.println(map.tree.isBalanced());
        System.out.println("Pre-order: ");
        map.tree.inOrder();
    }
}
