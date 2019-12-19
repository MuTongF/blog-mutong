package com.mutong;


import com.mutong.common.LayuiJson;
import com.mutong.entity.user.BlogUser;
import com.mutong.service.BlogUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class ApplicationTest {

  @Autowired
  private BlogUserService blogUserService;

  @Test
  public void register() {
    BlogUser blogUser = new BlogUser();
    blogUser.setUsername("admin");
    blogUser.setPassword("111");
    /*注册*/
    LayuiJson register = blogUserService.register(blogUser);
    System.out.println(register.toString());
  }
}
