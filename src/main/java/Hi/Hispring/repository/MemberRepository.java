package Hi.Hispring.repository; // 회원객체 저장소

import Hi.Hispring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원 저장

    Optional<Member> findById(Long id); // id로 회원을 찾는 기능
    Optional<Member> findByName(String name); // name으로 회원 찾는 기능
    // Optional = 회원이 없을 때 null 처리
    List<Member> findAll();
}
