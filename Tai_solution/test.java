package Tai_solution;

import Tai_solution.Map;
import Tai_solution.Place;

public class test {
    public static void main(String[] args) {
        Map GoogleMap = new Map(10000000);

        Place place1 = new Place(9000000, 6798000, "RMIT University");

        GoogleMap.add(place1);

        GoogleMap.displayMap();

    }
}
