package indi.yuluo.springbootRESTful.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import indi.yuluo.springbootRESTful.enity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: yuluo
 * @FileName: IndexDao.java
 * @createTime: 2022/5/8 16:49
 * @Description:
 */

@Mapper
public interface Studentdao extends BaseMapper<Student> {
}
