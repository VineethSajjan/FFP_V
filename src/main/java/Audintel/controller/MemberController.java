package Audintel.controller;

import Audintel.dao.Member;
import Audintel.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Member")
@CrossOrigin(origins = "http://localhost:3000/")
public class MemberController {

    @Autowired
    private MemberService memberService;

//    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping("/save")
    public Member saveMember(@RequestBody Member member) {
        System.out.println("mid:"+member.toString());
        return memberService.saveMember(member);
    }

    @PutMapping("/update")
    public Member updateMember(@RequestBody Member member) {
        return memberService.updateMember(member);
    }

    @PatchMapping("/patch")
    public Member patchMember(@RequestBody Member member) {
        return memberService.patchMember(member);
    }

    @GetMapping("/findAll")
    public String findAllMembers() {
        return memberService.findAllMembers();
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Integer id) {
        return memberService.getMemberById(id);
    }

    @GetMapping("/profile/{email}")
    public Member getMemberByEmail(@PathVariable String email) {return memberService.getMemberByEmail(email);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMember(@PathVariable Integer id) {
        memberService.deleteMember(id);
    }
    @GetMapping("/list")
    public List<Member> getListMembers() {
        return memberService.getListMembers();
    }
}

