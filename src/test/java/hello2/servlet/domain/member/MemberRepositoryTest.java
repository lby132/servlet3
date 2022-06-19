package hello2.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member("hello", 20);

        Member saveMember = memberRepository.save(member);

        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(saveMember).isSameAs(findMember);
    }

    @Test
    void findAll() {
        Member userA = new Member("userA", 20);
        Member userB = new Member("userB", 30);

        memberRepository.save(userA);
        memberRepository.save(userB);

        List<Member> members = memberRepository.findAll();
        assertThat(members.size()).isEqualTo(2);
        assertThat(members).contains(userA, userB);
    }

}