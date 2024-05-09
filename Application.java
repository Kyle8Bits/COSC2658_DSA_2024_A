public class Application {
        public static void main(String[] args) {
                // set up the map
                Map2D map = new Map2D();

                Place[] places = {
                                new Place(15, 80, "Ton Duc Thang University",
                                                new String[] { "Education", "Library", "Parking" }),
                                new Place(20, 50, "Nguyen Tat Thanh University",
                                                new String[] { "Education", "Parking", "Food", "Dorm" }),
                                new Place(50, 70, "RMIT University Vietnam",
                                                new String[] { "Education", "Drinks", "Food", "Parking", "Theater",
                                                                "Stadium", "Football Field" }),
                                new Place(70, 90, "Phuc Long Coffe",
                                                new String[] { "Drinks", "Dessert", "Stationery", "Free WiFi" }),
                                new Place(85, 95, "The Coffee House",
                                                new String[] { "Drinks", "Study Rooms", "Free WiFi", "Garden" }),
                                new Place(51, 90, "Cresent Mall",
                                                new String[] { "Shopping", "Fitness", "Free WiFi", "Food", "Theater",
                                                                "Parking" }),
                                new Place(51, 91, "Vivo Megamall",
                                                new String[] { "Shopping", "Food", "Bowling", "Playground", "Fitness",
                                                                "Parking" }),
                                new Place(52, 92, "Petrolimex Gas Station", new String[] { "Gasoline", "Grocery" }),
                                new Place(53, 93, "PVOIL Gas Station", new String[] { "Gasonline", "Grocery", "Food" }),
                                new Place(54, 94, "RMIT Parking Lot", new String[] { "Parking" })
                };

                System.out.println("ADD FUNCTION \n");
                System.out.println("The place number that created: " + places.length);

                System.err.println("Adding........");
                map.add(places);
                System.out.println("Successfully add " + map.size() + " places into the map");

                System.out.println("Test the tree balanced condition: " + map.isBalanced());

                System.out.println("\n===========================================================================\n");

                // -----------------------------------

                System.out.println("EDIT FUNCTION:\n");
                System.out.println("Map before edit RMIT PARKING LOT (54,94), service list 'Parking': ");
                System.out.println(map.find(54, 94).data);

                map.edit(54, 94, new String[] { "Parking", "Information" });
                System.out.println("Map after edit RMIT PARKING LOT");
                System.out.println(map.find(54, 94).data);

                System.out.println("\n===========================================================================\n");

                // ------------------------------------------------------------

                System.out.println("REMOVE FUNCTION:\n");
                System.out.println("Size of the map before remove: " + map.size());
                System.out.println("The list of places in the map before remove 'Phuc Long Coffee'");
                map.remove(70, 90);

                System.out.println("\n");
                System.out.println("Size of the map after remove: " + map.size());
                System.out.println("The list of places in the map after remove 'Phuc Long Coffee'");

                // -----------------------------------------------------------

                System.out.println("SEARCH FUNCTION:\n");
                // set up for search alogrtihm
                int location_x = 45;
                int location_y = 85;
                int half_width = 15;
                int half_height = 15;
                String service = "Shopping";

                System.out.println("Your current location is (45,85), we will search for the '" + service
                                + "' service within the area.....");

                // set up the evaluate base
                System.out.println("The total places in the map: " + map.size());
                // run the search
                PlaceList foundPlaces = map.searchPlaces(location_x, location_y, half_width, half_height, service);

                // Output the results
                if (foundPlaces.isEmpty()) {
                        System.out.println(
                                        "No places found within the specified area that offer the service: " + service);
                } else {
                        System.out.println("Found " + foundPlaces.getSize() + " places offering '" + service
                                        + "' within the area.");
                        System.out.println(foundPlaces.toString(location_x, location_y));
                }

                System.out.println("\n===========================================================================\n");

                // ----------------------------------------------------------------
        }
}