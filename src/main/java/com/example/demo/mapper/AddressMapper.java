package com.example.demo.mapper;

import com.example.demo.domain.entity.Address;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface AddressMapper {

    @Insert("insert into address values(#{addressid},#{addressname})")
    void insertAddress(Address address);

    @Select("select * from address")


    List<Address> addressList();
}
