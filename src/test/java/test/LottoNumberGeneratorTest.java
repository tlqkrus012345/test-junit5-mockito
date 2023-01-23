package test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    @DisplayName("로또 번호 갯수 테스트")
    @Test
    void lottoNumberSizeTest() {
        // given
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        final int price = 1000;

        // when
        final List<Integer> lottoNumber = lottoNumberGenerator.generate(price);

        // then
        assertThat(lottoNumber.size()).isEqualTo(6);
    }

    @DisplayName("로또 번호 범위 테스트")
    @Test
    void lottoNumberRangeTest() {
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        final int price = 1000;

        final List<Integer> lottoNumber = lottoNumberGenerator.generate(price);

        assertThat(lottoNumber.stream().allMatch(l -> l >= 1 && l <= 45)).isTrue();
    }

    @DisplayName("잘못된 로또 금액 테스트")
    @Test
    void lottoNumberWrongMoneyTest() {
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        final int price = 10000;

        final RuntimeException exception = assertThrows(RuntimeException.class, () -> lottoNumberGenerator.generate(price));

        assertThat(exception.getMessage()).isEqualTo("올바른 금액이 아닙니다");
    }
}