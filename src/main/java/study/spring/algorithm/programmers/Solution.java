package study.spring.algorithm.programmers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 문제 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/72412
 */

class Solution {

    public int[] solution(String[] info, String[] query) {

        // info 정보를 Map에 저장하기
        Map<String, LinkedList<Integer>> map = new HashMap<>();

        for (String str : info) {
            String[] split = str.split(" ");
            StringBuilder sb = new StringBuilder();
            sb.append(language(split[0]));
            sb.append(part(split[1]));
            sb.append(career(split[2]));
            sb.append(soulFood(split[3]));

            LinkedList<Integer> list = map.getOrDefault(sb.toString(), new LinkedList<>());
            list.offer(score(split[4]));
            map.put(sb.toString(), list);
        }
        // query를 하나씩 돌려가면서 개수를 찾아가기
        for (String q : query) {
            String[] split = q.split(" and ");
            StringBuilder sb = new StringBuilder();
            sb.append(language(split[0]));
            sb.append(part(split[1]));
            sb.append(career(split[2]));
            sb.append(soulFood(split[3].split(" ")[0]));

            String key = sb.toString();
            int score = score(split[3].split(" ")[1]);

            List<Integer> list = new ArrayList<>();

            map.entrySet().stream()
                    .filter((e) -> e.getKey().matches(key))
                    .forEach((e) -> list.addAll(e.getValue()));

            List<Integer> sortedList = list.stream()
                    .sorted()
                    .collect(Collectors.toList());

            // score 이상인 값을 찾아낸다.

        }


        // 그 과정에서 이진탐색 사용하기

        return null;
    }

    private String language(String lang) {
        switch(lang) {
            case "cpp" :
                return "C";
            case "java" :
                return "J";
            case "python" :
                return "P";
            default :
                return ".";
        }
    }

    private String part(String part) {
        switch(part) {
            case "backend" :
                return "B";
            case "frontend" :
                return "F";
            default :
                return ".";
        }
    }

    private String career(String career) {
        switch(career) {
            case "junior" :
                return "J";
            case "senior" :
                return "S";
            default :
                return ".";
        }
    }

    private String soulFood(String soulFood) {
        switch(soulFood) {
            case "chicken" :
                return "C";
            case "pizza" :
                return "P";
            default :
                return ".";
        }
    }

    private int score(String score) {
        return Integer.parseInt(score);
    }
}