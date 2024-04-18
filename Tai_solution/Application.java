package Tai_solution;

public class Application {
    public static void main(String[] args) {
        PlaceList placeList = new PlaceList();
        ServiceList servicesForRMIT = new ServiceList();
        servicesForRMIT.addService("Library");
        servicesForRMIT.addService("Cafeteria");

        placeList.addPlace("RMIT", servicesForRMIT, 100, 200);

        ServiceList servicesForMIT = new ServiceList();
        servicesForMIT.addService("Tech Lab");
        servicesForMIT.addService("Innovation Hub");

        placeList.addPlace("MIT", servicesForMIT, 300, 400);

        System.out.println(placeList);

    }
}