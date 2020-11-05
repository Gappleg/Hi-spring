package Hi.Hispring.repository;

import Hi.Hispring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
// member저장소 상속

    private static Map<Long, Member> store = new HashMap<>();
    // 실무는 동시성문제가 있어서 다른 hashmap 사용
    private static long sequence = 0L; // 0, 1, 2 키값 생성

    @Override
    public Member save(Member member) { //store에 넣기 전에 member id setting
        // 이름은 넘어온 상태
        member.setId(++sequence); // id setting
        store.put(member.getId(), member); // store에 저장 (hash map에 저장)
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        // return store.get(id)
        // null일 경우에 처리가 안되기떄문에 Optional로 감싼다.
        // ofNullable -> Null 값이 반환되어도 Optional로 감쌀 수 있음.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                // 람다, getName이 파라미터로 넘어온 name과 같은지 확인하는 filter
                .findAny(); // 찾으면 반환, 결과가 Optional로 반환
                // findAny -> 하나라도 찾으면 바로 반환.
                // 없으면 Optional에 Null로 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
        // store.values는 멤버. list로 member들이 쭉 반환됨.
    }

    public void clearStore() {
        store.clear();
    } // test 끝날 때마다 data를 지워줌
}
