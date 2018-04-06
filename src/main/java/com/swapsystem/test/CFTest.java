package com.swapsystem.test;

import com.swapsystem.mapper.UserMapper;
import com.swapsystem.pojo.User;
import com.swapsystem.utils.ContextFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

public class CFTest {
    /*测试单例模式下的CF类能否生成context*/
    @Test
    public void ContextF(){

        ApplicationContext context= ContextFactory.getContext();
        UserMapper mapper = context.getBean(UserMapper.class);
        User user = mapper.findByName("asdfgh");
        System.out.println(user);
    }

}
