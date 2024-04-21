package Khoa_solution;
//SeparateChaining Table
//arr[index] = x_axis
//link list = y_axis
public class Map {
    int Y_MAX_LENGTH;
    PlaceLinkList[] Y_LENGTH;

    public Map(int y_length){
        this.Y_MAX_LENGTH = y_length ;
        Y_LENGTH = new PlaceLinkList[Y_MAX_LENGTH];
        for (int i = 0; i < y_length; i++) {
            Y_LENGTH[i] = new PlaceLinkList();
        } 
    }

    public boolean add(Place place){
        return Y_LENGTH[place.y_cor].insert(place);
    }

    void displayMap(){
        for (int i = 0; i < Y_MAX_LENGTH; i++){
            if(Y_LENGTH[i].head == null){
                continue;
            }
            else{
                System.out.print("Y = " + i +" : ");
                Y_LENGTH[i].displayList();
                System.out.print("\n");
            }
        }
    }

    void searchArea(Place location, String service, int distance){
        int side = distance / (int)Math.sqrt(2);
        int bot_y = location.y_cor - side >= 0 ? location.y_cor - side : location.y_cor;
        int top_y = bot_y + (int)(2*side) <= Y_MAX_LENGTH ? bot_y + (int)(2*side) : Y_MAX_LENGTH;


        int front_x = location.x_cor - side >= 0 ? location.x_cor - side : location.x_cor;
        int rear_x = front_x+(int)(side*2) <= Y_MAX_LENGTH ? front_x+(int)(side*2) : Y_MAX_LENGTH;

        for (int i = bot_y+1 ; i < top_y-1 ; i++){
            if(Y_LENGTH[i].head == null){
                continue;
            }
            else{
                Place head = Y_LENGTH[i].head;
                Place temp = null;
                while (head != null) {
                    if(!head.name.equals(location.name) && (head.x_cor < rear_x && head.x_cor > front_x)){
                        
                    }
                    temp = head;
                    head = head.next;
                }
            }
        }
    }

}
