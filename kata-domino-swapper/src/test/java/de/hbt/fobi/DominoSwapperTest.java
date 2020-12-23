package de.hbt.fobi;


import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DominoSwapperTest {

    @Test
    void shouldReturnCorrectRotationCount() {
        //given
        int[] A = {2,1,2,4,2,2};
        int[] B = {5,2,6,2,3,2};

        DominoSwapper ds = new DominoSwapper();

        //when
        int result = ds.minDominoRotations(A, B);

        //then
        assertThat(result).isEqualTo(2);

    }
}