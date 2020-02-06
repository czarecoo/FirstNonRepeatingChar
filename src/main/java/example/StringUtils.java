package example;

import java.util.*;

/**
 * Amazon interview question https://www.youtube.com/watch?v=5co5Gvp_-S0
 * <p>
 * The problem:
 * Find first not duplicated character in given string (1-100_000 characters, from a-z). For null or empty input or no duplicated char return null.
 * <p>
 * examples:
 * abc -> a
 * aabbccd -> d
 * abcabcabc -> null
 * aaabccccdeeef -> b
 */
public final class StringUtils {
    private StringUtils() {
    }

    /**
     * The correct answer for the problem.
     */
    public static String getFirstNotDuplicatedChar(String input) {
        Objects.requireNonNull(input, "input should not be null");
        if (input.isEmpty()) {
            return null;
        }
        for (char c : input.toCharArray()) {
            if (input.indexOf(c) == input.lastIndexOf(c)) {
                return String.valueOf(c);
            }
        }
        return null;
    }

    /**
     * Solution proposed by Adam. Seems as its the most optimised, since the array of chars is traversed only once.
     * The problem here is the use of 2 arrays. Maybe if we could create appropriate sizes it would be not bad?
     */
    public static String getFirstNotDuplicatedCharSolutionBasedOnAdamsIdea(String input) {
        Objects.requireNonNull(input, "input should not be null");
        if (input.isEmpty()) {
            return null;
        }
        List<Character> candidates = new ArrayList<>();
        Set<Character> excludes = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (candidates.contains(c)) {
                excludes.add(candidates.remove(candidates.indexOf(Character.valueOf(c))));
            } else if (!excludes.contains(c)) {
                candidates.add(c);
            }
        }
        if (candidates.isEmpty()) {
            return null;
        } else {
            return candidates.get(0).toString();
        }
    }

    /**
     * Solution proposed by me. Its easy to understand but not so optimized since array has to be traversed twice.
     */
    public static String getFirstNotDuplicatedCharMySolution(String input) {
        Objects.requireNonNull(input, "input should not be null");
        if (input.isEmpty()) {
            return null;
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : input.toCharArray()) {
            Integer count = map.get(c);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            map.put(c, count);
        }

        Optional<Character> c = map.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
        if (c.isPresent()) {
            return c.get().toString();
        } else {
            return null;
        }
    }
}
