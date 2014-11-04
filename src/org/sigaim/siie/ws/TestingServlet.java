package org.sigaim.siie.ws;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestingServlet
 */
public class TestingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestingServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void fail(PrintWriter out, String message) {
    	out.println("SERVICE ASSERTION FAILED: "+message);
    }
    protected void success(PrintWriter out) {
    	out.println("SERVICE OK");
    	out.println("");
    	out.println("USES SAPRM: "+ServiceInjector.getInstance().getUseSaprm());
    	out.println("SAPRM ENDPOINT: "+ServiceInjector.getInstance().getSaprm_endpoint());
    	out.println("SGM ENDPOINT: "+ServiceInjector.getInstance().getSgm_endpoint());

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		boolean failed=false;
		if(ServiceInjector.getInstance().getDADLManager()==null) {
			fail(out,"Invalid DADL manager, this should never happen");
			failed=true;
		}
		if(ServiceInjector.getInstance().getDs()==null) {
			fail(out,"Database datasource is null");
			failed=true;
		}
		if(ServiceInjector.getInstance().getIntSIIE001EQL()==null) {
			fail(out,"IntSIIE001EQ is null, check database connection");
			failed=true;
		}
		if(ServiceInjector.getInstance().getIntSIIE003Terminologies()==null) {
			fail(out,"IntSIIE003Terminologies is null, check SGM endpoint connection");
			failed=true;
		}
		if(ServiceInjector.getInstance().getIntSIIE004ReportManagement()==null) {
			fail(out,"IntSIIE004ReportManagement is null, check DB connection and SAPRM endpoint connection");
			failed=true;
		}
		if(ServiceInjector.getInstance().getPersistenceManager()==null) {
			fail(out,"PersistenceManager is null, check DB connection");
			failed=true;
		}
		if(ServiceInjector.getInstance().getReferenceModelManager()==null) {
			fail(out,"ReferenceModelManager is null, this should never happen");
			failed=true;
		}
		if(ServiceInjector.getInstance().getSAPRM()==null) {
			fail(out,"SAPRM is null, check SAPRM endpoint connection");
			failed=true;
		}
		if(ServiceInjector.getInstance().getSEQLEngine()==null) {
			fail(out,"SEQLEngine is null, check database connection");
			failed=true;
		}
		if(!failed) {
			success(out);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
