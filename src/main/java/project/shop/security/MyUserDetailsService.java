package project.shop.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import project.shop.service.MemberService;
import project.shop.vo.MemberVo;

@Component
public class MyUserDetailsService implements UserDetailsService {

    private final MemberService  memberService;
    public MyUserDetailsService(MemberService  memberService) {
        this.memberService=memberService;
    }

    @Override
    public UserDetails loadUserByUsername(String insertedUserId) throws UsernameNotFoundException {
        Optional<MemberVo> findOne = memberService.findOne(insertedUserId);
        MemberVo member = findOne.orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다 ㅠ"));
        
        return User.builder()
                .username(member.getMName())
                .password(member.getMPw())
                .roles(member.getRoles())
                .build();
    }
    
}
