package de.hbt.fobi;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class KClosestPointsToOriginTest {

    @Test
    void kClosest() {
        //when
        int[][] points = {{1, 3}, {-2, 2}};
        int K = 1;
        //given
        KClosestPointsToOrigin calculator = new KClosestPointsToOrigin();
        int[][] result = calculator.kClosest(points, K);
        //then
        int[][] expected = {{-2, 2}};
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void kClosest2() {
//        Input: points = [[3,3],[5,-1],[-2,4]], K = 2
//        Output: [[3,3],[-2,4]]
//        (The answer [[-2,4],[3,3]] would also be accepted.)


        //when
        int[][] points = {{3, 3}, {5, -1}, {-2,4}};
        int K = 2;
        //given
        KClosestPointsToOrigin calculator = new KClosestPointsToOrigin();
        int[][] result = calculator.kClosest(points, K);
        //then
        int[][] expected = {{3, 3}, {-2,4}};
        Assertions.assertThat(result).isEqualTo(expected);
    }
}