package Tri_solution;

public class Map2D {
    private XMap[] rows;// the array of Xmap, represent the x-coordinat of the mpa
    private int Y_SIZE = 10000000;// the size of the map, about 1 millionm

    public Map2D(){
        rows = new XMap[Y_SIZE];
    }

    public void addPlace(Place place){
        if(rows[place.y] == null){
            rows[place.y] = new XMap();
        }
        rows[place.y].put(place);
    }

    public Place getPlace(Place place){
        if(rows[place.y] == null){
            return null;
        }

        return rows[place.y].get(place);
    }
}
