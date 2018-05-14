package com.peak.dto;

import java.util.ArrayList;
import java.util.List;

import com.peak.bean.AlipayBill;

public class AlipayBillResult {
	private List<AlipayBill> successData = new ArrayList<AlipayBill>();
	private List<AlipayBillResult> failureData = new ArrayList<AlipayBillResult>();
	private String transactionId;
	private String shopOrderId;
	private String counterparty;
	private String status;
	private String errorMsg;
	private String warningMsg;
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getShopOrderId() {
		return shopOrderId;
	}
	public void setShopOrderId(String shopOrderId) {
		this.shopOrderId = shopOrderId;
	}
	public String getCounterparty() {
		return counterparty;
	}
	public void setCounterparty(String counterparty) {
		this.counterparty = counterparty;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getWarningMsg() {
		return warningMsg;
	}
	public void setWarningMsg(String warningMsg) {
		this.warningMsg = warningMsg;
	}
	public List<AlipayBill> getSuccessData() {
		return successData;
	}
	public void setSuccessData(List<AlipayBill> successData) {
		this.successData = successData;
	}
	public List<AlipayBillResult> getFailureData() {
		return failureData;
	}
	public void setFailureData(List<AlipayBillResult> failureData) {
		this.failureData = failureData;
	}
}
