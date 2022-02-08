package com.janek.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.janek.board.model.UserProfile;

@Mapper
public interface UserProfileMapper {

	@Select("SELECT * FROM UserProfile WHERE id=#{id}")
	UserProfile getUserInfo(@Param("id") String id);
	
	@Select("SELECT * FROM UserProfile")
	List<UserProfile> getUserList();
	
	@Insert("INSERT INTO UserProfile VALUES(#{id}, #{name}, #{phone}, #{address})")
	int putUserInfo(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("address") String address);
	
	@Update("UPDATE UserProfile SET name=#{name}, phone=#{phone}, address=#{address} WHERE id=#{id}")
	int postUserInfo(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("address") String address);
	
	@Delete("DELETE FROM UserProfile WHERE id=#{id}")
	int deleteUserInfo(@Param("id") String id);
	
}
