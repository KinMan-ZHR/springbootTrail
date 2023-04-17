package expiredController;


import com.aduiduidui.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Cookie、HttpSession演示
 * 本方法已经过时，不建议使用，使用jwt代替
 */
@Slf4j
@RestController
public class SessionController {

    //设置Cookie
    //cookie工作流程：浏览器发送请求->服务器响应Cookie->浏览器保存Cookie->浏览器下次请求时，会自动携带Cookie；
    //服务端给客户端发送Cookie的方式：response.addCookie(new Cookie("login_username","itheima"));
    @GetMapping("/c1")
    public Result cookie1(HttpServletResponse response){
        response.addCookie(new Cookie("login_username","itheima")); //设置Cookie/响应Cookie
        return Result.success();
    }

    //用于获取客户端携带来的Cookie
    @GetMapping("/c2")
    public Result cookie2(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("login_username")){
                System.out.println("login_username: "+cookie.getValue()); //输出name为login_username的cookie
            }
        }
        return Result.success();
    }


       //HttpSession工作流程：session与cookie的区别：session是保存在服务器端的，cookie是保存在客户端的。
    @GetMapping("/s1")
    public Result session1(HttpSession session){
        log.info("HttpSession-s1: {}", session.hashCode());

        session.setAttribute("loginUser", "tom"); //往session中存储数据
        return Result.success();
    }
//浏览器发送请求->服务器响应Cookie->浏览器保存Cookie->浏览器下次请求时，会自动携带Cookie；
    @GetMapping("/s2")
    public Result session2(HttpServletRequest request){
        HttpSession session = request.getSession();
        log.info("HttpSession-s2: {}", session.hashCode());

        Object loginUser = session.getAttribute("loginUser"); //从session中获取数据
        log.info("loginUser: {}", loginUser);
        return Result.success(loginUser);
    }
}
