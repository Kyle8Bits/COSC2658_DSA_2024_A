import java.util.Random;

//THIS CLASS IS ONLY USING TO TEST THE BIG DATA, THE RESULT FOR EACH FUNCTION CAN BE DIFFERENT, 
//SINCE THE DATA IS RANDOMIZE EACH TIME.

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