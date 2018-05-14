package com.peak.bean;

import java.util.Date;

import org.springframework.util.StringUtils;

import com.peak.utils.DateUtil;
import com.peak.utils.NumberUtil;

public class AlipayBill {
    private Integer id;

    private String transactionId;

    private String shopOrderId;

    private Date createDate;

    private Date payDate;

    private Date lastUpdateDate;

    private String source;

    private String type;

    private String counterparty;

    private String productName;

    private Float amount;

    private String incomeExpenses;

    private String tradeStatus;

    private Float serviceCharge;

    private String refund;

    private String mark;

    private String fundedStatus;

    private String useType;

    private String humanType;

    private String objType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    public String getShopOrderId() {
        return shopOrderId;
    }

    public void setShopOrderId(String shopOrderId) {
        this.shopOrderId = shopOrderId == null ? null : shopOrderId.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCounterparty() {
        return counterparty;
    }

    public void setCounterparty(String counterparty) {
        this.counterparty = counterparty == null ? null : counterparty.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getIncomeExpenses() {
        return incomeExpenses;
    }

    public void setIncomeExpenses(String incomeExpenses) {
        this.incomeExpenses = incomeExpenses == null ? null : incomeExpenses.trim();
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus == null ? null : tradeStatus.trim();
    }

    public Float getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Float serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getRefund() {
        return refund;
    }

    public void setRefund(String refund) {
        this.refund = refund == null ? null : refund.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public String getFundedStatus() {
        return fundedStatus;
    }

    public void setFundedStatus(String fundedStatus) {
        this.fundedStatus = fundedStatus == null ? null : fundedStatus.trim();
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType == null ? null : useType.trim();
    }

    public String getHumanType() {
        return humanType;
    }

    public void setHumanType(String humanType) {
        this.humanType = humanType == null ? null : humanType.trim();
    }

    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType == null ? null : objType.trim();
    }
    
    public AlipayBill(String[] data) {
		super();
		this.transactionId = trim(data[0]);
		this.shopOrderId = trim(data[1]);
		this.createDate = DateUtil.parseDate(trim(data[2]));
		this.payDate = DateUtil.parseDate(trim(data[3]));
		this.lastUpdateDate = DateUtil.parseDate(trim(data[4]));
		this.source = trim(data[5]);
		this.type = trim(data[6]);
		this.counterparty = trim(data[7]);
		this.productName = trim(data[8]);
		this.amount = NumberUtil.parseFloat(trim(data[9]));
		this.incomeExpenses = trim(data[10]);
		this.tradeStatus = trim(data[11]);
		this.serviceCharge = NumberUtil.parseFloat(trim(data[12]));
		this.refund = trim(data[13]);
		this.mark = trim(data[14]);
		this.fundedStatus = trim(data[15]);
	}
    
    private String trim(String str) {
    	if(StringUtils.isEmpty(str)) return null;
    	return str.trim();
    }
}