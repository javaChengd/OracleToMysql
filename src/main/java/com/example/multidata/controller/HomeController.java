package com.example.multidata.controller;


import com.example.multidata.service.HomeService;
import com.example.multidata.thread.MyRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
public class HomeController {
    private static final int CORE_POOL_SIZE = 4;//核心线程数为 4。
    private static final int MAX_POOL_SIZE = 10;//最大线程数 10
    private static final int QUEUE_CAPACITY = 100;//任务队列为 ArrayBlockingQueue，并且容量为 100;
    private static final Long KEEP_ALIVE_TIME = 1L;//等待时间为 1L。

    @Autowired
    HomeService homeService;

    @PostMapping("/hello")
    public String home() {
        int count = homeService.getItnum();

        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,//等待时间的单位为 TimeUnit.SECONDS。
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());//饱和策略为 CallerRunsPolicy
        int num = 10000;//每次查询的条数
        //需要查询的次数
        int times=count / num;
        if(count%num !=0) {
            times=times+1;
        }
        //开始查询的行数
        int bindex = -9999;
        int end = 0;
        for (int i = 0; i < times; i++) {
            bindex=bindex+num;
            end =bindex+num-1;
            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
            Runnable worker = new MyRunnable(homeService,bindex,end);
            //执行Runnable
            executor.execute(worker);
        }

        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        return "Finished all threads";
    }

}
