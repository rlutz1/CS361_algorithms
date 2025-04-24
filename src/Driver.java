import Homework3.KSmaller;
import Homework3.OutDegeeInDegree;
import Homework4.LandWater;

public class Driver {

    public static void main(String[] args) {
        // run anything here.

        int[][] tester = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        LandWater lw = new LandWater();
        System.out.println(lw.howManyIslands(tester));

    }

}

//KSmaller ks = new KSmaller();
//System.out.println(ks.areKSmallerElements(4, 32));
