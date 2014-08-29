package org.sigaim.siie.ws;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.sigaim.siie.interfaces.terminologies.ReturnValueSynonyms;

public class WSReturnValueSynonyms {
	private String requestId;
	private String reasonCode;
	private HashMap<String,String[]> synonyms;
	
	public WSReturnValueSynonyms() {
		
	}
	public WSReturnValueSynonyms(ReturnValueSynonyms synonyms) {
		this.requestId=synonyms.getRequestId();
		this.reasonCode=synonyms.getReasonCode();
		this.synonyms=new HashMap<String,String[]> ();
		if(synonyms.getSynonyms()!=null) {
			for(Entry<String,Set<String>> entry : synonyms.getSynonyms().entrySet()) {
				String[] array=new String[entry.getValue().size()];
				array=entry.getValue().toArray(array);
				this.synonyms.put(entry.getKey(),array);
			}
		}
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
	public HashMap<String,String[]>  getSynonyms() {
		return synonyms;
	}
	public void setSynonyms(HashMap<String,String[]>  synonyms) {
		this.synonyms = synonyms;
	}

}
