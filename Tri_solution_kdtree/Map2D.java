package Tri_solution_kdtree;

public class Map2D {
    private final TwoDimensionTree tree;// the tree contains the place node

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

    // public PlaceNode find(int x, int y){
    //     return tree.find(x, y);
    // }

     // Remove a place (given x and y)
     public PlaceNode remove(int x, int y) {
        return tree.remove(x, y);
    }

    // Print the map using breadth-first traversal
    public void printBreadthFirst() {
        tree.printBreadthFirst();
    }

}