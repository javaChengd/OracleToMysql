package com.example.multidata.mappers.oracle;

import com.example.multidata.po.TjItemsummary;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: dingding_p
 * @Date: 2020/1/3
 * @Description: com.example.multidata.mappers.oracle
 * @version: 1.0
 */
public interface OracleMapper {
    @Select("select * from ( select ROWNUM AS num,t.* from tj_itemsummary t) where num between #{bindex} and #{end}")
    public List<TjItemsummary> getIt(int bindex ,int end);
    @Select("SELECT count(*) FROM tj_itemsummary ")
    public int getItnum();
}
