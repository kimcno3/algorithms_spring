package study.spring.algorithm.programmers;

import java.util.*;

public class Question {

  Map<String, List<Integer>> map = new HashMap<>();

  public int[] solution(String[] info, String[] query) {
    int[] answer = new int[query.length];

    for(String str : info) {

      // 중복
      String[] arr = str.split(" ");
      int score = Integer.parseInt(arr[arr.length-1]);

      makeKey(arr, 0, "", score);
    }

    for (List<Integer> list : map.values()) {
      Collections.sort(list); //
    }

    for (int i=0; i< query.length; i++) {

      String[] arr = query[i].split(" ");
      int score = Integer.parseInt(arr[arr.length-1]);

      String key = findKey(arr);

      List<Integer> list = map.getOrDefault(key, new ArrayList<>());

      int idx = binarySearch(list, score); // 다시 한번 봐보기

      if (idx == -1) {
        idx = list.size();
      }

      answer[i] = list.size() - idx;

    }

    return answer;
  }

  public void makeKey(String[] arr, int depth, String key, int score) {

    if (depth == arr.length-1) {

      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }

      map.get(key).add(score);

      return;

    }
    makeKey(arr, depth+1, key + arr[depth], score);
    makeKey(arr, depth+1, key + "-", score);
  }

  public String findKey(String[] arr) {

    String key = "";
    for (int i=0; i<arr.length; i+=2) {
      key += arr[i];
    }

    return key;
  }

  public int binarySearch(List<Integer> list, int score) {
    int low = 0;
    int high = list.size()-1;
    int result = -1;

    while(low <= high) {

      int mid = (high + low) / 2;
      int midScore = list.get(mid);

      if (midScore < score) {
        low = mid + 1;
      } else {
        result = mid; // !!
        high = mid - 1;
      }
    }

    return result;
  }
}
