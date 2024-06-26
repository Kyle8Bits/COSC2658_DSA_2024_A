
public class PlaceList {
    static class PlaceListNode {
        Place data;
        PlaceListNode next;

        PlaceListNode(Place data, PlaceListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    private PlaceListNode head; // Head of the list
    private int size; // Size of the list

    public PlaceList() {
        this.head = null;
        this.size = 0;
    }

    public boolean insert(Place place, int x, int y) {
        // if the placeList is currently empty
        if (this.size == 0) {
            this.head = new PlaceListNode(place, null);
            this.size ++;
            return true;
        }
        double distance = place.distanceTo(x, y);//distacne is the value of the place in the parameter to the current location

        //if the distance from the place to the current location is smaller than the head. We change the head
        if(distance < this.head.data.distanceTo(x, y)){
            PlaceListNode newNode = new PlaceListNode(place, this.head);
            this.head = newNode;
            size++;
            return true;
        }

        //default case
        PlaceListNode tempNode = this.head;
        PlaceListNode prevNode = null;
        while (tempNode != null) {
            if (place.x == tempNode.data.x && place.y == tempNode.data.y) {// if the coordinate are duplicated
                return false;
            }
            if(distance < tempNode.data.distanceTo(x, y)){
                //if find the appropriate position.
                //we use the prev node to insert it
                PlaceListNode newNode =  new PlaceListNode(place, tempNode);
                prevNode.next = newNode;
                size++;
                return true;
            }
            prevNode = tempNode;
            tempNode = tempNode.next;
        }

        // if we reach the the null --> add at the end
        PlaceListNode newNode = new PlaceListNode(place, null);
        prevNode.next = newNode;
        size++;
       
        return true;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    // @Override
    public String toString(int x, int y) {
        if (this.head == null) {
            return "No place available.";
        }

        String str = "";
        PlaceListNode temp = this.head;
        while (temp != null) {
            if (temp.next == null) {
                str += temp.data.toString(x, y);
            } else {
                str += temp.data.toString(x, y) + "\n";
            }
            temp = temp.next;
        }

        return str;
    }

    public int getSize() {
        return this.size;
    }

}