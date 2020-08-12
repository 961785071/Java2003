package cn.kgc.demo.springboot.mybatis.mapper;

import cn.kgc.demo.springboot.mybatis.entity.Userlist;
import cn.kgc.demo.springboot.mybatis.entity.UserlistExample;
import cn.kgc.demo.springboot.mybatis.entity.UserlistKey;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserlistMapper {
    @SelectProvider(type=UserlistSqlProvider.class, method="countByExample")
    long countByExample(UserlistExample example);

    @DeleteProvider(type=UserlistSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserlistExample example);

    @Delete({
        "delete from userlist",
        "where id = #{id,jdbcType=INTEGER}",
          "and idcard = #{idcard,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(UserlistKey key);

    @Insert({
        "insert into userlist (id, idcard, ",
        "name, phone, user_id)",
        "values (#{id,jdbcType=INTEGER}, #{idcard,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, #{userId,jdbcType=INTEGER})"
    })
    int insert(Userlist record);

    @InsertProvider(type=UserlistSqlProvider.class, method="insertSelective")
    int insertSelective(Userlist record);

    @SelectProvider(type=UserlistSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="idcard", property="idcard", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER)
    })
    List<Userlist> selectByExample(UserlistExample example);

    @Select({
        "select",
        "id, idcard, name, phone, user_id",
        "from userlist",
        "where id = #{id,jdbcType=INTEGER}",
          "and idcard = #{idcard,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="idcard", property="idcard", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER)
    })
    Userlist selectByPrimaryKey(UserlistKey key);

    @UpdateProvider(type=UserlistSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Userlist record, @Param("example") UserlistExample example);

    @UpdateProvider(type=UserlistSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Userlist record, @Param("example") UserlistExample example);

    @UpdateProvider(type=UserlistSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Userlist record);

    @Update({
        "update userlist",
        "set name = #{name,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}",
          "and idcard = #{idcard,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Userlist record);
}