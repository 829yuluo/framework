package indi.yuluo.mybatisplus;

import indi.yuluo.mybatisplus.mapper.ProductMapper;
import indi.yuluo.mybatisplus.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author: yuluo
 * @createTime: 2022/3/17 19:51
 * @File: ProductTest.java
 * @Software: IntelliJ IDEA
 * @Description:
 */

@SpringBootTest
public class ProductTest {

    @Autowired
    private ProductMapper productMapper;

    /**
     *  用于测试：product表的测试类
     */
    @Test
    public void testProduct01() {

        // 小李查询商品价格
        Product productLi = productMapper.selectById(1);
        System.out.println("小李查询到的商品价格：" + productLi.getPrice());

        // 小明查询商品价格
        Product productWang = productMapper.selectById(1);
        System.out.println("小王查询到的商品价格：" + productWang.getPrice());

        // 小李将商品价格提高50
        productLi.setPrice(productLi.getPrice() + 50);
        productMapper.updateById(productLi);

        // 小王将商品的价格减去30
        productWang.setPrice(productWang.getPrice() - 10);
        int i = productMapper.updateById(productWang);
        // 版本号发生了变化之后再次进行修改操作
        if (i == 0) {
            Product productNew = productMapper.selectById(1);
            productNew.setPrice(productNew.getPrice() - 30);
            productMapper.updateById(productNew);
        }

        // 老板查询商品价格
        Product productLaoban = productMapper.selectById(1);
        System.out.println("老板查询到的商品价格：" + productLaoban.getPrice());
    }

}
