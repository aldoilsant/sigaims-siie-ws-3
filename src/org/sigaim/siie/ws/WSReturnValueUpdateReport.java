package org.sigaim.siie.ws;

import org.sigaim.siie.interfaces.reportmanagement.ReturnValueCreateReport;
import org.sigaim.siie.interfaces.reportmanagement.ReturnValueUpdateReport;

public class WSReturnValueUpdateReport {
	private String requestId;
	private String reasonCode;
	private String serialized;
	
	public WSReturnValueUpdateReport() {
		
	}
	public WSReturnValueUpdateReport(ReturnValueUpdateReport ret) {
		this.requestId=ret.getRequestId();
		this.reasonCode=ret.getReasonCode();
		this.serialized=ret.getSerialized();
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getReasonCode() {
		return reasonCode;
	}
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
	public String getSerialized() {
		return serialized;
	}
	public void setSerialized(String serialized) {
		this.serialized = serialized;
	}
}
