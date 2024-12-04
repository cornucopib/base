package com.cornucopib.list;

import java.util.*;

// 11459 ms
public class TakeListIntersection {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        long initialMemory = runtime.totalMemory() - runtime.freeMemory();

        long start = System.currentTimeMillis();

        // Step 1: Generate four lists with a total size of 5000 random 17 or 19 digit strings
        List<String> list1 = generateRandomStringList(1250);
        List<String> list2 = generateRandomStringList(1250);
        List<String> list3 = generateRandomStringList(1250);
        List<String> list4 = generateRandomStringList(1250);

        // Combine all lists into one
        List<String> combinedList = new ArrayList<>(list1);
        combinedList.addAll(list2);
        combinedList.addAll(list3);
        combinedList.addAll(list4);

        // Step 2: Randomly select 4910 elements from the combined list to form list target
        List<String> target = getRandomElements(combinedList, 49100);

        // Step 3: Calculate the intersection of each list with target
        Set<String> intersection1 = new HashSet<>(list1);
        intersection1.retainAll(target);

        Set<String> intersection2 = new HashSet<>(list2);
        intersection2.retainAll(target);

        Set<String> intersection3 = new HashSet<>(list3);
        intersection3.retainAll(target);

        Set<String> intersection4 = new HashSet<>(list4);
        intersection4.retainAll(target);

        long end = System.currentTimeMillis();
        long finalMemory = runtime.totalMemory() - runtime.freeMemory();

        System.out.println("Time taken: " + (end - start) + " ms");
        System.out.println("Initial memory usage: " + (initialMemory / 1024) + " KB");
        System.out.println("Final memory usage: " + (finalMemory / 1024) + " KB");

        // Output the results
        System.out.println("Intersection of list1 and target: " + intersection1);
        System.out.println("Intersection of list2 and target: " + intersection2);
        System.out.println("Intersection of list3 and target: " + intersection3);
        System.out.println("Intersection of list4 and target: " + intersection4);
    }

    private static List<String> generateRandomStringList(int size) {
        List<String> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            boolean isSeventeenDigits = random.nextBoolean();
            String number;
            if (isSeventeenDigits) {
                number = String.format("%017d", 10000000000000000L + (long) (random.nextDouble() * 9000000000000000L));
            } else {
                number = String.format("%019d", 100000000000000000L + (long) (random.nextDouble() * 90000000000000000L));
            }
            list.add(number);
        }
        return list;
    }

    private static List<String> getRandomElements(List<String> list, int count) {
        Set<String> combined = new HashSet<>(list);

        // Shuffle the combined set and take the first 'count' elements
        List<String> result = new ArrayList<>(combined);
        Collections.shuffle(result);
        return result.subList(0, Math.min(count, result.size()));
    }
}
