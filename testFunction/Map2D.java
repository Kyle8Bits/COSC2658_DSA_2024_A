package testFunction;

public class Map2D {
    public final TwoDimensionTree tree;// the tree contains the place node

    public Map2D() {
        this.tree = new TwoDimensionTree();
    }

    public void add(Place[] places) {
        tree.build(places);
    }

    // edit an place's servies (given x and y)
    public boolean edit(int x, int y, String[] newServices) {
        return tree.editService(x, y, newServices);
    }

    public PlaceList searchPlaces(int x, int y, int walking, String service) {
        return tree.search(x, y, walking, service);
    }

    public boolean remove(int x, int y) {
        return tree.remove(x, y);
    }
}
