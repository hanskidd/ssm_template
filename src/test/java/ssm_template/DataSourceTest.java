package ssm_template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.kidd.core.dao.UserMapper;
import com.kidd.core.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
@Transactional
public class DataSourceTest {

	
	@Autowired
	private UserMapper userMapper;
	@Test
	@Rollback(value = false)
	public void testAddUser(){
		User user = new User(null, "张三", 1);
		System.out.println(userMapper.insertSelective(user));
	}
	
}
