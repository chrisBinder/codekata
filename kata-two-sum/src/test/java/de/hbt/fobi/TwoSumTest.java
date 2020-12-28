package de.hbt.fobi;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TwoSumTest {


    @DataProvider
    public static Object[][] testcases() {
        return new Object[][]{
                {
                        new int[]{2,7,11,15},
                        9,
                        new int[]{0,1},
                },
                {
                        new int[]{7,11,15,2},
                        9,
                        new int[]{0,3},
                },
                {
                        new int[]{3,3},
                        6,
                        new int[]{0,1},
                },
                {
                        new int[]{3,2,4},
                        6,
                        new int[]{1,2},
                },
                {
                        new int[]{1,2,3,4},
                        9,
                        new int[]{},
                },
        };
    }

    @Test(dataProvider = "testcases")
    void test1(int[] nums, int target, int[] output) {
        //given

        //when
        TwoSum ts = new TwoSum();
        int[] solution = ts.solution(nums, target);
        //then
        Assertions.assertThat(solution).isEqualTo(output);
    }
}