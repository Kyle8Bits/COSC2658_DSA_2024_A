package Khoa_solution;

public class Place{
    Place next;
    int x_cor, y_cor;
    ServiceHashTable hashService;
    String name = "UNKNOWN";
    

    public Place (int x_cor, int y_cor, String name){
        this.x_cor = x_cor;
        this.y_cor = y_cor;
        hashService = new ServiceHashTable(5);
        this.name = name;
        next = null;
    }
    // void displayService(){
    //     serviceList.displayService();
    // }

}

class PlaceLinkList{
    Place head;
    int size;

    public PlaceLinkList(){
        head = null;
        size = 0;
    }

    public boolean insert(Place place) {
        if (head == null) {
            head = new Place(place.x_cor, place.y_cor, place.name);
            size = 1;
            return true;
        }
            Place parent = null;
            Place current = head;
        while (current != null) {
            if (current.y_cor == place.y_cor) {
                return false;
            }
            parent = current;
            current = current.next;
        }
        parent.next = new Place(place.x_cor, place.y_cor, place.name);
        size++;
        return true;  
    }

    public void remove(Place place) {
        // Case 1: If the list is empty
        if (head == null)
            return;

        // Case 2: If the node to be removed is the head node
        if (head == place) {
            head = head.next;
            return;
        }

        // Case 3: If the node to be removed is in the middle of the list
        Place current = head;
        Place prev = null;
        while (current != null && current != place) {
            prev = current;
            current = current.next;
        }
        if (current != null) {
            prev.next = current.next;
        }
    }

    void displayList(){
        Place current = head;
        while(current != null){
            System.out.print( "X = "+ current.x_cor + " => ");
            current = current.next;
        }
    }
}