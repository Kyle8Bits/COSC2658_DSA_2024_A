
class PlaceNode {// Use for tree
    Place data;
    PlaceNode parent = null;
    PlaceNode left = null;
    PlaceNode right = null;
    int subtreeNodes;

    PlaceNode(PlaceNode parent, Place data) {
        this.parent = parent;
        this.data = data;
        subtreeNodes = 1;
    }
}

class Place {
    // the coordinate of the place
    int x;
    int y;
    String name;
    ServiceList serviceList; // Each Place has a name and a list of services

    public Place(int x, int y, String name, ServiceList serviceList) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.serviceList = serviceList;
    }

    public Place(int x, int y, String name, String[] services) {
        this.x = x;
        this.y = y;
        this.name = name;

        ServiceList serviceList = new ServiceList();
        for (String service : services) {
            serviceList.addService(service);
        }

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

    public double distanceTo(int x, int y) {
        double deltaX = this.x - x;
        double deltaY = this.y - y;
        return  Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    // @Override
    public String toString(int x, int y) {
        String distance = String.format("%.2f", this.distanceTo(x, y));

        return "Place Name: " + name + "(" + this.x + ", " + this.y + "), Services: [" + serviceList.toString()
                + "]" + ", Distance to your location: " + distance;
    }

    @Override
    public String toString() {
        // String distance = String.format("%.2f", this.distanceTo(x, y));

        return "Place Name: " + name + "(" + this.x + ", " + this.y + "), Services: [" + serviceList.toString()
                + "]";
    }

}