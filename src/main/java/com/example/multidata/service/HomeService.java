package com.example.multidata.service;

import com.example.multidata.mappers.mysql.MysqlMapper;
import com.example.multidata.mappers.oracle.OracleMapper;
import com.example.multidata.po.TjItemsummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: dingding_p
 * @Date: 2020/1/3
 * @Description: com.example.multidata.service
 * @version: 1.0
 */
@Service
@Transactional
public class HomeService {

    @Autowired
    MysqlMapper mysqlMapper;
    @Autowired
    OracleMapper oracleMapper;

    public String insertIt(List<TjItemsummary> tjItemsummaryList){//分页的对象

        /*tjItemsummaryList.forEach(tjItemsummary -> {
            mysqlMapper.ineertIt(tjItemsummary);
        });*/
        for (TjItemsummary tjItemsummary:tjItemsummaryList
             ) {
            mysqlMapper.ineertIt(tjItemsummary);
        }

        return "成功";
    }
    public List<TjItemsummary> selectIt(int bindex, int end){
        List<TjItemsummary> tjItemsummarylist = oracleMapper.getIt(bindex,end);
        return tjItemsummarylist;
    }
    public int getItnum(){
       return oracleMapper.getItnum();
    }
}
