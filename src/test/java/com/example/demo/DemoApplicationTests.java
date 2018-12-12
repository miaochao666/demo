package com.example.demo;

import com.example.demo.domain.dto.DeptDto;
import com.example.demo.domain.entity.Address;
import com.example.demo.domain.entity.Dept;
import com.example.demo.domain.entity.User;
import com.example.demo.mapper.AddressMapper;
import com.example.demo.mapper.DeptMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private DeptMapper deptMapper;

    @Test
    public void contextLoads() {

        List<User> list=userService.selectAllUser();
        System.out.println("------------------------------------------");
        System.out.println(list.size());
        Iterator<User> it1=list.iterator();
        while (it1.hasNext()){
            User user=it1.next();
            System.out.println(user.toString());
        }


        /*User user=userService.selectUserByName("a");
        System.out.println("------------------------------------------");
        System.out.println(user.toString());
*/
        User user=null;
        user=userMapper.findByUsername("aa");
        System.out.println("------------------------------------------");
        System.out.println(user);

        Dept dept=deptMapper.findByDeptNo(22);
        System.out.println(dept);
        System.out.println("------------------------------------------");


        int page=1;
        int size=3;
        Sort sort=new Sort(Sort.Direction.DESC,"deptNo");//排序规则的定义（按deptNo降序）
        Pageable pageable=new PageRequest(page,size,sort);
        Page<Dept> deptlist=deptMapper.findAll(pageable);
        System.out.println("总记录数："+deptlist.getTotalElements());
        System.out.println("总页数:"+deptlist.getTotalPages());
        System.out.println("排序规则:"+deptlist.getSort());
        Iterator<Dept> it=deptlist.iterator();
        Dept dept1=null;
        while(it.hasNext()){
            dept1=it.next();
            System.out.println(dept1.toString());
            System.out.println("********");
        }
        System.out.println("------------------------------------------");
        deptMapper.deleteByDeptNo(6);


        System.out.println("------------------------------------------");
        List<Dept> deptList1=deptMapper.findAll();
        Iterator<Dept> it2=deptList1.iterator();
        while(it2.hasNext()){
            dept1=it2.next();
            System.out.println(dept1.toString());
            System.out.println("+++++++++++++++++++++++");
        }
        System.out.println("------------------------------------------");
        deptList1=deptMapper.selectDeptList();
        it2=deptList1.iterator();
        while(it2.hasNext()){
            dept1=it2.next();
            System.out.println(dept1.toString());
            System.out.println("+++++++++++++++++++++++");
        }
        System.out.println("------------------------------------------");

    }

    @Resource
    private AddressMapper addressMapper;

    @Test
    public void testMyBatis(){
        List<Address> list=addressMapper.addressList();
        System.out.println(list.size());
    }

    @Test
    public void testCache(){
        User user=userMapper.findByUsername("2w");
        System.out.println(user.toString());
        user=userMapper.findByUsername("2w");
        System.out.println(user.toString());
        List<User> list=userMapper.selectAllUser();
        System.out.println(list.size());
        userMapper.updateUserPwd("2w","1111");
        list=userMapper.selectAllUser();
        System.out.println(list.size());
        userMapper.deleteUsers(1);
        list=userMapper.selectAllUser();
        System.out.println(list.size());
    }
}
