package Khoa_new_solution;

public class K_Dimension_Tree {
    PlaceNode root;
    int k;

    public K_Dimension_Tree(int k){
        this.k = k;
        root = null;
    }

    void insert(Place newPlace){
        if(root == null){   
            root = new PlaceNode(newPlace);
        }

        inserRec(root,newPlace , 0);
    }

    void inserRec(PlaceNode root, Place newPlace, int depth){
        int  dim = depth % k;
        if(dim == 0){

        }
    }
}

class Place{

    int x;
    int y;
    
    public Place(int x, int y){
        this.x = x;
        this.y = y;
    }

}

class PlaceNode{
    Place place;
    Place right, left;

    public PlaceNode(Place place){
        this.place = place;
        right = null;
        left = null;
    }
    


}


