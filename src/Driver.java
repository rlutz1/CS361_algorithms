import Homework3.KSmaller;
import Homework3.OutDegeeInDegree;

public class Driver {

    public static void main(String[] args) {
        // run anything here.
        OutDegeeInDegree oi = new OutDegeeInDegree();
        oi.genGraph();
        oi.evenInOutDegree();
        // todo, test this more

    }

}

//KSmaller ks = new KSmaller();
//System.out.println(ks.areKSmallerElements(4, 32));
