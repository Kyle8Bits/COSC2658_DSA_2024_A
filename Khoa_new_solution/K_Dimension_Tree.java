package Khoa_new_solution;

public class K_Dimension_Tree {
    PlaceNode root;
    int k;

    public K_Dimension_Tree(int k){
        this.k = k;
        root = null;
    }

    // void insert(PlaceNode newPlace){
    //     if(root == null){   
    //         root = newPlace;
    //     }

    //     inserRec(root,newPlace , 0);
    // }

    // void inserRec(PlaceNode root, PlaceNode newPlace, int depth){
    //     int  dim = depth % 2; // Corrected to use 2 dimensions
    //     if(dim == 0){
    //         if(newPlace.place.x < root.place.x){
    //             if(root.left == null){
    //                 root.left = newPlace;
    //             }
    //             else{
    //                 inserRec(root.left, newPlace, depth + 1);
    //             }
    //         }
    //         else{
    //             if(root.right == null){
    //                 root.right = newPlace;
    //             }
    //             else{
    //                 inserRec(root.right, newPlace, depth + 1);
    //             }
    //         }
    //     }
    //     else{
    //         if(newPlace.place.y < root.place.y){
    //             if(root.left == null){
    //                 root.left = newPlace;
    //             }
    //             else{
    //                 inserRec(root.left, newPlace, depth + 1);
    //             }
    //         }
    //         else{
    //             if(root.right == null){
    //                 root.right = newPlace;
    //             }
    //             else{
    //                 inserRec(root.right, newPlace, depth + 1);
    //             }
    //         }
    //     }
    // }

    public PlaceNode add(Place newPlace) {
        if (this.root == null) {
            // if the tree's root is currently null, we create the root
            this.root = new PlaceNode(newPlace); // Set root directly if tree is empty
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
        if ((currentDimensionCompare == 0 && newPlace.x < node.place.x)
                || (currentDimensionCompare == 1 && newPlace.y < node.place.y)) {
            if (node.left == null) {
                node.left = new PlaceNode(newPlace);
                return node.left;
            } else {
                return addNode(node.left, newPlace, depth + 1);
            }

        } else {// GO RIGHT
            if (node.right == null) {
                node.right = new PlaceNode(newPlace);
                return node.right;
            } else {
                return addNode(node.right, newPlace, depth + 1);
            }
        }
    }

    

    public PlaceNode nearestRec(Place location, int depth, int walking) {
        return nearestHelper(this, location, root, depth, walking);
    }

    private PlaceNode nearestHelper(K_Dimension_Tree map, Place target, PlaceNode currentBest, int depth, int walking) {
        if (currentBest == null)
            return null;

        if (target.equals(currentBest.place))
            return null;

        int axis = depth % 2; // Assuming 2-dimensional KD-tree

        PlaceNode nextBranch;
        PlaceNode otherBranch;

        // Determine which subtree to search first
        if (axis == 0) {
            if (target.x < currentBest.place.x) {
                nextBranch = currentBest.left;
                otherBranch = currentBest.right;
            } else {
                nextBranch = currentBest.right;
                otherBranch = currentBest.left;
            }
        } else {
            if (target.y < currentBest.place.y) {
                nextBranch = currentBest.left;
                otherBranch = currentBest.right;
            } else {
                nextBranch = currentBest.right;
                otherBranch = currentBest.left;
            }
        }

        // Recursively search the chosen subtree
        PlaceNode closer = nearestHelper(map, target, nextBranch, depth + 1, walking);

        // Update current best if closer to the target
        if (closer != null && closer.place.distanceTo(target) < currentBest.place.distanceTo(target)) {
            currentBest = closer;
        }

        // Check whether we need to search the other subtree
        if (otherBranch != null) {
            // If the distance from target to the current best is greater
            // than or equal to the distance from the target to the
            // partitioning plane, it's possible that there could be
            // a closer point in the other subtree.
            if (axis == 0) {
                if (Math.abs(currentBest.place.x - target.x) <= walking) {
                    closer = nearestHelper(map, target, otherBranch, depth + 1, walking);
                }
            } else {
                if (Math.abs(currentBest.place.y - target.y) <= walking) {
                    closer = nearestHelper(map, target, otherBranch, depth + 1, walking);
                }
            }

            // Update current best if closer to the target
            if (closer != null && closer.place.distanceTo(target) < currentBest.place.distanceTo(target)) {
                currentBest = closer;
            }
        }

        return currentBest;
    }
}

class Place{
    String name;
    int x;
    int y;
    
    public Place(int x, int y, String name){
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Place other) {
        int deltaX = this.x - other.x;
        int deltaY = this.y - other.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

}

class PlaceNode{
    Place place;
    PlaceNode right, left;

    public PlaceNode(Place place){
        this.place = place;
        right = null;
        left = null;
    }
}


