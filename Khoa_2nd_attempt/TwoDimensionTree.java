package Khoa_2nd_attempt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class TwoDimensionTree {
    // this is the 2 dimensiontree
    protected PlaceNode root;
    protected int size;

    public TwoDimensionTree() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public PlaceNode add(Place newPlace) {
        if (this.root == null) {
            // if the tree's root is currently null, we create the root
            this.root = new PlaceNode(null, newPlace); // Set root directly if tree is empty
            size++;
            return root;
        }

        // Otherwise, we invoke the addNewNode fucntion.
        return addNode(root, newPlace, 0);
    }

    // O(log(N))
    private PlaceNode addNode(PlaceNode node, Place newPlace, int depth) {
        // if (node == null) {
        // return new PlaceNode(null, newPlace);
        // }

        int currentDimensionCompare = depth % 2;
        // if currentDimensionCompare is 0 the program will compare x coordinate,
        // otherwise currentDimensionCompare = 1 ==> compare y.

        // GO LEFT
        if ((currentDimensionCompare == 0 && newPlace.x < node.data.x)
                || (currentDimensionCompare == 1 && newPlace.y < node.data.y)) {
            if (node.left == null) {
                node.left = new PlaceNode(node, newPlace);
                return node.left;
            } else {
                return addNode(node.left, newPlace, depth + 1);
            }

        } else {// GO RIGHT
            if (node.right == null) {
                node.right = new PlaceNode(node, newPlace);
                return node.right;
            } else {
                return addNode(node.right, newPlace, depth + 1);
            }
        }
    }

    public boolean editService(int x, int y, String[] newServices) {
        PlaceNode editedPlaceNode = this.find(x, y);
        if (editedPlaceNode != null) {
            return editedPlaceNode.data.editServiceList(newServices);
        }
        return false;
    }

    public PlaceNode find(int x, int y) {
        return findNode(this.root, x, y, 0);
    }

    private PlaceNode findNode(PlaceNode node, int x, int y, int depth) {
        if (node == null) {
            return null;// Can not find the node.
        }

        // check the current node is the node taht we want to find or not.
        if (node.data.x == x && node.data.y == y) {
            // return the node if we can find the node
            return node;
        }

        int currentDimensionCompare = depth % 2;
        // this variable decide the road (go right or go left)

        // GO LEFT
        if ((currentDimensionCompare == 0 && x < node.data.x)
                || (currentDimensionCompare == 1 && y < node.data.y)) {
            return findNode(node.left, x, y, depth + 1); // Go left

        } else {// GO RIGHT
            return findNode(node.right, x, y, depth + 1);
        }
    }

    public List<PlaceNode> searchNearest(int x, int y, int walking, String service) {
        List<PlaceNode> result = new ArrayList<>();
        searchNearestNode(x, y, this.root, 0, walking, service, result);
        return result;
    }

    // Recursive method to traverse the tree and collect nodes
    private void searchNearestNode(int x, int y, PlaceNode root, int depth, int walking, String service,
            List<PlaceNode> result) {
        if (root == null) {
            return;
        }

        int currentDimensionCompare = depth % 2;
        PlaceNode nextBranch, otherBranch;

        if ((currentDimensionCompare == 0 && x < root.data.x) || (currentDimensionCompare == 1 && y < root.data.y)) {
            nextBranch = root.left;
            otherBranch = root.right;
        } else {
            nextBranch = root.right;
            otherBranch = root.left;
        }

        // Traverse down the next branch first
        searchNearestNode(x, y, nextBranch, depth + 1, walking, service, result);

        // Check current root for service availability and distance
        if (root.data.findService(service) && distance(root.data.x, root.data.y, x, y) <= walking) {
            result.add(root);
        }
        //new code
        double radiusSquare = (double) walking * walking;
        double axisDistanceSquared;
        if (currentDimensionCompare == 0) {
            // We are splitting on x-axis
            axisDistanceSquared = (x - root.data.x) * (x - root.data.x);
        } else {
            // We are splitting on y-axis
            axisDistanceSquared = (y - root.data.y) * (y - root.data.y);
        }

        if (axisDistanceSquared <= radiusSquare) {
            searchNearestNode(x, y, otherBranch, depth + 1, walking, service, result);
        }

        // Possibly search the other branch if close enough to have potential nodes
        // double radiusSquare = (double) walking * walking;
        // if (distSquared(x, y, root.data.x, root.data.y) <= radiusSquare) {
        // searchNearestNode(x, y, otherBranch, depth + 1, walking, service, result);
        // }
    }

    private PlaceNode closest(PlaceNode n0, PlaceNode n1, int x, int y, int walking, String service) {
        PlaceNode bestNode = null;
        if (n0 != null && n0.data.findService(service) && distance(n0.data.x, n0.data.y, x, y) <= walking) {
            bestNode = n0;
        }
        if (n1 != null && n1.data.findService(service) && distance(n1.data.x, n1.data.y, x, y) <= walking) {
            if (bestNode == null
                    || distance(n1.data.x, n1.data.y, x, y) < distance(bestNode.data.x, bestNode.data.y, x, y)) {
                bestNode = n1;
            }
        }
        return bestNode;
    }

    private double distSquared(int x1, int y1, int x2, int y2) {
        int deltaX = x1 - x2;
        int deltaY = y1 - y2;
        return deltaX * deltaX + deltaY * deltaY;
    }

    // Helper method to calculate distance
    private double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(distSquared(x1, y1, x2, y2));
    }

    public void printBreadthFirst() {
        breadthFirstTraversal(this.root);
    }

    private void breadthFirstTraversal(PlaceNode root) {
        if (root == null) {
            return;
        }

        Queue<PlaceNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            PlaceNode current = queue.poll();

            // Visit the node
            System.out.println("Visited node: " + current.data.toString());

            // Enqueue left child
            if (current.left != null) {
                queue.add(current.left);
            }

            // Enqueue right child
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // this function use to insert the place node into the tree
    // return the new added node or null (if the place's coordinate already exists).
    // public PlaceNode add(Place place) {
    // if (this.root == null) {
    // // if the the tree doesn't have the root (the first insert of the tree)
    // this.root = new PlaceNode(null, place);
    // size++;
    // return root;
    // }

    // // in the normal case
    // PlaceNode temp = this.root;// go from the root we define the position for the
    // new node
    // int depth = 0;// initially, the depth is 0. We use depth to decide the
    // variable (x or y) to
    // // compare
    // while (temp != null) {
    // if (depth % 2 == 0) {// compare x coordinate
    // if (place.x < temp.data.x) {
    // // go left
    // if (temp.left == null) {
    // // right position to insert new node
    // PlaceNode newNode = new PlaceNode(temp, place);
    // temp.left = newNode;
    // size++;
    // return newNode;
    // }
    // temp = temp.right;// go to right
    // } else {// go right
    // if (temp.right == null) {
    // // appropriate position to insert new node
    // PlaceNode newNode = new PlaceNode(temp, place);
    // temp.right = newNode;
    // size++;
    // return newNode;
    // }
    // }
    // } else {// compare y coordinate
    // if (place.y < temp.data.y) {
    // // go left
    // if (temp.left == null) {
    // // right position to insert new node
    // PlaceNode newNode = new PlaceNode(temp, place);
    // temp.left = newNode;
    // size++;
    // return newNode;
    // }
    // temp = temp.right;// go to right
    // } else {// go right
    // if (temp.right == null) {
    // // appropriate position to insert new node
    // PlaceNode newNode = new PlaceNode(temp, place);
    // temp.right = newNode;
    // size++;
    // return newNode;
    // }
    // }
    // }
    // }

    // return null;
    // }

}
