package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();//실무에선 동시성 문제 있을 수 있지만 여기선 일단 단순하게 간다
    private  static long sequence = 0L ;//012~단순히 키값 생성해줌

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));//null이 반환될 가능성이 있으면 옵션얼->클라이언트에서 뭘할수 있음(?)
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() //loop를 돌리면서 member랑 name이랑 같은지
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
