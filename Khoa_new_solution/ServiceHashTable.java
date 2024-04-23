package Khoa_new_solution;

public class ServiceHashTable{
    ServiceLinkList[] hashtableService;
    int N;

    public ServiceHashTable(int N){
        this.N = N;
        hashtableService = new ServiceLinkList[N];
        for(int i = 0; i < N; i++){
            hashtableService[i] = new ServiceLinkList();
        }
    }

    int hashCharacter(char c) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";    
        return str.indexOf(c);
      }
    
    
    int hashString(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
          res += hashCharacter(s.charAt(i));
        }
        return res % N;
    }

    boolean put(String service){
        int hash = hashString(service);

        return hashtableService[hash].insert( new ServiceNode(service));

    }

    boolean checkOfferService(ServiceNode service){
        int hash = hashString(service.name);
        if(hashtableService[hash] == null){
            return false;
        }
        return hashtableService[hash].get(service);
    }

    void displayHashTable(){
        System.out.println("HASH TABLE");
        for(int i = 0 ; i < hashtableService.length ; i++){
            if(hashtableService[i] != null){
            System.out.print("Hash: "+ i +" : ");
            hashtableService[i].displayLinkList();
            System.out.print("\n");
            }
        }
    }
    
}

enum SERVICE{
    EDUCATION,
    GAS_STATION,
    COFFEE,
    RESTAURANT,
    FOOD,
    HOTEL,
    CONVENIENCE_STORE,
    PARKING_LOT,
    MARKET,
    MALL,
    MUSEUMS,
    TRANSIT,
    PHARMACY,
    ATM

    

}

class ServiceNode{
    String name;
    ServiceNode next;

    public ServiceNode(String name){
        this.name = name;
        next = null;
    }
}

class ServiceLinkList{
    ServiceNode head;
    int size;

    ServiceLinkList(){
        head = null;
        size = 0;
    }

    public boolean insert(ServiceNode service){
        if(head == null){
            head = new ServiceNode(service.name);
            size = 1;
            return true;
        }
        
        ServiceNode current = head;
        ServiceNode parent = null;
        while(current!= null){
            if(current.name.equals(service.name)){
                return false;
            }
            parent = current;
            current = current.next;
        }
        parent.next = new ServiceNode(service.name);
        size++;
        return true;
    }

    public int getSize(){
        return this.size;
    }

    boolean get(ServiceNode serviceNode){
        if(head == null){
            return false;
        }

        ServiceNode current = head;
        ServiceNode temp =null;

        while (current != null){
            if(current.name.equals(serviceNode.name)){
                return true;
            }
            temp = current;
            current = current.next;
        }
        return false;
    }

    void displayLinkList(){
        ServiceNode temp = head;

        while(temp != null){
            System.out.print(temp.name + " => ");
            temp = temp.next;
        }
    }
}


