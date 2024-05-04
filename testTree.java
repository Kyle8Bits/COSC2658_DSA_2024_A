public class testTree {
    public static void main(String[] args) {
        TwoDimensionTree tree = new TwoDimensionTree();
        
        Place[] places = {
            new Place(90, 10, "Coffee Shop", new String[] { "Coffee", "Tea", "Pastries", "test" }),
            new Place(15, 80, "Restaurant", new String[] { "Food", "Beverages", "Desserts", "test" }),
            new Place(5, 5, "Restaurant2", new String[] { "Food", "Beverages", "Desserts", "test" }),
            new Place(50, 70, "Restaurant1", new String[] { "Food", "Beverages", "Desserts", "test" }),
            new Place(30, 60, "Bookstore", new String[] { "Books", "Magazines", "Stationery", "test" }),
        };

        tree.build(places);
        System.out.println(

            tree.isBalanced()

        );
        tree.printBreadthFirst();
    }
}
