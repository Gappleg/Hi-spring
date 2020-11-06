package Hi.Hispring.service;

import Hi.Hispring.domain.Member;
import Hi.Hispring.repository.MemberRepository;
import Hi.Hispring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복회원검증

//        Optional<Member> result = //result로 반환이 되기떄문에
//        memberRepository.findByName(member.getName())// 같은 이름이 있는 회원은 안된다 rule
//                // null 일 때 Optional로 감쌈.
//                result // 이 result는 굳이 안씀.
//
//                .ifPresent(m -> {
//                    throw new IllegalStateException("이미 존재하는 회원입니다.");
//                });
//
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())// 같은 이름이 있는 회원은 안된다 rule
                .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     * 전체 회원 조회
     */

    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    public  Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
