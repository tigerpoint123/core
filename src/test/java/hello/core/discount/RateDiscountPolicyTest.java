package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip는 10% 할인이 적용돼야 한다")
    void vip_o() {
        //given
        Member memberVip = new Member(1L, "memberVip", Grade.VIP);

        //when
        int discount = rateDiscountPolicy.discount(memberVip, 10000);
        //then

        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("vip가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {
        //given
        Member memberVip = new Member(2L, "memberBasic", Grade.VIP);

        //when
        int discount = rateDiscountPolicy.discount(memberVip, 10000);
        //then

        assertThat(discount).isEqualTo(1000);
    }
}