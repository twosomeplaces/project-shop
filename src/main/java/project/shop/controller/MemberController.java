package project.shop.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import project.shop.service.MemberService;
import project.shop.vo.MemberVo;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("memberVo", new MemberVo());
        return "signup";
    }

    @PostMapping("/signup")
    public String save(@ModelAttribute MemberVo memberVo, RedirectAttributes redirectAttributes, Model model) {
        
        //검증 오류 결과를 보관
        Map<String, String> errors = new HashMap<>();

        //검증 로직
        if (!StringUtils.hasText(memberVo.getMId())) {
            errors.put("mId", "아이디는 필수입니다.");
        }
        if (!StringUtils.hasText(memberVo.getMName())) {
            errors.put("mName", "이름은 필수입니다.");            
        }
        if (!StringUtils.hasText(memberVo.getMBirth())) {
            errors.put("mBirth", "생년월일은 필수입니다.");
        }
        if (!StringUtils.hasText(memberVo.getMNum())) {
            errors.put("mNum", "전화번호는 필수입니다.");            
        }

        //검증에 실패하면 다시 입력 폼으로
        if (!errors.isEmpty()) {
            log.info("errors={}",errors);
            model.addAttribute("errors", errors);
            return "signup";
        }

        //성공 로직
        memberService.save(memberVo);
        // redirectAttributes.addAttribute("itemId", savedItem.getId());
        // redirectAttributes.addAttribute("status", true);
        return "redirect:/hello";
    }
    
}
