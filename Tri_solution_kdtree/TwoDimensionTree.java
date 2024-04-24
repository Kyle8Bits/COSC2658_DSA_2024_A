package Tri_solution_kdtree;

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

    public PlaceNode remove(int x, int y) {
        return removeNode(this.root, x, y, 0);
    }

    private PlaceNode removeNode(PlaceNode node, int x, int y, int depth) {
        if (node == null) {
            return null; // Node not found.
        }

        if (node.data.x == x && node.data.y == y) {
            // Case 1: Node has no children
            if (node.left == null && node.right == null) {
                if (node.parent != null) {
                    if (node.parent.left == node) {
                        node.parent.left = null;
                    } else {
                        node.parent.right = null;
                    }
                } else {
                    this.root = null;
                }
                return node;
            }

            // Case 2: Node has one child
            if (node.left == null) {
                PlaceNode child = node.right;
                replaceNode(node, child);
                return node;
            } else if (node.right == null) {
                PlaceNode child = node.left;
                replaceNode(node, child);
                return node;
            }

            // Case 3: Node has two children
            if (node.left != null && node.right != null) {
                return removeNodeWithTwoChildren(node);
            }
        }

        int currentDimensionCompare = depth % 2;

        if ((currentDimensionCompare == 0 && x < node.data.x)
                || (currentDimensionCompare == 1 && y < node.data.y)) {
            return removeNode(node.left, x, y, depth + 1); // Go left
        } else {
            return removeNode(node.right, x, y, depth + 1); // Go right
        }
    }

    private void replaceNode(PlaceNode oldNode, PlaceNode newNode) {
        if (oldNode.parent != null) {
            if (oldNode.parent.left == oldNode) {
                oldNode.parent.left = newNode;
            } else {
                oldNode.parent.right = newNode;
            }
        } else {
            this.root = newNode;
        }
        if (newNode != null) {
            newNode.parent = oldNode.parent;
        }
    }

    private PlaceNode findInOrderSuccessor(PlaceNode node) {
        // Find the leftmost node in the right subtree
        PlaceNode current = node.right;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private PlaceNode removeNodeWithTwoChildren(PlaceNode node) {
        // Find the in-order successor (or predecessor)
        PlaceNode inOrderSuccessor = findInOrderSuccessor(node);
    
        // Replace the data of the node to be removed with the data of the in-order successor
        node.data = inOrderSuccessor.data;
    
        // Recursively remove the in-order successor from its original position
        return removeNode(node.right, inOrderSuccessor.data.x, inOrderSuccessor.data.y, 0);
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
