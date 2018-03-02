package com.example.springbootdemo;

import com.alibaba.druid.filter.config.ConfigTools;
import com.example.po.Actor;
import com.example.repository.ActorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = "com.example")
public class SpringBootDemoApplicationTests {
	@Autowired
	private ActorRepository actorRepository;
	@Test
	public void contextLoads() {

	}
	@Test
	public void testActorRepository(){
		Actor actor = actorRepository.findOne(1);
		System.out.println(actor.getFirstname()+" "+actor.getLastname());
	}

	/**
	 * DruidDataSource 数据库密码加密
	 */
	@Test
	public void TestDruidPasswordEncrypt(){
		try {
			String passwd = "ly520101";
			ConfigTools.main(new String[]{passwd});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
