package com.example.multidata.mappers.mysql;

import com.example.multidata.po.ReconciliationDetailsPO;
import com.example.multidata.po.RouterPO;
import com.example.multidata.po.TjItemsummary;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MysqlMapper {
    @Insert("insert into tj_itemsummary(ake010,akb020,akb021,ake001,ake002,ake005,ake006,ake003,aka063,aka065,aka130,akf001,akf002,bkf050,akc273,aka074,bka076,akc226,aae019,akc225,aac999,aac003,akc190)values(#{ake010},#{akb020},#{akb021},#{ake001},#{ake002},#{ake005},#{ake006},#{ake003},#{aka063},#{aka065},#{aka130},#{akf001},#{akf002},#{bkf050},#{akc273},#{aka074},#{bka076},#{akc226},#{aae019},#{akc225},#{aac999},#{aac003},#{akc190})")
    public void ineertIt(TjItemsummary tjItemsummary);
}
