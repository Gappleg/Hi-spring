package Hi.Hispring.repository;

import Hi.Hispring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 미리 틀을 만들어놓고 (테스트 만들기)
    // 메인을 개발 -> TDD

    @AfterEach
    public void afterEach() {
        repository.clearStore();
        // 한 테스트 끝날 때마다 store된 data 지워줌
        // 테스트 순서에 의존관계가 없이 테스트케이스 작성
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); // Optional에서 값을 꺼낼 때 get으로.
        System.out.println("result = " + (result == member));

        assertThat(member).isEqualTo(result);
        // member가 result가 같은지 비교교
        // import static org.assertj.core.api.Assertions.*;
        // static import로 들어가서 assert로 바로 입력가능
        // Assertions에서 alt enter
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }
    // 전체 테스트 시에 findByName에서 오류남.
    // 테스트 순서는 정해져있지않고, 의존적으로 설계해서는 안됨.
    // findAll에 저장된 객체가 findByName에 쓰여서 생기는 오류.
    // 테스트 끝날 때마다 데이터를 clear 해야함.

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
