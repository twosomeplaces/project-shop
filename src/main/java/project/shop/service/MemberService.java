package project.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import project.shop.dao.MemberDao;
import project.shop.vo.MemberVo;

@Service
@Slf4j
public class MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberDao memberDao;
    public MemberService(PasswordEncoder passwordEncoder, MemberDao memberDao) {
        this.passwordEncoder = passwordEncoder;
        this.memberDao = memberDao;
    }

    public void save(MemberVo memberVo){
        //암호화 처리
        log.info("pw encode before={}", memberVo.getMPw());
        memberVo.setMPw(passwordEncoder.encode(memberVo.getMPw()));
        log.info("pw encode after={}", memberVo.getMPw());

        log.info("roels before={}", memberVo.getRoles());
        memberVo.setRoles("USER");
        log.info("roles after={}", memberVo.getRoles());

        // validateDuplicateMember(member);
        memberDao.save(memberVo);
    }

    public Optional<MemberVo> findOne(String insertedId){
        Optional<MemberVo> findOne = memberDao.findOne(insertedId);
        return findOne;
    }

    public List<MemberVo> findAll(){
        List<MemberVo> memberList = memberDao.findAll();
        return memberList;
    }
    
}
