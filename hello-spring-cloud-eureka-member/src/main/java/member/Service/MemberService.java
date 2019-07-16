package member.Service;

import member.Entity.Member;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @version 1.0.0
 */
@Service
public class MemberService {

    public Member getMember(String id,int port) {
        try {
            Integer.valueOf(id);
            Member member = new Member();
            member.setPort(port);
            member.setName("张无忌");
            member.setAge(19);
            return member;
        } catch(Exception e) {
            return new Member();
        }
    }
}
