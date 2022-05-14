package indi.yuluo.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import indi.yuluo.springboot.enity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: yuluo
 * @FileName: StudentMapper.java
 * @createTime: 2022/5/8 12:26
 * @Description: 接口
 */

@Mapper  // 扫描dao接口到spring容器种
public interface StudentMapper extends BaseMapper<Student> {
}
