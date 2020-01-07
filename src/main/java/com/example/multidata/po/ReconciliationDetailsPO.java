package com.example.multidata.po;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class ReconciliationDetailsPO {

    //主键
    private Long DetailID;

    //老版本有用，新的无用
    private Long LogID;

    //交易订单号
    private String OrderNo;

    //商户号
    private String MerchantNo;

    //金额
    private BigDecimal Amount;

    //手续费
    private BigDecimal Fee;

    //扣款平台
    private String DeductPlatform;

    //结果状态(1-成功；0-失败；2-成功，但Sap不抽)
    private Integer State;

    //结果
    private String Result;

    //结果描述
    private String ResultDesc;

    //请求时间/交易时间
    private Timestamp RequestTime;

    //扣款平台订单号
    private String PlatformOrderNo;

    //扣款平台交易号
    private String PlatformTransactionNo;

    //商品名称
    private String ProductName;

    //创建时间
    private Timestamp CreateTime;

    //更新时间
    private Timestamp UpdateTime;

    //扣款类型（0、自己扣；1、别人扣[需要保证商户号的唯一性,CommpayKey不为空]）
    private Integer DeductType;

    //到款账号
    private Integer ToAccount;

    //i don't know
    private Timestamp PlatformTradeSuccessTime;

}
