package de.hbt.fobi;


public class DominoSwapper {

  public int minDominoRotations (int[] A, int[] B) {

    int[] countA = new int[7];
    int[] countB = new int[7];
    int[] countSame = new int[7];

    for (int i = 0; i < A.length; i++) {
      ++countA[A[i]];
      ++countB[B[i]];
      if (A[i] == B[i]) {
        ++countSame[A[i]];
      }
    }

    int ans =  A.length;

    for (int i = 1; i <= 6; i++) {
      if (countA[i] + countB[i] - countSame[i] == A.length) {
        int min = Math.min (countA[i], countB[i]) - countSame[i];
        ans = Math.min (ans, min);
      }
    }

    return ans == A.length ? -1 : ans;
  }
}
