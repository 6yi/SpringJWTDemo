package tk.lzhengycy.jwtdemo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.lzhengycy.jwtdemo.demo.JwtHelper;
import tk.lzhengycy.jwtdemo.demo.entity.Audience;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName JwtControler
 * @Author 6yi
 * @Date 2020/5/10 22:47
 * @Version 1.0
 * @Description:
 */

@RestController
public class JwtController {

    @Autowired
    Audience audience;

    @PostMapping("/login")
    public String login(@RequestParam(value = "username", required = true) String usernameOrEmail,
                          @RequestParam(value = "password", required = true) String password,
                          HttpServletRequest request) {

//        User user = new User();
//
//        User query_user = userService.get(user);
//        if (query_user == null) {
//            return ResultVOUtil.error("400", "用户名或邮箱错误");
//        }
        //验证密码
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        boolean is_password = encoder.matches(password, query_user.getPassword());
//        if (!is_password) {
//            //密码错误，返回提示
//            return ResultVOUtil.error("400", "密码错误");
//        }

        String jwtToken = JwtHelper.createJWT(usernameOrEmail,
                audience.getClientId(),
                audience.getName(),
                audience.getExpiresSecond()*1000,
                audience.getBase64Secret());
        String result_str = "bearer;" + jwtToken;
        return result_str;
    }


    @GetMapping("/use")
    public String jwtSuccess(){
        return  "Success";
    }

}
