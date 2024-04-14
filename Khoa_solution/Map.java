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

}
