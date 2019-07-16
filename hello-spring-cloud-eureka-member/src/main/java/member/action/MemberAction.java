package member.action;

import member.Entity.Member;
import member.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author admin
 * @version 1.0.0
 */
@RestController
@RequestMapping
public class MemberAction {

    @Autowired
    public MemberService memberService;

    @GetMapping("/member")
    public Member getMember(String id){
        HttpServletRequest httpServletRequest=
                ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        int port=httpServletRequest.getServerPort();
        return memberService.getMember(id,port);
    }
}
