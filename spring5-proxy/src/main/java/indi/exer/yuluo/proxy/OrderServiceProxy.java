package indi.exer.yuluo.proxy;

/**
 * @author: yuluo
 * @createTime: 2021/11/18 19:43
 * @Description:
 */

// 相同接口的实现 implements OrderService
public class OrderServiceProxy implements OrderService {

    // 原始类
    private OrderServiceImpl orderService = new OrderServiceImpl();

    // 实现相同的接口
    @Override
    public void showOrder() {
        // 额外功能
        System.out.println("----log-----");

        orderService.showOrder();
    }
}
