package com.mitong.test.exam;

import java.util.*;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15/8/11
 */
public class Exam1 {
    private static Map<Integer, Set<Integer>> know = new HashMap<Integer, Set<Integer>>();
    private static Map<Integer, Set<Integer>> known = new HashMap<Integer, Set<Integer>>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int groupCount = scanner.nextInt();
            for(int i = 0; i < groupCount; i++) {
                int peopleCount = scanner.nextInt();
                int relationCount = scanner.nextInt();
                for(int j = 0; j < relationCount; j++) {
                    int knowPeople = scanner.nextInt();
                    int knownPeople = scanner.nextInt();
                    if(knowPeople == knownPeople) {
                        continue;
                    }
                    if(know.get(knowPeople) != null) {
                        Set<Integer> newSet = know.get(knowPeople);
                        newSet.add(knownPeople);
                        know.put(knowPeople, newSet);
                    } else {
                        Set<Integer> newSet = new HashSet<Integer>();
                        newSet.add(knownPeople);
                        know.put(knowPeople, newSet);
                    }
                    if(known.get(knownPeople) != null) {
                        Set<Integer> newSet = known.get(knownPeople);
                        newSet.add(knowPeople);
                        known.put(knownPeople, newSet);
                    } else {
                        Set<Integer> newSet = new HashSet<Integer>();
                        newSet.add(knowPeople);
                        known.put(knownPeople, newSet);
                    }
                }
                List<Integer> resultList = new ArrayList<Integer>();
                for(int k = 1; k <= peopleCount; k++) {
                    if(know.get(k) == null && known.get(k) != null
                            && known.get(k).size() == peopleCount - 1) {
                        resultList.add(k);
                    }
                }
                System.out.println(resultList.size());
                if(resultList.size() == 0) {
                    System.out.println();
                } else {
                    for(int k = 0; k < resultList.size(); k++) {
                        if(k == resultList.size()-1) {
                            System.out.println(resultList.get(k));
                        } else {
                            System.out.println(resultList.get(k) + " ");
                        }
                    }
                }
                know.clear();
                known.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
