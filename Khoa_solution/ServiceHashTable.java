package Khoa_solution;

class ServiceNode{
    String name;
    ServiceNode next;

    ServiceNode(String name){
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

    boolean insert(ServiceNode serviceNode){
        if(head == null){
            size = 1;
            head = serviceNode;

            return true;
        }
        ServiceNode parent = null;
        ServiceNode current =  head;
        while(current != null){
            if(current.name.equals(serviceNode.name)){
                return false;
            }
            parent = current;
            current = current.next;
        }
        parent.next = serviceNode;
        size++;
        return true;
    }
}

public class ServiceHashTable {
    ServiceLinkList[] hashServiceLL;
    int N;

    ServiceHashTable(int N){
        this.N = N;
        hashServiceLL = new ServiceLinkList[N];
        for (int i = 0; i < N; i++){
            hashServiceLL[i] = new ServiceLinkList();
        }
    }

    boolean put(ServiceNode service){
        int hash = hashString(service.name);
        return hashServiceLL[hash].insert(service);
    }

    public int hashCharacter(char c) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        return str.indexOf(c);
    }

    public int hashString(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += hashCharacter(s.charAt(i));
        }
        return res % N;
    }

    
}
