package org.sigaim.siie.ws;

import java.io.ByteArrayInputStream;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.openehr.am.parser.ContentObject;
import org.sigaim.siie.interfaces.reportmanagement.ReportStatus;
import org.sigaim.siie.interfaces.reportmanagement.ReturnValueCreateHealthcareFacility;
import org.sigaim.siie.interfaces.reportmanagement.ReturnValueCreatePerformer;
import org.sigaim.siie.interfaces.reportmanagement.ReturnValueCreateReport;
import org.sigaim.siie.interfaces.reportmanagement.ReturnValueCreateSubjectOfCare;
import org.sigaim.siie.interfaces.reportmanagement.ReturnValueUpdateReport;
import org.sigaim.siie.iso13606.rm.CDCV;
import org.sigaim.siie.iso13606.rm.FunctionalRole;
import org.sigaim.siie.iso13606.rm.II;
import org.sigaim.siie.iso13606.rm.VersionStatus;
import org.sigaim.siie.rm.exceptions.CSReason;
import org.sigaim.siie.rm.exceptions.ReferenceModelException;
import org.sigaim.siie.rm.exceptions.RejectException;

@WebService
public class INTSIIE004ReportManagementImpl {
	
	protected <T extends Object> T bindFromDADL(String dadl, Class<T> type) throws ReferenceModelException {
		ContentObject parsedDADL=ServiceInjector.getInstance().getDADLManager().parseDADL(new ByteArrayInputStream(dadl.getBytes()));
		return  type.cast(ServiceInjector.getInstance().getReferenceModelManager().bind(parsedDADL));
	}
	
	@WebMethod
	public WSReturnValueCreateHealthcareFacility createHealthcareFacility(String requestId) {
		ReturnValueCreateHealthcareFacility ret=null;
		try {
			ret=ServiceInjector.getInstance().getIntSIIE004ReportManagement().createHealthcareFacility(requestId);
		} catch(RejectException e) {
			System.out.println("ERROR");
			e.printStackTrace();
			ret=new ReturnValueCreateHealthcareFacility();
			ret.setRequestId(requestId);
			ret.setReasonCode(e.getReason().toString());
		}
		return new WSReturnValueCreateHealthcareFacility(ret);
	}
	@WebMethod
	public WSReturnValueCreateSubjectOfCare createSubjectOfCare(String requestId) {
		ReturnValueCreateSubjectOfCare ret=null;
		try {
			ret=ServiceInjector.getInstance().getIntSIIE004ReportManagement().createSubjectOfCare(requestId);
		} catch(RejectException e) {
			System.out.println("ERROR");
			e.printStackTrace();
			ret=new ReturnValueCreateSubjectOfCare();
			ret.setRequestId(requestId);
			ret.setReasonCode(e.getReason().toString());
		}
		return new WSReturnValueCreateSubjectOfCare(ret);
	}
	@WebMethod
	public WSReturnValueCreatePerformer createPerformer(String requestId)  {
		ReturnValueCreatePerformer ret=null;
		try {
			ret=ServiceInjector.getInstance().getIntSIIE004ReportManagement().createPerformer(requestId);
		} catch(RejectException e) {
			System.out.println("ERROR");
			e.printStackTrace();
			ret=new ReturnValueCreatePerformer();
			ret.setRequestId(requestId);
			ret.setReasonCode(e.getReason().toString());
		}
		return new WSReturnValueCreatePerformer(ret);
	}
 
	@WebMethod
	public WSReturnValueCreateReport createReport(
			String requestId,
			String ehrId, //II
			String composerId, //FunctionalRole
			String textTranscription,
			boolean dictated, //CDCV
			String rootArchetypeId //II
			)  {
		ReturnValueCreateReport ret=null;
		try {
			ret=ServiceInjector.getInstance().getIntSIIE004ReportManagement().createReport(requestId, bindFromDADL(ehrId,II.class), bindFromDADL(composerId,FunctionalRole.class), textTranscription, dictated, bindFromDADL(rootArchetypeId,II.class));
		} catch(RejectException e) {
			System.out.println("ERROR");
			e.printStackTrace();
			ret=new ReturnValueCreateReport();
			ret.setRequestId(requestId);
			ret.setReasonCode(e.getReason().toString());
		} catch(Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
			ret=new ReturnValueCreateReport();
			ret.setRequestId(requestId);
			ret.setReasonCode(CSReason.REAS02.toString());
		}
		return new WSReturnValueCreateReport(ret);
	}
	@WebMethod
	public WSReturnValueUpdateReport updateReport(
			String requestId,
			String ehrId, //II
			String previousVersionId, //II
			String composerId, //FunctionalRole
			String textTranscription,
			boolean dictated, //CDCV
			boolean signed,
			boolean confirmed,
			String rootArchetypeId, //II,
			String encodedConcepts
			)  {
		ReturnValueUpdateReport ret=null;
		try {
			ReportStatus rstatus=new ReportStatus();
			rstatus.setDictated(dictated);
			rstatus.setConfirmed(confirmed);
			rstatus.setSigned(signed);
			ret=ServiceInjector.getInstance().getIntSIIE004ReportManagement().updateReport(requestId, bindFromDADL(ehrId,II.class), bindFromDADL(previousVersionId,II.class), bindFromDADL(composerId,FunctionalRole.class), textTranscription, rstatus, bindFromDADL(rootArchetypeId,II.class),encodedConcepts);
		} catch(RejectException e) {
			System.out.println("ERROR");
			e.printStackTrace();
			ret=new ReturnValueUpdateReport();
			ret.setRequestId(requestId);
			ret.setReasonCode(e.getReason().toString());
		} catch(Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
			ret=new ReturnValueUpdateReport();
			ret.setRequestId(requestId);
			ret.setReasonCode(CSReason.REAS02.toString());
		}
		return new WSReturnValueUpdateReport(ret);
	}
 
}
