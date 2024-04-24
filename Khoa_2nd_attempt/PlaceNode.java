package Khoa_2nd_attempt;

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

    public boolean findService(String service) {
        return serviceList.contains(service);
    }

    public boolean editServiceList(String[] services) {
        ServiceList list = new ServiceList();

        for (String service : services) {
            list.addService(service);
        }

        this.serviceList = list;

        return true;
    }

    public double distanceTo(Place other) {
        int deltaX = this.x - other.x;
        int deltaY = this.y - other.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public double distanceTo(int x, int y) {
        int deltaX = this.x - x;
        int deltaY = this.y - y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    @Override
    public String toString() {
        return "Place Name: " + name + "(" + this.x + ", " + this.y + "), Services: [" + serviceList.toString()
                + "]";
    }

}
