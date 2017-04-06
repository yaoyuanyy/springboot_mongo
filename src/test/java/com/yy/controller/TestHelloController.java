package com.yy.controller;

import com.yy.AppRun;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.net.URL;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AppRun.class)
@WebIntegrationTest(randomPort = true)
@ActiveProfiles("test")
public class TestHelloController {

	@Value("${local.server.port}")
	private int port;
	private URL base;
	private TestRestTemplate template;

	public static final String APP_URL = "hello/";
	private String hello_Url = APP_URL + "home";
    private String save_Url = APP_URL + "save";
    private String get_Url = APP_URL + "get";
    private String list_Url = APP_URL + "list";


    private MockMvc mockMvc;
    @Resource
    private WebApplicationContext webApplicationContext;


	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
		template = new TestRestTemplate();
	}

	@Test
	public void getHello() throws Exception {
		ResponseEntity<String> response = template.getForEntity(base.toString() + hello_Url, String.class);
		Assert.assertThat(response.getBody(), Is.is("Hello World!"));
	}

    @Test
    public void save() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString() + save_Url, String.class);
        System.out.println(response.getBody());
    }

    /**
     * return Person{id='58e45f88e931b922507900c0', name='aa', age=10, ctime=Wed Apr 05 11:07:52 CST 2017}
     * @throws Exception
     */
    @Test
    public void get() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(base.toString() + get_Url)
                .param("id", "AsssAAsdfdsfds_wrf@gdg232D");

        ResultActions resultActions = getMockMvc().perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.handler().handlerType(HelloController.class))
                .andExpect(MockMvcResultMatchers.handler().methodName("getById"))
                .andExpect(MockMvcResultMatchers.status().isOk());


        String result = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println(result);
        Assert.assertNotNull("not null", result);
    }

    @Test
    public void list() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(base.toString() + list_Url)
                .param("name", "aa");

        ResultActions resultActions = getMockMvc().perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.handler().handlerType(HelloController.class))
                .andExpect(MockMvcResultMatchers.handler().methodName("list"))
                .andExpect(MockMvcResultMatchers.status().isOk());


        String result = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println(result);
        Assert.assertNotNull("not null", result);
    }

    protected MockMvc getMockMvc() {
        if (mockMvc == null) {
            mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                    // print handler log
//                    .alwaysDo(MockMvcResultHandlers.print())
                    .alwaysExpect(MockMvcResultMatchers.status().isOk())
                    .build();
        }
        return mockMvc;
    }
}
