package Khoa_solution;

// public class ServiceList {
//     String name;
//     int N;
//     // int size;
//     String[] hashTableService;

//     public ServiceList(){
//         N = 5;
//         hashTableService = new String[N];
//     }
// }

class Service {
    String name;
    Service next;

    Service(String name){
        this.name = name;
        next = null;
    }
}

class ServiceLinkList{
    Service head;
    int size;

    ServiceLinkList(){
        head = null;
        size = 0;
    }

    void displayList(){
        Service current = head;
        while(current != null){
            System.out.print(current.name + " => ");
            current = current.next;
        }
    }

    public boolean insert(String service) {
        if (head == null) {
            head = new Service(service);
            size = 1;
            return true;
        }
            Service parent = null;
            Service current = head;
        while (current != null) {
            if (current.name.equals(service)) {
                return false;
            }
            parent = current;
            current = current.next;
        }
        parent.next = new Service(service);
        size++;
        return true;  
    }
}

public class ServiceHashTable{
    int N;
    ServiceLinkList[] arrServiceLinkList;

    ServiceHashTable(int N){
        this.N = N;
        arrServiceLinkList = new ServiceLinkList[N];
        for (int i = 0; i < N; i ++){
            arrServiceLinkList[i] = new ServiceLinkList();
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

    boolean put(String name){
        int hash = hashString(name);
        return arrServiceLinkList[hash].insert(name);
    }

    boolean checkOfferService(String name){
        int serviceNum = hashString(name);
        ServiceLinkList serviceList = arrServiceLinkList[serviceNum];
        if (serviceList.head == null) {
            return false;
        }
        
        Service temp = serviceList.head;
        while (temp != null) {
            if (temp.name.equals(name)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    void displayService(){
        for (int i = 0; i < N; i++){
            if(arrServiceLinkList[i].head == null){
                continue;
            }
            else{
                System.out.print("Table " + i +" : ");
                arrServiceLinkList[i].displayList();
                System.out.print("\n");
            }
        }
    }
}

