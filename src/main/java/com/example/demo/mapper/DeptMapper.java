package com.example.demo.mapper;

import com.example.demo.domain.dto.DeptDto;
import com.example.demo.domain.entity.Dept;
import com.example.demo.domain.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

public interface DeptMapper extends JpaRepository<Dept,Integer> {

    Dept findByDeptNo(@Param("deptno") int no);

    /*@Modifying
    @Query("insert into dept values(?1,?2,?3)")
    void insertDept(Dept dept);*/

    @Modifying
    @Transactional
    @Query(value = "delete from dept where dept_no=?1",nativeQuery = true)
    void deleteByDeptNo(int deptno);

    @Query(value = "select dept_no,dept_name,dept_loc from dept",nativeQuery = true)
    List<Dept> selectDeptList();

}

