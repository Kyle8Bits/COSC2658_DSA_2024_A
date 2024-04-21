package Tri_solution;

public class ServiceList {
    static final int SIZE = 10; // Size of the hash table

    // the static class service inside the list.
    static class Service {
        String name;
        Service next;

        public Service(String name) {
            this.name = name;
            this.next = null;
        }

        public String getName() {
            return name; // Returns the name of the service
        }
    }

    // attributes of serviceList
    private Service[] table;

    public ServiceList() {
        this.table = new Service[SIZE];
    }

    private int hash(String serviceName) {
        int hashValue = 0;
        int power = 1;
        for (int i = 0; i < serviceName.length(); i++) {
            hashValue = (hashValue + (serviceName.charAt(i) - '0' + 1) * power) % SIZE;
            power = (power * 31) % SIZE; 
        }
        return hashValue;
    }

    public boolean addService(String name) {
        int index = hash(name);
        Service current = table[index];
        Service previous = null;
        while (current != null) {
            if (current.name.equals(name)) {
                System.out.println("The service already exists.");
                return false;
            }
            previous = current;
            current = current.next;
        }
        
        Service newService = new Service(name);
        if (previous == null) {
            table[index] = newService;
        } else {
            previous.next = newService;
        }
        return true;
    }

    public void displayServices() {
        for (int i = 0; i < SIZE; i++) {
            Service temp = table[i];
            while (temp != null) {
                if (temp.next != null) {
                    System.out.print(temp.name + " --> ");
                } else {
                    System.out.println(temp.name);
                }
                temp = temp.next;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            Service temp = table[i];
            while (temp != null) {
                builder.append(temp.name);
                if (temp.next != null) {
                    builder.append(" --> ");
                }
                temp = temp.next;
            }
        }
        return builder.toString();
    }
}