package Tai_solution;

public class XMap {// this map show the x-coordinate of the map
    private PlaceList[] table; // the array of the node.
    private int SIZE = 1000000;// the size of the map, about 1 millionm

    public XMap() {
        this.table = new PlaceList[this.SIZE];// generate the array of Place List
    }

    // public String PlaceToStringHash(int x, int y, String name) {
    //     String processedName = name.replace(" ", "");
    //     //the name.replace will replace all the empty space to the empty character 
    //     //ex: RMIT University --> RMITUniversity
    //     String str = processedName + x + y;
    //     return str;
    // }

    // public int hash(String str) {
    //     // the hash function take the String of the place's name and its x,y coordinate
    //     // For ex: if the place is RMITUniversity (224, 3312).
    //     // the input (str) is RMITUniversity2243312

    //     // this is Polynomial hashing method
    //     int power = 1;
    //     int hashValue = 0;
    //     for (int i = 0; i < str.length(); i++) {
    //         hashValue = (hashValue + (str.charAt(i) - '0' + 1) * power) % SIZE;
    //         power = (power * 31) % SIZE;// advoid the power go over SIZE
    //         // 31 is a smallest prime number larger than the number of characters in the
    //         // alphabet (26 letters)
    //     }
    //     return hashValue;
    // }
    private int hash(int key){
        return key % SIZE;
    }

    public boolean put(Place place) {
        //calculate the hash value
        int hashValue = hash(place.x);//use x coordinate of place to hash the key

        //if the location is null
        if(table[hashValue] == null){
            table[hashValue] = new PlaceList();
        }

        return table[hashValue].insert(place);
    }

    public Place get(Place place){
        //calculate the hash value
        // int hashValue = hash(PlaceToStringHash(place.x, place.y, place.name));\
        int hashValue = hash(place.x);//use x coordinate of place to hash the key
        
        if(table[hashValue] == null){
            return null;
        }
        return table[hashValue].get(place.x, place.y);
        
    }
}
