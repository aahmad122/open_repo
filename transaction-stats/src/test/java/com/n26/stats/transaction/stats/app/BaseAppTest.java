package com.n26.stats.transaction.stats.app;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.n26.stats.transaction.app.App;

@SpringBootTest(classes = { App.class }, webEnvironment = WebEnvironment.NONE)
@ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
public class BaseAppTest extends AbstractTestNGSpringContextTests{


}
