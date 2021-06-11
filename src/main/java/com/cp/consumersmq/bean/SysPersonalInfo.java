package com.cp.consumersmq.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class SysPersonalInfo implements Serializable {

    private static final long serialVersionUID = -2050961555118270287L;
    /**
     * 客户名称
     */
    private String id;
    /**
     * 客户名称
     */
    private String personalName;
    /**
     * 客户手机号
     */
    private String personalmobie;

    /**
     * 收货人
     */
    private String receiveName;
    /**
     * 收货人联系电话
     */
    private String receiveMobile;
    /**
     * 下单时间
     */
    private String orderTime;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 交易金额
     */
    private BigDecimal payMoney = BigDecimal.ZERO;
    /**
     * 收货地址
     */
    private String receiveAddress;
    /**
     * 品类
     */
    private String productLine = "99";
    /**
     * 1-T销客，2-T云店，3-零售开单，4手工录入
     */
    private String sourceChannel;
    /**
     * 所属方舟编码
     */
    private String customerFzCode;
    /**
     * 所属CRM编码
     */
    private String customerCrmCode;

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public String getPersonalmobie() {
        return personalmobie;
    }

    public void setPersonalmobie(String personalmobie) {
        this.personalmobie = personalmobie;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceiveMobile() {
        return receiveMobile;
    }

    public void setReceiveMobile(String receiveMobile) {
        this.receiveMobile = receiveMobile;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getSourceChannel() {
        return sourceChannel;
    }

    public void setSourceChannel(String sourceChannel) {
        this.sourceChannel = sourceChannel;
    }

    public String getCustomerFzCode() {
        return customerFzCode;
    }

    public void setCustomerFzCode(String customerFzCode) {
        this.customerFzCode = customerFzCode;
    }

    public String getCustomerCrmCode() {
        return customerCrmCode;
    }

    public void setCustomerCrmCode(String customerCrmCode) {
        this.customerCrmCode = customerCrmCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
