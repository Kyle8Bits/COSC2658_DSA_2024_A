package Khoa_new_solution;

public class main {
    public static void main(String[] args) {
        K_Dimension_Tree map = new K_Dimension_Tree(2);

        Place p1,p2,p3,p4;

        p1 = new Place(10, 20,"RMIT");
        p2 = new Place(20, 30,"TDTU");
        p3 = new Place(15, 23,"VLU");
        p4 = new Place(11, 22,"BKU");

        map.add(p1);
        map.add(p2);
        map.add(p3);
        map.add(p4);

        PlaceNode best = map.nearestRec(p4, 0, 20000);
        System.out.println(map.root.place.x);
        System.out.println(p4.x + " / " + p4.y);
        System.out.println(best.place.x + " / " + best.place.y);
    }


    // public PlaceNode[] searchNearestPlaces(K_Dimension_Tree map, PlaceNode location, int depth, int walking){
    //     if (map.root == null){
    //         return null;
    //     }
    //     return nearestRec(map, location, depth, walking);
    // }
    // public PlaceNode nearestRec(K_Dimension_Tree map, PlaceNode location, int depth, int walking){
    //     PlaceNode best = map.root;

    //     int level = depth % map.k;
    //     while(best != )
    //     if(level == 0){
            
    //     }
    //     else{

    //     }

    //     return best;
    // }


}
