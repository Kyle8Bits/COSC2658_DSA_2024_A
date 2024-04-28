package testFunction;

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

    public PlaceNode build(Place[] places) {
        return this.root = buildTree(places, 0, places.length - 1, 0, null);
    }

    private PlaceNode buildTree(Place[] places, int left, int right, int depth, PlaceNode parent) {
        if (left > right) {
            return null;
        }

        // if currentDimensionCompare is 0 the program will compare x coordinate,
        // otherwise currentDimensionCompare = 1
        int currentDimensionCompare = depth % 2;

        // Sort array segment based on the dimension we compare
        sortPlace(places, left, right, currentDimensionCompare);

        // find the median index
        int mid = (left + right) / 2;

        // Create a new node
        PlaceNode node = new PlaceNode(parent, places[mid]);

        // Recursively build the left and right subtrees
        node.left = buildTree(places, left, mid - 1, depth + 1, node);
        node.right = buildTree(places, mid + 1, right, depth + 1, node);

        return node;
    }

    private void sortPlace(Place[] places, int left, int right, int dimensionCompare) {
        // this is quicksort
        if (left < right) {
            int p = partition(places, left, right, dimensionCompare);
            sortPlace(places, left, p, dimensionCompare);
            sortPlace(places, p + 1, right, dimensionCompare);
        }
    }

    private int partition(Place[] places, int left, int right, int dimensionCompare) {
        Place p = places[(left + right) / 2]; // Choose middle element as pivot to avoid worst-case on sorted arrays
        int front = left;
        int back = right;
        while (true) {
            while ((dimensionCompare == 0 && places[front].x < p.x)
                    || (dimensionCompare == 1 && places[front].y < p.y)) {

                front++;
            }

            while ((dimensionCompare == 0 && places[back].x > p.x)
                    || (dimensionCompare == 1 && places[back].y > p.y)) {
                back--;
            }
            if (front >= back) {
                return back;
            }
            // swapping
            Place tempPlace = places[front];
            places[front] = places[back];
            places[back] = tempPlace;
            front++;
            back--;
        }
    }

    public boolean isBalanced() {
        return checkBalance(this.root) != -1;
    }

    private int checkBalance(PlaceNode placeNode) {
        if (placeNode == null) {
            return 0; // Height of an empty tree
        }

        int leftHeight = checkBalance(placeNode.left);
        if (leftHeight == -1) {
            return -1; // Left subtree is not balanced
        }

        int rightHeight = checkBalance(placeNode.right);

        if (rightHeight == -1) {
            return -1; // Right subtree is not balanced
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node is not balanced
        }

        return Math.max(leftHeight, rightHeight) + 1; // Return the height of the tree rooted at this node
    }
    // public PlaceNode add(Place newPlace) {
    // if (this.root == null) {
    // // if the tree's root is currently null, we create the root
    // this.root = new PlaceNode(null, newPlace); // Set root directly if tree is
    // empty
    // size++;
    // return root;
    // }

    // // Otherwise, we invoke the addNewNode fucntion.
    // return addNode(root, newPlace, 0);
    // }

    // g(N))
    // ate PlaceNode addNode(PlaceNode node, Place newPlace, int depth) {
    // // if (node == null) {
    // // return new PlaceNode(null, newPlace);
    // // }

    // int currentDimensionCompare = depth % 2;
    // // if currentDimensionCompare is 0 the program will compare x coordinate,
    // // otherwise currentDimensionCompare = 1 ==> compare y.

    // FT
    // (currentDimensionCompare == 0 && newPlace.x < node.data.x)
    // || (currentDimensionCompare == 1 && newPlace.y < node.data.y)) {
    // node.left == null) {
    // node.left = new PlaceNode(node, newPlace);
    // return node.left;
    // } else {
    // return addNode(node.left, newPlace, depth + 1);
    // }

    // // GO RIGHT
    // node.right == null) {
    // node.right = new PlaceNode(node, newPlace);
    // return node.right;
    // } else {
    // return addNode(node.right, newPlace, depth + 1);
    // }
    // }
    // }

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

    public boolean remove(int x, int y) {
        PlaceNode nodeToDelete = find(x, y);
        if (nodeToDelete == null) {
            return false; // Node with the given coordinates not found
        }
        root = removeNode(root, x, y, 0);
        size--;
        return true;
    }
    
    private PlaceNode removeNode(PlaceNode node, int x, int y, int depth) {
        if (node == null) {
            return null;
        }
    
        int cd = depth % 2; // Current dimension
    
        if (node.data.x == x && node.data.y == y) {
            // Node found. Perform deletion.
    
            if (node.right != null) {
                // Find minimum in the right subtree and replace node with it
                PlaceNode min = findMin(node.right, cd, depth + 1);
                node.data = min.data;
                node.right = removeNode(node.right, min.data.x, min.data.y, depth + 1);
            } else if (node.left != null) {
                // Find minimum in the left subtree and replace node with it
                PlaceNode min = findMin(node.left, cd, depth + 1);
                node.data = min.data;
                node.right = removeNode(node.left, min.data.x, min.data.y, depth + 1);
                node.left = null; // Clear left child after moving to right
            } else {
                // Node is a leaf
                return null;
            }
        } else if ((cd == 0 && x < node.data.x) || (cd == 1 && y < node.data.y)) {
            node.left = removeNode(node.left, x, y, depth + 1);
        } else {
            node.right = removeNode(node.right, x, y, depth + 1);
        }
    
        return node;
    }
    
    private PlaceNode findMin(PlaceNode node, int d, int depth) {
        if (node == null) {
            return null;
        }
    
        int cd = depth % 2;
    
        // Only check the dimension d for minimum if it matches the current depth dimension
        if (cd == d) {
            if (node.left == null) {
                return node;
            } else {
                return minNode(node, findMin(node.left, d, depth + 1), d);
            }
        } else {
            return minNode(node,
                           minNode(findMin(node.left, d, depth + 1), findMin(node.right, d, depth + 1), d),
                           d);
        }
    }
    
    private PlaceNode minNode(PlaceNode a, PlaceNode b, int d) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (d == 0) {
            return (a.data.x < b.data.x) ? a : b;
        } else {
            return (a.data.y < b.data.y) ? a : b;
        }
    }

    public PlaceList search(int x, int y, int walking, String service) {
        // x y is users' current location.
        PlaceList result = new PlaceList();
        searchNodes(x, y, this.root, 0, walking, service, result);
        return result;
    }

    // Recursive method to traverse the tree and collect nodes
    private void searchNodes(int x, int y, PlaceNode root, int depth, int walking, String service,
            PlaceList result) {
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
        searchNodes(x, y, nextBranch, depth + 1, walking, service, result);

        // Check current root for service availability and distance
        if (root.data.findService(service) && distance(root.data.x, root.data.y, x, y) <= walking
                && result.getSize() < 50) {
            result.insert(root.data);
        }
        // new code
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
            searchNodes(x, y, otherBranch, depth + 1, walking, service, result);
        }

        // Possibly search the other branch if close enough to have potential nodes
        // double radiusSquare = (double) walking * walking;
        // if (distSquared(x, y, root.data.x, root.data.y) <= radiusSquare) {
        // searchNearestNode(x, y, otherBranch, depth + 1, walking, service, result);
        // }
    }

    private double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(distSquared(x1, y1, x2, y2));
    }

    private double distSquared(int x1, int y1, int x2, int y2) {
        int deltaX = x1 - x2;
        int deltaY = y1 - y2;
        return deltaX * deltaX + deltaY * deltaY;
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

}
