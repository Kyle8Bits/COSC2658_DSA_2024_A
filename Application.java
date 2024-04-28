
public class Application {
    public static void main(String[] args) {
        Map2D map = new Map2D(); // Assuming the TwoDimensionTree constructor accepts
        // a size parameter
        Place[] places = {
                new Place(90, 10, "Coffee Shop", new String[] { "Coffee", "Tea", "Pastries", "test" }),
                new Place(15, 80, "Restaurant", new String[] { "Food", "Beverages", "Desserts", "test" }),
                new Place(5, 5, "Restaurant2", new String[] { "Food", "Beverages", "Desserts", "test" }),
                new Place(50, 70, "Restaurant1", new String[] { "Food", "Beverages", "Desserts", "test" }),
                new Place(70, 30, "Bookstore", new String[] { "Books", "Magazines", "Stationery", "test" }),
                new Place(85, 20, "Library", new String[] { "Books", "Study Rooms", "Free WiFi", "test" }),
                new Place(40, 60, "Bakery", new String[] { "Bread", "Coffee", "Pastries", "test" }),
                new Place(95, 5, "Pharmacy", new String[] { "Medicine", "Vitamins", "Health Supplements", "test" }),
                new Place(10, 40, "Supermarket", new String[] { "Groceries", "Household Items", "Beverages", "test" }),
                new Place(60, 10, "Florist", new String[] { "Flowers", "Plants", "Gifts", "test" }),
                new Place(30, 45, "Gym", new String[] { "Fitness", "Yoga", "Health", "test" }),
                new Place(20, 75, "Salon", new String[] { "Haircuts", "Nails", "Spa", "test" }),
                new Place(65, 25, "Pet Shop", new String[] { "Pet Food", "Accessories", "Toys", "test" }),
                new Place(35, 55, "Electronics Store", new String[] { "Gadgets", "Phones", "Laptops", "test" }),
                new Place(45, 35, "Clothing Store",
                        new String[] { "Men's Wear", "Women's Wear", "Children's Wear", "test" }),
                new Place(75, 85, "Car Wash", new String[] { "Washing", "Detailing", "Polishing", "test" }),
                new Place(85, 65, "Music Store", new String[] { "Instruments", "Records", "Accessories", "test" }),
                new Place(25, 15, "Jewelry Store", new String[] { "Rings", "Necklaces", "Watches", "test" }),
                new Place(55, 5, "Toy Store", new String[] { "Toys", "Games", "Puzzles", "test" }),
                new Place(95, 95, "Art Gallery", new String[] { "Paintings", "Sculptures", "Exhibits", "test" }),
                new Place(95, 95, "Art Gallery", new String[] { "Paintings", "Sculptures", "Exhibits", "test" }),
                new Place(11, 21, "Hardware Store", new String[] { "Tools", "Building Supplies", "test" }),
                new Place(22, 32, "Video Game Shop", new String[] { "Video Games", "Consoles", "Accessories", "test" }),
                new Place(33, 43, "Vet Clinic", new String[] { "Pet Care", "Vaccinations", "test" }),
                new Place(44, 54, "Dentist", new String[] { "Dental Care", "Orthodontics", "test" }),
                new Place(55, 65, "Real Estate Agency", new String[] { "Property Sales", "Rentals", "test" }),
                new Place(66, 76, "Law Firm", new String[] { "Legal Services", "Consultations", "test" }),
                new Place(77, 87, "Marketing Agency", new String[] { "Advertising", "Brand Management", "test" }),
                new Place(88, 98, "Printing Service", new String[] { "Prints", "Posters", "Business Cards", "test" }),
                new Place(99, 9, "Travel Agency", new String[] { "Tour Packages", "Flight Bookings", "test" }),
                // Repeating pattern with different services and slightly changed coordinates
                // for diversity
                new Place(12, 34, "Coffee Shop", new String[] { "Espresso", "Latte", "test" }),
                new Place(23, 45, "Optician", new String[] { "Eyewear", "Eye Tests", "test" }),
                new Place(34, 56, "Theater", new String[] { "Movies", "Live Performances", "test" }),
                new Place(45, 67, "Bowling Alley", new String[] { "Bowling", "Arcade Games", "test" }),
                new Place(56, 78, "Golf Course", new String[] { "Golfing", "Clubhouse", "test" }),
                new Place(67, 89, "Amusement Park", new String[] { "Rides", "Games", "test" }),
                new Place(78, 90, "Museum", new String[] { "Exhibits", "Tours", "test" }),
                new Place(89, 12, "Aquarium", new String[] { "Marine Life", "Educational Tours", "test" }),
                new Place(91, 23, "Zoo", new String[] { "Animals", "Conservation", "test" }),
                new Place(13, 24, "Garden Center", new String[] { "Plants", "Gardening Supplies", "test" }),
                // Additional places to reach 100
                new Place(14, 25, "Skate Park", new String[] { "Skating", "Events", "test" }),
                new Place(15, 26, "Computer Repair Shop", new String[] { "Repairs", "Tech Support", "test" }),
                new Place(16, 27, "Bike Shop", new String[] { "Bicycles", "Repair Services", "test" }),
                new Place(17, 28, "Pet Store", new String[] { "Pet Food", "Toys", "test" }),
                new Place(18, 29, "Bookstore", new String[] { "Novels", "Educational Books", "test" }),
                new Place(19, 30, "Toy Store", new String[] { "Toys", "Educational Games", "test" }),
                new Place(20, 31, "Clothing Store", new String[] { "Apparel", "Footwear", "test" }),
                new Place(21, 32, "Jewelry Store", new String[] { "Diamonds", "Gold", "test" }),
                new Place(22, 33, "Florist", new String[] { "Bouquets", "Wedding Flowers", "test" }),
                new Place(23, 34, "Furniture Store", new String[] { "Sofas", "Beds", "test" }),
                new Place(24, 35, "Butcher Shop", new String[] { "Meat", "Poultry", "test" }),
                new Place(25, 36, "Fish Market", new String[] { "Fresh Fish", "Seafood", "test" }),
                new Place(26, 37, "Candy Store", new String[] { "Chocolates", "Sweets", "test" }),
                new Place(27, 38, "Bakery", new String[] { "Breads", "Cakes", "test" }),
                new Place(28, 39, "Ice Cream Shop", new String[] { "Ice Cream", "Frozen Yogurt", "test" }),
        };

        map.add(places);
        System.out.println(map.tree.isBalanced());

        int location_x = 75;
        int location_y = 15;
        int half_width = 100;
        int half_height = 100;
        String service = "Free WiFi";

        PlaceList foundPlaces = map.searchPlaces(location_x, location_y, half_width, half_height, service);

        // Output the results
        if (foundPlaces.isEmpty()) {
            System.out.println("No places found within the specified area that offer the service: " + service);
        } else {
            System.out
                    .println("Found " + foundPlaces.getSize() + " places offering '" + service + "' within the area.");
            System.out.println(foundPlaces.toString(location_x, location_y));
        }

    }
}