package com.example.demo.mapper;

import com.example.demo.domain.entity.User;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
//@CacheConfig(cacheNames = "test1")
public interface UserMapper extends JpaRepository<User,Integer> {

    /*
    方法名中不能加下划线
    */
    @Cacheable(value = "test1",key = "#p0")//具体注解解释  https://www.cnblogs.com/fashflying/p/6908028.html      https://blog.csdn.net/dreamhai/article/details/80642010
    public User findByUsername(@Param("name") String user_name);


    public Page<User> findByUsername(Pageable pageable);

    @Query(value="select * from users",nativeQuery = true)
    @Cacheable(value="test1")
    public List<User> selectAllUser();

    @Modifying
    @Transactional
    @Query(value="update users set user_password=?2 where username=?1",nativeQuery = true)
    @CachePut(value="test1",key="0")
    void updateUserPwd(String username,String user_password);

    @Modifying
    @Transactional
    @Query(value="delete from users where user_id=?1",nativeQuery = true)
    @CacheEvict(value="test1")
    void deleteUsers(int user_id);
}
