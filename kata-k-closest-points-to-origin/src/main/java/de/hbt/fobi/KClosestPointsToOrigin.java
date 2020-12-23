package de.hbt.fobi;


import java.util.Arrays;
import java.util.Comparator;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingDouble(left -> left[0] * left[0] + left[1] * left[1]));
        return Arrays.copyOf(points, K);
    }

}
