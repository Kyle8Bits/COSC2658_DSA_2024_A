package testFunction;

public class PlaceList {
    static class PlaceNodeList {
        Place data;
        PlaceNodeList next;

        PlaceNodeList(Place data) {
            this.data = data;
        }
    }

    private PlaceNodeList head; // Head of the list
    private int size; // Size of the list

    public PlaceList() {
        this.head = null;
        this.size = 0;
    }

    public boolean insert(Place place) {
        // if the placeList is currently empty
        if (this.size == 0) {
            this.head = new PlaceNodeList(place);
            size = 1;
            return true;
        }
        // default case. Go to the end of the list and add services.
        // go from head
        PlaceNodeList temp = this.head;
        while (temp.next != null) {
            if (place.x == temp.data.x && place.y == temp.data.y) {// if the coordinate are duplicated
                return false;
            }
            temp = temp.next;
        }

        // after the while looop, the temp is at null node.
        // create the new place and add to the list
        PlaceNodeList newPlaceNode = new PlaceNodeList(place);
        temp.next = newPlaceNode;
        this.size++;
        return true;
    }

    public Place get(int x, int y) {
        PlaceNodeList temp = this.head;
        while (temp != null) {
            if (temp.data.x == x || temp.data.y == y) {
                return temp.data;
            }
            temp = temp.next;
        }

        return null;// reeturn null if end the loop and still not find the place
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    @Override
    public String toString() {
        if (this.head == null) {
            return "No place available.";
        }

        String str = "";
        PlaceNodeList temp = this.head;
        while (temp != null) {
            if (temp.next == null) {
                str += temp.data.toString();
            } else {
                str += temp.data.toString() + "\n";
            }
            temp = temp.next;
        }

        return str;
    }

    public int getSize() {
        return this.size;
    }

}
