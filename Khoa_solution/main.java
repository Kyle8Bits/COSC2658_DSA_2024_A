package Khoa_solution;

public class main {
    public static void main(String[] args) {
        Map GoogleMap = new Map(10000000);

        Place place1 = new Place(9000000, 6798000, "RMIT University");

        GoogleMap.add(place1);

        GoogleMap.displayMap();

    }
}
