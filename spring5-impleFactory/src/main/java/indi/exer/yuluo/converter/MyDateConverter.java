package indi.exer.yuluo.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: yuluo
 * @createTime: 2021/11/14 20:10
 * @Description: 自定义日期类型转换器
 */

public class MyDateConverter implements Converter<String, Date> {

    //对字符串进行依赖注入
    private String pattern;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /*
        converter方法作用：String  --> Date
            SimpleDateFormat sdf = new SimpleDateFormat();
            sdf.parset(String) --> Date

        param: source代表的是 配置文件中的 日期字符串 <value> 2021-11-14 </value>

        return: 转换好的Date作为方法的返回值，Spring会自动的为binthday属性注入


        在spring中创建出来这个对象
        转换器注册

     */

    @Override
    public Date convert(String source) {

        Date parse = null;
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) new SimpleDateFormat(pattern);
        try {
            parse = simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return parse;

    }

}
