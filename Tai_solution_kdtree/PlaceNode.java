package Tai_solution_kdtree;

class PlaceNode {
    Place data;
    PlaceNode parent = null;
    PlaceNode left = null;
    PlaceNode right = null;
    int subtreeNodes;
    int height;

    PlaceNode(PlaceNode parent, Place data) {
        this.parent = parent;
        this.data = data;
        subtreeNodes = 1;
        height = 0;
    }

    public int getHeight() {
        return height;
    }

    public int updateHeight() {
        int leftHeight = 0;
        if (left != null) {
            leftHeight = left.getHeight();
        }
        int rightHeight = 0;
        if (right != null) {
            rightHeight = right.getHeight();
        }
        height = Math.max(leftHeight, rightHeight) + 1;
        return height;
    }

    public int getBalanceFactor() {
        int leftHeight = 0;
        if (left != null) {
            leftHeight = left.getHeight();
        }
        int rightHeight = 0;
        if (right != null) {
            rightHeight = right.getHeight();
        }
        return rightHeight - leftHeight;
    }
}

class Place {
    // the coordinate of the place
    int x;
    int y;
    String name;
    ServiceList serviceList; // Each Place has a name and a list of services

    public Place(String name) {
        this.name = name;
        this.serviceList = new ServiceList();
    }

    public Place(int x, int y, String name, ServiceList serviceList) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.serviceList = serviceList;
    }

    @Override
    public String toString() {
        return "Place Name: " + name + "(" + this.x + ", " + this.y + "), Services: [" + serviceList.toString()
                + "]";
    }

}
