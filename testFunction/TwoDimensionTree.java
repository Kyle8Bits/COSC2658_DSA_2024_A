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
        PlaceNode nodeToRemove = find(x, y);
        if (nodeToRemove == null) {
            return false;
        }

        removeNode(nodeToRemove);
        return true;
    }

    private void removeNode(PlaceNode node) {
        if (node.left == null && node.right == null) {
            // Node is a leaf
            if (node.parent == null) {
                root = null; // node is root and has no children
            } else {
                PlaceNode parent = node.parent;
                if (parent.left == node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        } else {
            // Node is not a leaf
            if (node.right != null) {
                // Find minimum node from the right subtree (or maximum from the left subtree)
                PlaceNode minNode = findMin(node.right, 0, 1); // depth starts at 0, next dimension is 1
                node.data = minNode.data; // replace node data with minNode data
                removeNode(minNode); // recursively remove the minNode
            } else {
                // No right child, replace with left child (similar logic as above)
                PlaceNode minNode = findMin(node.left, 0, 1);
                node.data = minNode.data;
                removeNode(minNode);
            }
        }
    }

    private PlaceNode findMin(PlaceNode node, int depth, int dim) {
        if (node == null) {
            return null;
        }
        int currentDimension = depth % 2;
        if (currentDimension == dim) {
            if (node.left == null) {
                return node;
            } else {
                return findMin(node.left, depth + 1, dim);
            }
        } else {
            PlaceNode leftMin = findMin(node.left, depth + 1, dim);
            PlaceNode rightMin = findMin(node.right, depth + 1, dim);
            return minNode(node, minNode(leftMin, rightMin, dim), dim);
        }
    }

    private PlaceNode minNode(PlaceNode a, PlaceNode b, int dim) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if ((dim == 0 && a.data.x < b.data.x) || (dim == 1 && a.data.y < b.data.y)) {
            return a;
        } else {
            return b;
        }
    }

    public PlaceList search(int x, int y, int walking, String service) {
        // x y is users' current location.
        PlaceList result = new PlaceList();
        searchNodes(x, y, this.root, 0, half_width, half_height , service, result);
        return result;
    }

    // Recursive method to traverse the tree and collect nodes
    private void searchNodes(int x, int y, PlaceNode root, int depth, int half_width, int half_height, String service, PlaceList result) {
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
        searchNodes(x, y, nextBranch, depth + 1, half_width, half_width, service, result);

        // Check current root for service availability and distance
        if (root.data.findService(service) && checkWithinRectangle(x, y, half_width, half_height, root) && result.getSize() < 50) {
            result.insert(root.data);
        }
        // new code
        if(checkOtherBranch(x, y, root, half_width, half_height, currentDimensionCompare)){
            searchNodes(x, y, otherBranch, depth+1, half_width, half_height, service, result);
        }
    }

<<<<<<< HEAD
    private boolean checkOtherBranch(int x, int y, PlaceNode root, int half_width, int half_height, int depth){
        if(depth == 0){
            return Math.abs(x - root.data.x) <= half_width;
        }
        else{
            return Math.abs(y - root.data.y) <= half_height;
        }
    }

    private boolean checkWithinRectangle(int x, int y, int half_width, int half_height, PlaceNode place){
        int bounding_x_right = x + half_width;
        int bounding_x_left = x - half_width; 

        int bounding_y_top = y + half_height;
        int bounding_y_botom = y - half_height;
        
        if(bounding_x_left < place.data.x &&  place.data.x < bounding_x_right && bounding_y_botom < place.data.y && place.data.y < bounding_y_top){
            return true;
        }
        
        return false;
    }

=======
>>>>>>> 579cab0a589ea59901668bf4ed8699f06b3efca5
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
