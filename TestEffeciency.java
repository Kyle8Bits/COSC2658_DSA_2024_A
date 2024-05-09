import java.util.Random;

public class TestEffeciency {
    public static void main(String[] args) {
        Random random = new Random();
        int size = 1000000;
        // Generate 100 Place objects
        Place places[] = new Place[size];
        for (int i = 0; i < size - 1; i++) {
            int x = random.nextInt(10000000);
            int y = random.nextInt(10000000);
            String name = generateRandomName();
            String[] services = generateRandomServices();
            places[i] = new Place(x, y, name, services);
        }
        places[size - 1] = new Place(999999, 999999, "removePlace", new String[] { "removeService" });
        Map2D map = new Map2D();

        // ADDING TEST TIME
        long addStart = System.currentTimeMillis();
        map.add(places);
        System.out.println("Map size: " + map.size());
        System.out.println("Adding time : " + (System.currentTimeMillis() - addStart) + "(ms)");
        System.out.println(map.isBalanced());
        // EDIT TEST TIME
        // long editStart = System.nanoTime();
        // map.edit(99999, 91112, new String[] {"edit service", "edit new"});
        // System.out.println("Edit time : " + (System.nanoTime() - editStart) + "(nano
        // time)");

        // REMOVE TEST TIME
        // long removeStart = System.nanoTime();
        // map.remove(999999, 999999);
        // System.out.println("Remove time : " + (System.nanoTime() - removeStart) +
        // "(nano time)");

        // long addSearch = System.currentTimeMillis();
        // PlaceList foundPlaces = map.searchPlaces(5000000, 5000000, 50000, 50000,
        // "Food");
        // System.out.println("Add: " + (double) (System.currentTimeMillis() -
        // addSearch));

        // if (foundPlaces.isEmpty()) {
        // System.out.println("No places found within the specified area that offer the
        // service: "
        // );
        // } else {
        // System.out.println("Found " + foundPlaces.getSize() + " places offering " +
        // "Food" + "' within the area.");
        // System.out.println(foundPlaces.toString(5000000, 5000000));
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
                "Healthcare", "Shopping", "Fitness", "Art", "Community", "Transportation" };
        Random random = new Random();
        int start = random.nextInt(availableServices.length - 5);

        for (int i = 0; i < 5; i++) {
            services[i] = availableServices[start];
            start++;
        }
        return services;
    }
}