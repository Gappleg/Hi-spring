package Hi.Hispring.service;

import Hi.Hispring.domain.Member;
import Hi.Hispring.repository.MemberRepository;
import Hi.Hispring.repository.MemoryMemberRepository;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원가입
     */
    public Long join(Member member) {
        memberRepository.findByName()

        memberRepository.save(member);
        return member.getId();
    }
}
