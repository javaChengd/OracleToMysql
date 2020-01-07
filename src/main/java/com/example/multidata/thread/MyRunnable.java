package com.example.multidata.thread;

import com.example.multidata.po.TjItemsummary;
import com.example.multidata.service.HomeService;

import java.util.Date;
import java.util.List;

/**
 * 这是一个简单的Runnable类，需要大约5秒钟来执行其任务。
 * @author shuang.kou
 */
public class MyRunnable implements Runnable {

    private HomeService myService;//需要通过够早方法把对应的业务service传进来 实际用的时候把类型变为对应的类型
    //private String aaz010;//查询条件 根据条件来定义该类的属性
    private int bindex;//分页index
    private int end;//分页结束
    /**
     * 重新构造方法
     * @param myService
     * @param bindex
     * @param end
     */
    public MyRunnable(HomeService myService,int bindex,int end){
        this.myService=myService;
        this.bindex=bindex;
        this.end=end;
    }


    @Override
    public void run() {
        List<TjItemsummary> tjItemsummaryList =  myService.selectIt(bindex,end);
        myService.insertIt(tjItemsummaryList);
    }



}
