package cn.kgc.demo.springbootssmr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ResponseActions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestAttribute;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootssmrApplication.class)
@AutoConfigureMockMvc //启动MockMvc
public class SpringbootMVCTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testLogin()throws Exception{
        String url = "tologin";
        /*封装成一个get请求*/
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(url);

        /*设置可以接收响应的内容*/
        builder.accept(MediaType.TEXT_HTML);

        /*用mvc发送请求*/
        ResultActions actions = mockMvc.perform(builder);

        // 获取行为的结果
        MvcResult result = actions.andReturn();

        // 获取响应
        MockHttpServletResponse response = result.getResponse();
        int status = response.getStatus();
        String content = response.getContentAsString();
        System.out.println(status);
        System.out.println(content);


    }
}
