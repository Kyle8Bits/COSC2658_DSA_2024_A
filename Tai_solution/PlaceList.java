package Tai_solution;

public class PlaceList {
    private PlaceNode head; // Head of the list
    private int size; // Size of the list

    public PlaceList() {
        this.head = null;
        this.size = 0;
    }

    public boolean insert(Place place) {
        // if the placeList is currently empty
        if (this.size == 0) {
            this.head = new PlaceNode(place);
            size = 1;
            return true;
        }
        // default case. Go to the end of the list and add services.
        // go from head
        PlaceNode temp = this.head;
        while (temp.next != null) {
            if (place.x == temp.data.x && place.y == temp.data.y) {// if the coordinate are duplicated
                System.out.println("A place with these coordinates already exists!");
                return false;
            }
            temp = temp.next;
        }

        // after the while looop, the temp is at null node.
        // create the new place and add to the list
        PlaceNode newPlaceNode = new PlaceNode(place);
        temp.next = newPlaceNode;
        this.size++;
        return true;
    }

    public Place get(int x, int y){
        PlaceNode temp = this.head;
        while(temp != null){
            if(temp.data.x == x || temp.data.y == y){
                return temp.data;
            }
            temp = temp.next;
        }

        return null;//reeturn null if end the loop and still not find the place
    }

    @Override
    public String toString() {
        if (this.head == null) {
            return "No place available.";
        }

        String str = "";
        PlaceNode temp = this.head;
        while (temp != null) {
            if (temp.next == null) {
                str += temp.data.toString();
            } else {
                str += temp.data.toString() + " --> ";
            }
            temp = temp.next;
        }

        return str;
    }

    public int getSize() {
        return this.size;
    }

    // public PlaceList getPlacesByService(String service){
    //     PlaceList list = new PlaceList();

    //     PlaceNode temp = this.head;
    //     while(temp != null){
            
    //     }
    // }

}

class PlaceNode {
    Place data;
    PlaceNode next; // Next Place in the list

    PlaceNode(Place data) {
        this.data = data;
        this.next = null;
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
