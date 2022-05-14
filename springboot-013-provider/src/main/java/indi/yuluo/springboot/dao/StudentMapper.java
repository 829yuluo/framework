package indi.yuluo.springboot.dao;

import bean.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author: yuluo
 * @FileName: StudentMapper.java
 * @createTime: 2022/5/14 13:01
 * @Description: 接口
 */

@Repository
public interface StudentMapper extends BaseMapper<Student> {
}
