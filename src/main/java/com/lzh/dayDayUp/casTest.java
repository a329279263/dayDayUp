
import com.lzh.dayDayUp.util.HttpUtils;

import java.util.HashMap;
import java.util.Map;

public class casTest {
    public static void main(String[] args) {
        String token= "eyJhbGciOiJSUzUxMiJ9.eyJ1SWQiOiJxaWFvamlhbnNoZSIsInJlYWxOYW1lIjoi5LmU5bu66K6-IiwibG9naW5OYW1lIjoicWlhb2ppYW5zaGUiLCJ1c2VyTmFtZSI6IuS5lOW7uuiuviIsImV4cCI6MTU5NzgwODM3NywiaWF0IjoxNTk3ODA3Nzc3LCJyZWZyZXNoSWQiOiJjMzNkNGRhOGY4ZTY0OWYyYmQwMjk5NDljZDZiMjA5ZCJ9.MVJ8DG2PzrrjE1NzwpF7heYKdWgxtXn5ViC0q2Jh12EQ5ld2XD_PNx7ukNZ6HM2h1c8j4WAzSZtzJV-bx9H9K2W5k9TCVpG8MzTcfNic7y3Sw_TmNq9ywOh3XKOA_xK9YsWP7dhsMZwJ3qTDKq3TIjuvVMsgw6-PPEyrkn5GimI";
        Map<String, Object> params = new HashMap<>(16);
        params.put("token", token);
        Map<String, Object> headers = new HashMap<>(16);
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        System.out.println(HttpUtils.httpGet( "http://localhost:8888/jeecg-boot/cmcc/sso/getToken", params, headers));
    }

}
