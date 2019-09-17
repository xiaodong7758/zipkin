package com.example.demo;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testQuery() {
        Map<String, Object> map = new HashMap();
        map.put("name", "Jone");
        List<User> users = userMapper.selectByMap(map);
        for (User user : users) {
            System.out.println(user.getName());
        }
    }

    @Test
    public void testInsert() {
        User user = new User(19l, "test", 23, "qq.com");
        Integer insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void testWrapper() {
        EntityWrapper<User> wrapper = new EntityWrapper<>();
        wrapper.eq("name", "Jone");
        wrapper.or();
        wrapper.like("name", "J");
        List<User> users = userMapper.selectList(wrapper);
        for (User user : users) {
            System.out.println(user.getName());
        }
    }

    @Test
    public void testUpdate() {
        EntityWrapper<User> userEntityWrapper = new EntityWrapper<>();
        userEntityWrapper.eq("name", "Jone");
        User user = new User(15l, "test01", 20, "test@qq.com");
        Integer update = userMapper.update(user, userEntityWrapper);
        System.out.println(update);
    }

    @Test
    public void testUpdate2() {
        User user = new User(1l, "Jone", 25, "Jone@qq.com");
        Integer integer = userMapper.updateById(user);
        System.out.println(integer);
    }

    @Test
    public void testDelete() {
        Integer integer = userMapper.deleteById(19l);
        System.out.println(integer);
    }
}
