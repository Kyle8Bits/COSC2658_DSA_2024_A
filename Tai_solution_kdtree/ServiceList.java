package Tai_solution_kdtree;

public class ServiceList {
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
    private int size;
    private Service head;

    public ServiceList() {
        this.size = 0;
        this.head = null;
    }

    public boolean addService(String name) {
        // if the service is currently empty
        if (this.head == null) {
            Service newService = new Service(name);
            this.head = newService;
            this.size++;
            return true;
        }

        // default case. Go to the end of the list and add services.
        // go from head
        Service temp = this.head;
        while (temp.next != null) {
            if (temp.name.equals(name)) {
                // if the name of services is exist, return false;
                System.out.println("The service already exists.");
                return false;
            }
            temp = temp.next;
        }
        // after the while looop, the temp is at null node.
        // create the new service and add to the list
        Service newService = new Service(name);
        temp.next = newService;
        this.size++;
        return true;
    }

    public int getSize() {
        return this.size;
    }

    public void displayServices() {
        if (this.head == null) {
            System.out.println("No services available.");
        }

        Service temp = this.head;// print the service from head
        while (temp != null) {
            if (temp.next == null) {
                System.out.println(temp.getName());
            } else {
                System.out.print(temp.getName() + " --> ");
            }
            temp = temp.next;
        }
    }

    // public boolean checkService(String service){
    //     //check whether the service appear in this list
    //     for
    // }

    @Override
    public String toString() {
        if (this.head == null) {
            return "No services available.";
        }

        String str = "";
        Service temp = this.head;
        while (temp != null) {
            if (temp.next == null) {
                str += temp.getName();
            } else {
                str += temp.getName() + " --> ";
            }
            temp = temp.next;
        }

        return str;
    }
}
