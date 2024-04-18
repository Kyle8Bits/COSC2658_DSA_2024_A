package Tai_solution;

public class PlaceList {
    static class Place {
        // the coordinate of the place
        int x;
        int y;
        String name;
        ServiceList serviceList; // Each Place has a name and a list of services
        Place next; // Next Place in the list

        public Place(String name) {
            this.name = name;
            this.serviceList = new ServiceList();
            this.next = null;
        }

        public Place(String name, ServiceList serviceList, int x, int y) {
            this.name = name;
            this.serviceList = serviceList;
            this.x = x;
            this.y = y;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Place Name: " + name + "(" + this.x + ", " + this.y + "), Services: [" + serviceList.toString()
                    + "]";
        }
    }

    private int size; // Size of the list
    private Place head; // Head of the list

    public PlaceList() {
        this.head = null;
        this.size = 0;
    }

    public boolean addPlace(String name, ServiceList list, int x, int y) {
        // if the placeList is currently empty
        if (this.head == null) {
            Place newPlace = new Place(name, list, x, y);
            this.head = newPlace;
            this.size++;
            return true;
        }

        // default case. Go to the end of the list and add services.
        // go from head
        Place temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        // after the while looop, the temp is at null node.
        // create the new place and add to the list
        Place newPlace = new Place(name, list, x, y);
        temp.next = newPlace;
        this.size++;
        return true;
    }

    @Override
    public String toString() {
        if (this.head == null) {
            return "No place available.";
        }

        String str = "";
        Place temp = this.head;
        while (temp != null) {
            if(temp.next == null){
                str += temp.toString();
            }else {
                str += temp.toString() + " --> ";
            }
            temp = temp.next;
        }

        return str;
    }

}
