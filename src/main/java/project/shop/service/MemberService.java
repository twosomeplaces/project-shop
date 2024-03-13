package project.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.shop.dao.MemberDao;
import project.shop.vo.MemberVo;

@Service
public class MemberService {

    @Autowired
    MemberDao memberDao;

    public void save(MemberVo memberVo){
        memberDao.save(memberVo);
    }
    
}
