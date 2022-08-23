package study.spring.algorithm.programmers;

import java.util.*;
import java.util.Map.Entry;

class Solution {

  HashMap<String, Integer> map;
  boolean[] visits;
  String[] order;

  public String[] solution(String[] orders, int[] course) {
    visits = new boolean[orders.length];
    List<String> list = new ArrayList<>();

    for (int i=0; i<orders.length; i++) {

      String[] split = orders[i].split("");
      Arrays.sort(split);

      orders[i] = Arrays.toString(split);
      System.out.println(orders[i]);
    }

    for (int size : course) {
      map = new HashMap<>();

      for (String str : orders) {
        order = str.split("");
        checkCourseMenu(0,0, size, ""); // 모든 경우의 수를 뽑아내는 메소드 구현(재귀)
      }

      // map에 저장된 값들 중 최대값을 찾아 키값을 따로 저장하는 로직 구현 실패

      int max = 0;

      for (Entry<String, Integer> entry : map.entrySet()) {
        max = Math.max(max, entry.getValue());
      }

      for(Entry<String,Integer> entry : map.entrySet()){
        if(max >=2 && entry.getValue() == max)
          list.add(entry.getKey());
      }
    }

    Collections.sort(list);
    System.out.println(list);

    String[] answer = new String[list.size()];

    for (int i=0; i<list.size(); i++) {
      answer[i] = list.get(i);
    }

    return answer;
  }

  public void checkCourseMenu(int sp, int depth, int size, String menu) {

    if (depth == size) {

      // getOrDefault 값 활용법

      // map.put(menu, map.getOrDefault(menu, 1) + 1);

      if (map.get(menu) != null && map.get(menu) >= 1) {
        map.put(menu, map.get(menu) + 1);
      } else {
        map.put(menu, 1);
      }

      return;
    }

    for (int i=0; i< order.length; i++) {

      if (!visits[i]) {
        visits[i] = true;
        checkCourseMenu(sp, depth + 1, size, menu.concat(order[i]));
        visits[i] = false;
      }
      sp++;
    }
  }
}