package Tai_solution;
//SeparateChaining Table
//arr[index] = x_axis
//link list = y_axis
public class Map {
    int Y_MAX_LENGTH;
    PlaceLinkList[] Y_LENGTH;

    public Map(int y_length){
        this.Y_MAX_LENGTH = y_length ;
        Y_LENGTH = new PlaceLinkList[Y_MAX_LENGTH];
    }

    public boolean add(Place place){
        if(Y_LENGTH[place.y_cor] == null){
            Y_LENGTH[place.y_cor] = new PlaceLinkList();
        }

        return Y_LENGTH[place.y_cor].insert(place);
    }

    void displayMap(){
        for (int i = 0; i < Y_MAX_LENGTH; i++){
            if(Y_LENGTH[i] == null){
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
