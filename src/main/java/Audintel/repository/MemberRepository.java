package Audintel.repository;

import Audintel.dao.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member,Integer> {
    Member findByEmail(String email);
    Member findByMemberCode(int memberCode);
}
