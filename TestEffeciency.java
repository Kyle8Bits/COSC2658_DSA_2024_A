import java.util.Random;

public class TestEffeciency {

    public static void main(String[] args) {
        Random random = new Random();
        // Generate 100 Place objects
        Place places[] = new Place[50000000];
        for (int i = 0; i < 50000000; i++) {
            int x = random.nextInt(10000000);
            int y = random.nextInt(10000000);
            String name = generateRandomName();
            String[] services = generateRandomServices();
            // Do something with the Place object, like printing it
            // System.out.println("new Place("+x+"," + y +"," + tick + name + tick + ", new String[] {" + printArry(services) + "}),");
            places[i] = new Place(x, y, name, services);
        }

        Map2D map = new Map2D();

        long addStart = System.currentTimeMillis();
        map.add(places);
        System.out.println("Add: " + (double) (System.currentTimeMillis() - addStart));

        System.out.println("Map size: " +  map.tree.size());

        long addSearch = System.currentTimeMillis();
        PlaceList foundPlaces = map.searchPlaces(5000000, 5000000, 50000, 50000, "Food");
        System.out.println("Add: " + (double) (System.currentTimeMillis() - addSearch));


        // if (foundPlaces.isEmpty()) {
        //     System.out.println("No places found within the specified area that offer the service: "
        //                     );
        // } else {
        //     System.out.println("Found " + foundPlaces.getSize() + " places offering " + "Food" + "' within the area.");
        //     System.out.println(foundPlaces.toString(5000000, 5000000));
        // }
    }

    private static String generateRandomName() {
        String[] names = { "Park", "Restaurant", "Museum", "School", "Hospital",
                "Cafe", "Shop", "Theater", "Gym", "Library", "Community Center", 
                "Botanical Garden", "Art Gallery", "Town Square", "Recreational Center", 
                "Visitor Center", "Cultural Center", "Exhibition Hall", "Amphitheater", "Observatory" };
        Random random = new Random();
        Random random2 = new Random();

        int rand = random2.nextInt(10000000);
        return names[random.nextInt(names.length)] + rand;
    }

    private static String[] generateRandomServices() {
        String[] services = new String[5];
        String[] availableServices = { "Food", "Drinks", "Entertainment", "Education",
                "Healthcare", "Shopping", "Fitness", "Art", "Community","Transportation"};
        Random random = new Random();
        int start = random.nextInt(availableServices.length - 5);
        
        for (int i = 0; i < 5; i++) {
            services[i] = availableServices[start];
            start++;
        }
        return services;
    }
}