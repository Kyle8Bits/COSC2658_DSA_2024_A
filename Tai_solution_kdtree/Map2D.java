package Tai_solution_kdtree;

import java.util.List;

public class Map2D {
    public final TwoDimensionTree tree;// the tree contains the place node

    public Map2D() {
        this.tree = new TwoDimensionTree();
    }

    public void add(int x, int y, String placeName, String[] services) {
        ServiceList serviceList = new ServiceList();
        // add the services
        for (String service : services) {
            serviceList.addService(service);
        }
        // after the loop, we have the servcies list and can add to the List
        Place place = new Place(x, y, placeName, serviceList);
        // create the new place with the approriate attributes

        tree.add(place);
    }

    // edit an place's servies (given x and y)
    public boolean edit(int x, int y, String[] newServices) {
        return tree.editService(x, y, newServices);
    }

    public List<PlaceNode>  searchPlaces(int x, int y, int walking, String service) {
        return tree.search(x, y, walking, service);
    }

    public boolean remove(int x, int y) {
        return tree.remove(x, y);
    }
}
