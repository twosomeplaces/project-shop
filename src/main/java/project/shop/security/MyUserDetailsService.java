package project.shop.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import project.shop.service.MemberService;
import project.shop.vo.MemberVo;

@Slf4j
@Component
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final MemberService  memberService;

    @Override
    public UserDetails loadUserByUsername(String insertedUserId) throws UsernameNotFoundException {
        log.info("login loadUserByUsername = {}", insertedUserId);
        Optional<MemberVo> findOne = memberService.findOne(insertedUserId);
        MemberVo member = findOne.orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다 ㅠ"));
        log.info("findOne = {}", member);
        
        return User.builder()
                .username(member.getMName())
                .password(member.getMPw())
                .roles(member.getRoles())
                .build();
    }
    
}
