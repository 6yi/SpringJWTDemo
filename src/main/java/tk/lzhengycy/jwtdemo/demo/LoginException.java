package tk.lzhengycy.jwtdemo.demo;

/**
 * @ClassName LoginException
 * @Author 6yi
 * @Date 2020/5/10 22:28
 * @Version 1.0
 * @Description:
 */


public class LoginException extends RuntimeException{
    private String code;

    public LoginException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public LoginException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}