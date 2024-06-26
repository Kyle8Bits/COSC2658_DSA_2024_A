public class TwoDimensionTree {
    // this is the 2 dimensiontree
    protected PlaceNode root;

    // set up the evaluate
    public static int visitedNode = 0;

    public TwoDimensionTree() {
        this.root = null;
    }

    public int size() {
        if (this.root != null) {
            return this.root.subtreeNodes;
        }

        return 0;
    }

    //Time complexity: O(N(logN)^2)
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

        if (node.left != null) {
            node.subtreeNodes += node.left.subtreeNodes;
        }
        if (node.right != null) {
            node.subtreeNodes += node.right.subtreeNodes;
        }

        return node;
    }

    //time complexity for average case: O(NlogN)
    private void sortPlace(Place[] places, int left, int right, int dimensionCompare) {
        // this is quicksort
        if (left < right) {
            int p = partition(places, left, right, dimensionCompare);
            sortPlace(places, left, p, dimensionCompare);
            sortPlace(places, p + 1, right, dimensionCompare);
        }
    }

    private int partition(Place[] places, int left, int right, int dimensionCompare) {
        // int middle = (right - left) / 2;
        Place p = places[left];
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

    // Time complexity: O(N + k), k is the number of new services
    public boolean editService(int x, int y, String[] newServices) {
        PlaceNode editedPlaceNode = this.find(x, y);
        if (editedPlaceNode != null) {
            return editedPlaceNode.data.editServiceList(newServices);
        }
        return false;
    }

    // Time complexity: O(logN)
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

    // Time complexity: O(N)
    public boolean remove(int x, int y) {
        PlaceNode nodeToDelete = find(x, y);
        if (nodeToDelete == null) {
            return false; // Node with the given coordinates not found
        }
        root = removeNode(root, x, y, 0);
        return true;
    }

    // Time complexity: O(N)
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

    // Finds the node with the minimum value in the k-d tree for the specified dimension.
    private PlaceNode findMin(PlaceNode node, int d, int depth) {
        if (node == null) {
            return null;
        }

        int cd = depth % 2;

        // Only check the dimension d for minimum if it matches the current depth
        // dimension
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

    // Compares two nodes and returns the one with the minimum value in the specified dimension.
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

    public PlaceList search(int x, int y, int half_width, int half_height, String service) {
        
        // x y is users' current location.
        PlaceList result = new PlaceList();
        searchNodes(x, y, this.root, 0, half_width, half_height, service, result);

        System.out.println("The visited places: " + visitedNode);
        visitedNode = 0;
        return result;
    }

    // Recursive method to traverse the tree and collect nodes
    private void searchNodes(int x, int y, PlaceNode root, int depth, int half_width, int half_height, String service,
            PlaceList result) {
        if (root == null) {
            return;
        }
        //increase the visit node every time it recursive back
        visitedNode++;

        // get the curretn level
        int currentDimensionCompare = depth % 2;
        PlaceNode nextBranch, otherBranch;

        //compare the coordinate based on the current level
        if ((currentDimensionCompare == 0 && x < root.data.x) || (currentDimensionCompare == 1 && y < root.data.y)) {
            nextBranch = root.left;
            otherBranch = root.right;
        } else {
            nextBranch = root.right;
            otherBranch = root.left;
        }

        // Traverse down the next branch first
        if (result.getSize() < 50) {
            searchNodes(x, y, nextBranch, depth + 1, half_width, half_height, service, result);
        }

        // Check current root for service availability and distance
        if (root.data.findService(service) && checkWithinRectangle(x, y, half_width, half_height, root)
                && result.getSize() < 50) {
            result.insert(root.data, x, y);
        }
        //go back the skipped branch and check if it within the rectangle
        if (checkOtherBranch(x, y, root, half_width, half_height, currentDimensionCompare)) {
            searchNodes(x, y, otherBranch, depth + 1, half_width, half_height, service, result);
        }
    }

    private boolean checkOtherBranch(int x, int y, PlaceNode root, int half_width, int half_height, int depth) {
        //check the x and y coordinate based on level with the devide line of the bounding rectangle
        if (depth == 0) {
            return Math.abs(x - root.data.x) <= half_width;
        } else {
            return Math.abs(y - root.data.y) <= half_height;
        }
    }

    private boolean checkWithinRectangle(int x, int y, int half_width, int half_height, PlaceNode place) {
        //create 4 bounding number based on the half-width and half-heigth length
        int bounding_x_right = x + half_width;
        int bounding_x_left = x - half_width;

        int bounding_y_top = y + half_height;
        int bounding_y_botom = y - half_height;
        //using the bouding number to see if the places is within
        if (bounding_x_left < place.data.x && place.data.x < bounding_x_right && bounding_y_botom < place.data.y
                && place.data.y < bounding_y_top) {
            return true;
        }

        return false;
    }

    public void inOrder() {
        this.inOrderRecursive(this.root);
    }

    private void inOrderRecursive(PlaceNode node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.println(node.data);
            inOrderRecursive(node.right);
        }

    }

}