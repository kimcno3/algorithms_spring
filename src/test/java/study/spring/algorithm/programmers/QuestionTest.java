package study.spring.algorithm.programmers;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuestionTest {

  Question question = new Question();

  @Test
  @DisplayName("테스트 코드 검증")
  void test() {

    String[] info = {
        "java backend junior pizza 150",
        "python frontend senior chicken 210",
        "python frontend senior chicken 150",
        "cpp backend senior pizza 260",
        "java backend junior chicken 80",
        "python backend senior chicken 50"
    };

    String[] query = {
        "java and backend and junior and pizza 100",
        "python and frontend and senior and chicken 200",
        "cpp and - and senior and pizza 250",
        "- and backend and senior and - 150",
        "- and - and - and chicken 100",
        "- and - and - and - 150"
    };

    Assertions.assertThat(question.solution(info, query))
        .isEqualTo(new int[]{1,1,1,1,2,4});

  }
}