package Hi.Hispring.service;

import Hi.Hispring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();

    @Test
    void 회원가입() { //테스트는 과감하게 한글로 바꿔도됨
        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo((findMember.getName()));
    }
    // given when then 패턴

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //whn
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다.")
//        }
//        memberService.join(member2); //델리게이트 걸려서 예외가 터짐 / IllegalStateException

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}