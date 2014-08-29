package org.sigaim.siie.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.sigaim.siie.interfaces.eql.ReturnValueEQL;
import org.sigaim.siie.rm.exceptions.CSReason;
import org.sigaim.siie.rm.exceptions.RejectException;

@WebService
public class INTSIIE001EQLImpl {
	
	@WebMethod
	public WSReturnValueEQL query(String requestId, String eqlQuery) {
		try {
			ReturnValueEQL ret= ServiceInjector.getInstance().getIntSIIE001EQL().query(requestId, eqlQuery);
			System.out.println("Returning...");
			return new WSReturnValueEQL(ret);
		} catch(RejectException e) {
			ReturnValueEQL rveql=new ReturnValueEQL();
			rveql.setRequestId(requestId);
			rveql.setReasonCode(e.getReason().toString());
			return new WSReturnValueEQL(rveql);
		} catch(Exception e) {
			e.printStackTrace();
			ReturnValueEQL rveql=new ReturnValueEQL();
			rveql.setRequestId(requestId);
			rveql.setReasonCode(CSReason.REAS02.toString());
			return new WSReturnValueEQL(rveql);
		}
	}
}