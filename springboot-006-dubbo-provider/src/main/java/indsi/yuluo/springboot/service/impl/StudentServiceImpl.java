package indsi.yuluo.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import indi.yuluo.springboot.service.StudentService;
import org.springframework.stereotype.Component;

/**
 * @author: yuluo
 * @FileName: StudentServiceImpl.java
 * @createTime: 2022/5/13 11:17
 * @Description:
 */

@Component  // 交给spring容器进行管理
@Service(interfaceClass = StudentService.class, version="1.0.0", timeout=15000) // 注意这里使用的是dubbo的注解，不是spring的注解  要暴露的类名, 取代之前写的dubbo配置
// dubbo:service interface="" version="" timeout=""
public class StudentServiceImpl implements StudentService {
    @Override
    public Integer queryAllStudentCount() {

        // 调用数据持久层
        return 1200;
    }
}
