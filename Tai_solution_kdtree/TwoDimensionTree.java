package Tai_solution_kdtree;

import java.util.LinkedList;
import java.util.Queue;

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
        return addNewNode(root, newPlace, 0);
    }

    private PlaceNode addNewNode(PlaceNode node, Place newPlace, int depth) {
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
                return addNewNode(node.left, newPlace, depth + 1);
            }

        } else {// GO RIGHT
            if (node.right == null) {
                node.right = new PlaceNode(node, newPlace);
                return node.right;
            } else {
                return addNewNode(node.right, newPlace, depth + 1);
            }
        }
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
