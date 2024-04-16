package Tri_solution;

public class Place {
    private double x, y;
    private String services;

    // Constructor
    public Place(double x, double y, String services) {
        this.x = x;
        this.y = y;
        this.services = services;
    }

    // Getter for x
    public double getX() {
        return x;
    }

    // Setter for x
    public void setX(double x) {
        this.x = x;
    }

    // Getter for y
    public double getY() {
        return y;
    }

    // Setter for y
    public void setY(double y) {
        this.y = y;
    }

    // Getter for services
    public String getServices() {
        return services;
    }

    // Setter for services
    public void setServices(String services) {
        this.services = services;
    }
}