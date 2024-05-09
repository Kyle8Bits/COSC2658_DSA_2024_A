public class demoVideoTest {
    public static void main(String[] args) {
        Place[] places = new Place[] {
                new Place(15, 80, "Ton Duc Thang University", new String[] { "Education", "Library", "Parking"}),
                new Place(20, 50, "Nguyen Tat Thanh University", new String[] { "Education", "Parking", "Food", "Dorm"}),
                new Place(50, 70, "RMIT University Vietnam", new String[] { "Education", "Drinks", "Food", "Parking", "Theater", "Stadium", "Football Field"}),
                new Place(70, 90, "Phuc Long Coffe", new String[] { "Drinks", "Dessert", "Stationery", "Free WiFi" }),
                new Place(85, 95, "The Coffee House", new String[] { "Drinks", "Study Rooms", "Free WiFi", "Garden" }),
                new Place(51, 90, "Cresent Mall", new String[] { "Shopping", "Fitness", "Free WiFi", "Food", "Theater", "Parking"}),
                new Place(51, 91, "Vivo Megamall", new String[] { "Shopping", "Food", "Bowling", "Playground", "Fitness", "Parking" }),
                new Place(52, 92, "Petrolimex Gas Station", new String[] { "Gasoline", "Grocery"}),
                new Place(53, 93, "PVOIL Gas Station", new String[] {"Gasonline", "Grocery", "Food" }),
                new Place(54, 94, "RMIT Parking Lot", new String[] {"Parking"})
        };

        Map2D map = new Map2D();
        map.add(places);
        System.out.println(map.isBalanced());
        System.out.println("In-order: ");
        map.inOrder();
    }
}
