import java.util.Random;

public class PlaceGenerator {

    public static void main(String[] args) {
        Random random = new Random();
        char tick = '"';
        // Generate 100 Place objects
        for (int i = 0; i < 1000; i++) {
            int x = random.nextInt(7878000 - 1000000 + 1) + 1000000;
            int y = random.nextInt(7878000 - 1000000 + 1) + 1000000;
            String name = generateRandomName();
            String[] services = generateRandomServices();
            // Do something with the Place object, like printing it
            System.out.println("new Place("+x+"," + y +"," + tick + name + tick + ", new String[] {" + printArry(services) + "}),");
        }
    }

    private static String printArry(String[] service){
        String result = "";
        char tick = '"';
        for (int i  = 0; i < service.length; i++){
            result += tick + service[i] + tick + ",";
        }
        return result;
    }

    private static String generateRandomName() {
        String[] names = { "Park", "Restaurant", "Museum", "School", "Hospital",
                "Cafe", "Shop", "Theater", "Gym", "Library", "Community Center", 
                "Botanical Garden", "Art Gallery", "Town Square", "Recreational Center", 
                "Visitor Center", "Cultural Center", "Exhibition Hall", "Amphitheater", "Observatory" };
        Random random = new Random();
        Random random2 = new Random();

        int rand = random2.nextInt(100);
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