package Audintel.service;

import Audintel.dao.Member;
import Audintel.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private MemberRepository memberRepository;

    public boolean isValidLogin(Member member) {
        // Retrieve user from the database based on the provided email and password
        Member userFromDb = memberRepository.findByEmail(member.getEmail());

        // Check if the user exists
        return userFromDb != null && userFromDb.getPswd().equals(member.getPswd());
    }

    public Member getMemberByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}

