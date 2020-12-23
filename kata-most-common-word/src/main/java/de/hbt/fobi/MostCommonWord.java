package de.hbt.fobi;


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MostCommonWord {

    public String solution(String paragraph, String[] banned) {
        Set<String> bannedLookUp = Arrays.stream(banned).collect(Collectors.toSet());

        String loPara = paragraph.toLowerCase();
        String[] splitted = loPara.split("\\W+");
        List<String> sorted = Arrays.stream(splitted)
                .filter(dings -> !bannedLookUp.contains(dings))
                .sorted()
                .collect(Collectors.toList());

        String prev = sorted.get(0);
        int currCount = 0;
        int currMax = 0;
        String result = prev;
        for (int i = 0; i < sorted.size(); i++) {
            String s = sorted.get(i);
            if (!prev.equals(s) || i == sorted.size()-1) {
                if (currMax <= currCount) {
                    //new Max
                    result = prev;
                    currMax = currCount;
                }
                currCount = 0;
            }
            currCount++;
            prev = s;
        }

        return result;
    }

    public String solution2(String paragraph, String[] banned) {
        Set<String> bannedLookUp = Arrays.stream(banned).collect(Collectors.toSet());

        String loPara = paragraph.toLowerCase();
        String[] splitted = loPara.split("\\W+");
        List<String> sorted = Arrays.stream(splitted)
                .filter(dings -> !bannedLookUp.contains(dings))
                .sorted()
                .collect(Collectors.toList());

        String prev = sorted.get(0);
        int currCount = 0;
        int currMax = 0;
        String result = prev;
        for (int i = 0; i < sorted.size(); i++) {
            String s = sorted.get(i);
            if (!prev.equals(s) || i == sorted.size()-1) {
                if (currMax <= currCount) {
                    //new Max
                    result = prev;
                    currMax = currCount;
                }
                currCount = 0;
            }
            currCount++;
            prev = s;
        }

        return result;
    }

}
