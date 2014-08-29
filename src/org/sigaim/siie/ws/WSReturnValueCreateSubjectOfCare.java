package org.sigaim.siie.ws;

import org.sigaim.siie.interfaces.reportmanagement.ReturnValueCreateHealthcareFacility;
import org.sigaim.siie.interfaces.reportmanagement.ReturnValueCreateSubjectOfCare;

public class WSReturnValueCreateSubjectOfCare {
	private String requestId;
	private String reasonCode;
	private String serialized;
	
	public WSReturnValueCreateSubjectOfCare() {
		
	}
	public WSReturnValueCreateSubjectOfCare(ReturnValueCreateSubjectOfCare ret) {
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
