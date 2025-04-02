package Homework3;

import java.util.Stack;

public class KSmaller {


//    private int[] H = {
//                 6,
//                7,8,
//            10,11,9,10,
//           11
//    }; // min heap

    private int[] H = {
            1//,20,4,31,25,5
    };

    private int numRuns = 0;


    /**
     * utilize a stack to consider only the subtrees that could potentially
     * have something smaller than x.
     * if [child] > x, all of its children will be > x, so don't even consider
     * those subtrees.
     * if we run out of items in the stack to check, immediately stop.
     * this will keep the algorithm from running through all n items in heap.
     * if the stack is empty, it essentially implies that there are no
     * more nodes/subtree roots left to even consider, so all we care about is
     * if k <= 0 at that point.
     * loop is controlled by k falling below 0 => immediately stop if k = 0,
     * that means we have at least k elements smaller than x.
     * return if k <= .
     * @param k the number of elements we are trying to see are smaller than x
     * @param x the target value
     * @return if there are k smaller elements than x
     */
    public boolean areKSmallerElements(int k, int x) {
        int n = H.length;
        if (n < 1) {return false;}
        Stack<Integer> s = new Stack<>();
        int currRoot = 0; int lChild, rChild;

        while (k > 0) {
            numRuns++; // testing only
            if (H[currRoot] < x) {
                k--;
            } // end if

            lChild = 2 * currRoot + 1; rChild = 2 * currRoot + 2;
            if (lChild < n && H[lChild] < x) {
                s.push(lChild);
            } // end if

            if (rChild < n && H[rChild] < x) {
                s.push(rChild);
            } // end if

            if (s.isEmpty()) {
                break;
            } // end if
            currRoot = s.pop();
        }

        System.out.println("number of runs of algo: " + numRuns);
        return k <= 0;
    }

    public boolean test(int[] H, int parentI, int numSmaller, int target) {
        numRuns++; // testing
        if (numSmaller <= 0) { return true; }
//        if (H[parentI] >= target) {
//            return false;
//        } else {
//            numSmaller--; System.out.println(numSmaller);
//        } // end if

        numSmaller--; System.out.println(numSmaller);

        int lChildI = 2 * parentI + 1;
        int rChildI = 2 * parentI + 2;
        boolean found = false;

        if (lChildI < H.length && H[lChildI] < target) {
//            System.out.println(H[lChildI]);
            found = test(H, lChildI, numSmaller, target);
            if (found) { return true; }
            else {
                if (rChildI < H.length && H[rChildI] < target) {
                    found = test(H, rChildI, numSmaller, target);
                }
            }
        }

//        if (lChildI < H.length && H[lChildI] < target) {
////            System.out.println(H[lChildI]);
//            found = test(H, lChildI, --numSmaller, target);
//            if (found) { return true; }
//            else {
//                if (rChildI < H.length && H[rChildI] < target) {
//                    found = test(H, rChildI, --numSmaller, target);
//                }
//            }
//        }

        return found;
    }


}
