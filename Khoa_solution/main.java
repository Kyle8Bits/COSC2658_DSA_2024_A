package Khoa_solution;

public class Main {
    public static void main(String[] args) {
        Map GoogleMap = new Map(10000000);

        Place place1 = new Place(900, 800, "RMIT University");
        place1.serviceList.put("EDUCATION");

        Place place2 = new Place(700, 600, "Petrolimex");
        place2.serviceList.put("GAS");
        
        Place place3 = new Place(1000, 1000, "VIPCO");
        Place place4 = new Place(1200, 850, "VITACO");


        GoogleMap.add(place1);
        GoogleMap.add(place2);
        // GoogleMap.add(place3);
        // GoogleMap.add(place4);

        place2.displayService();
        // GoogleMap.displayMap();

        // System.out.println(place1.serviceList.arrServiceLinkList[3].head.name); 

        GoogleMap.searchArea(place1, "Gas", 800);
    }
}
