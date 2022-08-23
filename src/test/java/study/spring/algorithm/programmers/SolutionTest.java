package study.spring.algorithm.programmers;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

  Solution solution;

  @BeforeEach
  void init() {

  }

  @Test
  @DisplayName("테스트 1")
  void test1() {

    String[] answer = solution.solution(
        new String[]{"AB  CFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
        new int[]{2, 3, 4}
    );

    assertThat(answer).isEqualTo(new String[]{"AC", "ACDE", "BCFG", "CDE"});

  }

  @Test
  @DisplayName("테스트 2")
  void test2() {

    String[] answer = solution.solution(
        new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
        new int[]{2,3,5}
    );

    assertThat(answer).isEqualTo(new String[]{"ACD", "AD", "ADE", "CD", "XYZ"});

  }

  @Test
  @DisplayName("테스트 3")
  void test3() {

    String[] answer = solution.solution(
        new String[]{"XYZ", "XWY", "WXA"},
        new int[]{2, 3, 4}
    );

    assertThat(answer).isEqualTo(new String[]{"WX", "XY"});
  }

}