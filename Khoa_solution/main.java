package Khoa_solution;

public class Main {
    public static void main(String[] args) {
        Map GoogleMap = new Map(10000000);

        Place place1 = new Place(900, 800, "EDUCATION", "RMIT University");
        Place place2 = new Place(700, 600, "GasStation", "Petrolimex");
        Place place3 = new Place(1000, 1000, "GasStation", "VIPCO");
        Place place4 = new Place(1200, 850, "GasStation", "VITACO");


        GoogleMap.add(place1);
        GoogleMap.add(place2);
        GoogleMap.add(place3);
        GoogleMap.add(place4);


        GoogleMap.displayMap();

        GoogleMap.searchArea(place1, "GasStation", 400);
    }
}
