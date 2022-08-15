package study.spring.algorithm.programmers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuestionTest {

  Question question = new Question();

  @Test
  @DisplayName("테스트 코드 검증")
  void test() {

    int[] d = {1, 3, 2, 5, 4};
    int budget = 9;

    int answer = question.solution(d, budget);

    assertThat(answer).isEqualTo(3);

  }
}