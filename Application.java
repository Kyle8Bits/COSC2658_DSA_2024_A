
public class Application {
    public static void main(String[] args) {
        Map2D map = new Map2D(); // Assuming the TwoDimensionTree constructor accepts
        // a size parameter
        // Place[] places = new Place[10000 * 10000];
        // for(int i = 0; i < 10000; i++){
        // for(int j = 0; j < 10000; j ++){
        // places[i] = new Place(i, j, "cc", new String[] {"cc"});
        // }
        // }
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
                new Place(282, 392, "Ice Cream Shop", new String[] { "Ice Cream", "Frozen Yogurt", "test" }),
                new Place(238, 339, "Ice Cream Shop", new String[] { "Ice Cream", "Frozen Yogurt", "test" }),
                new Place(238, 391, "Ice Cream Shop", new String[] { "Ice Cream", "Frozen Yogurt", "test" }),
                new Place(248, 339, "Ice Cream Shop", new String[] { "Ice Cream", "Frozen Yogurt", "test" }),
                new Place(258, 349, "Ice Cream Shop", new String[] { "Ice Cream", "Frozen Yogurt", "test" }),
                new Place(281, 395, "Ice Cream Shop", new String[] { "Ice Cream", "Frozen Yogurt", "test" }),
                new Place(2821, 396, "Ice Cream Shop", new String[] { "Ice Cream", "Frozen Yogurt", "test" }),
                new Place(345000, 672000, "Museum",
                        new String[] { "Exhibits", "Guided Tours", "Historical Artifacts", "test" }),
                new Place(1500000, 750000, "Cinema", new String[] { "Movies", "Popcorn", "3D Screenings", "test" }),
                new Place(2420000, 1445000, "Theater",
                        new String[] { "Live Performances", "Plays", "Musicals", "test" }),
                new Place(1250000, 987000, "Park", new String[] { "Trails", "Picnic Areas", "Playgrounds", "test" }),
                new Place(4000000, 3000000, "Shopping Mall",
                        new String[] { "Clothing Stores", "Food Court", "Electronics", "test" }),
                new Place(6000000, 4500000, "Art Gallery",
                        new String[] { "Contemporary Art", "Sculptures", "Paintings", "test" }),
                new Place(8200000, 4700000, "Fitness Center",
                        new String[] { "Gym", "Yoga Classes", "Swimming Pool", "test" }),
                new Place(500000, 1500000, "Botanical Garden",
                        new String[] { "Plant Collections", "Greenhouses", "Educational Tours", "test" }),
                new Place(9500000, 200000, "Aquarium",
                        new String[] { "Marine Life", "Educational Programs", "Dolphin Shows", "test" }),
                new Place(7700000, 2100000, "Zoo",
                        new String[] { "Animals", "Educational Tours", "Conservation", "test" }),
                new Place(2650000, 870000, "Stadium",
                        new String[] { "Sports Events", "Concerts", "Public Gatherings", "test" }),
                new Place(3330000, 4440000, "University",
                        new String[] { "Education", "Research", "Student Life", "test" }),
                new Place(1110000, 2220000, "Hospital",
                        new String[] { "Healthcare", "Emergency Services", "Outpatient Services", "test" }),
                new Place(5555000, 6666000, "Government Office",
                        new String[] { "Public Services", "Legal Affairs", "Documentation", "test" }),
                new Place(8880000, 1110000, "Theme Park", new String[] { "Rides", "Games", "Shows", "test" }),
                new Place(2277000, 3366000, "Beach", new String[] { "Swimming", "Sunbathing", "Volleyball", "test" }),
                new Place(4690000, 5821000, "Ski Resort", new String[] { "Skiing", "Snowboarding", "Lodging", "test" }),
                new Place(9543000, 7772000, "Country Club", new String[] { "Golf", "Tennis", "Dining", "test" }),
                new Place(3355000, 4488000, "Spa", new String[] { "Massages", "Facials", "Wellness Programs", "test" }),
                new Place(120000, 430000, "Campsite", new String[] { "Camping", "Hiking", "Fishing", "test" }),
                new Place(5500000, 6660000, "Race Track",
                        new String[] { "Racing", "Spectator Sports", "Events", "test" }),
                new Place(2300000, 3450000, "Fairgrounds", new String[] { "Fairs", "Exhibitions", "Concerts", "test" }),
                new Place(8888888, 1234567, "Vineyard",
                        new String[] { "Wine Tasting", "Tours", "Grape Harvesting", "test" }),
                new Place(4242000, 2420000, "Historic Site",
                        new String[] { "History Tours", "Museums", "Educational Programs", "test" }),
                new Place(3030000, 5050000, "Farm",
                        new String[] { "Farming", "Produce Markets", "Animal Husbandry", "test" }),
                new Place(7070000, 8080000, "Concert Hall",
                        new String[] { "Concerts", "Performances", "Events", "test" }),
                new Place(2020000, 4040000, "Bowling Alley",
                        new String[] { "Bowling", "Arcades", "Food & Drink", "test" }),
                new Place(9090000, 1010000, "Ice Skating Rink",
                        new String[] { "Ice Skating", "Hockey Games", "Skating Lessons", "test" }),
                new Place(8040000, 2060000, "Brewery",
                        new String[] { "Beer Tasting", "Tours", "Craft Beer Production", "test" }),
                new Place(6750000, 2900000, "Planetarium",
                        new String[] { "Astronomy", "Shows", "Educational Programs", "test" }),
                new Place(850000, 2750000, "Wildlife Refuge",
                        new String[] { "Wildlife", "Nature Trails", "Conservation", "test" }),
                new Place(4300000, 2100000, "Art Studio",
                        new String[] { "Art Classes", "Gallery Shows", "Artist Workshops", "test" }),
                new Place(3200000, 4300000, "Public Pool",
                        new String[] { "Swimming", "Pool Parties", "Swim Lessons", "test" }),
                new Place(1122000, 3344000, "Gaming Lounge",
                        new String[] { "Video Games", "Board Games", "Tournaments", "test" }),
                new Place(5566000, 7788000, "Nature Reserve",
                        new String[] { "Hiking", "Bird Watching", "Nature Tours", "test" }),
                new Place(8899000, 2211000, "Gardens",
                        new String[] { "Botanical Walks", "Flower Exhibitions", "Photography", "test" }),
                new Place(6655000, 4422000, "Climbing Gym",
                        new String[] { "Rock Climbing", "Fitness Training", "Competitions", "test" }),
                new Place(3141000, 5273000, "Sports Complex",
                        new String[] { "Multiple Sports", "Tournaments", "Training Facilities", "test" }),
                new Place(7600000, 3400000, "Yoga Studio",
                        new String[] { "Yoga Classes", "Meditation Sessions", "Wellness Workshops", "test" }),
                new Place(888000, 555000, "Harbor",
                        new String[] { "Boat Rides", "Fishing Trips", "Waterfront Dining", "test" }),
                new Place(3333000, 6667000, "Amusement Park",
                        new String[] { "Thrill Rides", "Family Attractions", "Games", "test" }),
                new Place(1010101, 2020202, "Escape Room",
                        new String[] { "Puzzle Solving", "Team Building", "Adventure Games", "test" }),
                new Place(2121000, 4242000, "Trampoline Park",
                        new String[] { "Jumping", "Fitness Classes", "Kids' Area", "test" }),
                new Place(5656000, 7878000, "Public Library",
                        new String[] { "Books", "Reading Rooms", "Workshops", "test" }),
        };

        map.add(places);
        System.out.println(map.tree.isBalanced());

        int location_x = 7500;
        int location_y = 1500;
        int half_width = 10000000;
        int half_height = 10000000;
        String service = "test";

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