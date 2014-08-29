package org.sigaim.siie.ws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.sigaim.siie.interfaces.reportmanagement.ReturnValueCreateSubjectOfCare;
import org.sigaim.siie.interfaces.terminologies.ReturnValueSynonyms;
import org.sigaim.siie.rm.exceptions.RejectException;

@WebService
public class INTSIIE003TerminologiesImpl {
	@WebMethod
	public WSReturnValueSynonyms requestSynonyms(String requestId,
			String[] conceptIds) {
		ReturnValueSynonyms ret;
		try {
			ret=ServiceInjector.getInstance().getIntSIIE003Terminologies().requestSynonyms(requestId, new ArrayList<String>(Arrays.asList(conceptIds)));
		} catch(RejectException e) {
			ret=new ReturnValueSynonyms();
			ret.setRequestId(requestId);
			ret.setReasonCode(e.getReason().toString());
		}
		return new WSReturnValueSynonyms(ret);
	}
}
