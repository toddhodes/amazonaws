
package com.amazonaws.elasticmapreduce.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="JobFlowIds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * Generated by AWS Code Generator
 * <p/>
 * Tue Apr 21 15:28:27 PDT 2009
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "jobFlowIds"
})
@XmlRootElement(name = "TerminateJobFlowsRequest")
public class TerminateJobFlowsRequest {

    @XmlElement(name = "JobFlowIds", required = true)
    protected List<String> jobFlowIds;

    /**
     * Default constructor
     * 
     */
    public TerminateJobFlowsRequest() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public TerminateJobFlowsRequest(final List<String> jobFlowIds) {
        this.jobFlowIds = jobFlowIds;
    }

    /**
     * Gets the value of the jobFlowIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jobFlowIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJobFlowIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getJobFlowIds() {
        if (jobFlowIds == null) {
            jobFlowIds = new ArrayList<String>();
        }
        return this.jobFlowIds;
    }

    public boolean isSetJobFlowIds() {
        return ((this.jobFlowIds!= null)&&(!this.jobFlowIds.isEmpty()));
    }

    public void unsetJobFlowIds() {
        this.jobFlowIds = null;
    }

    /**
     * Sets the value of the JobFlowIds property.
     * 
     * @param values
     * @return
     *     this instance
     */
    public TerminateJobFlowsRequest withJobFlowIds(String... values) {
        for (String value: values) {
            getJobFlowIds().add(value);
        }
        return this;
    }

    /**
     * Sets the value of the jobFlowIds property.
     * 
     * @param jobFlowIds
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobFlowIds(List<String> jobFlowIds) {
        this.jobFlowIds = jobFlowIds;
    }
    


    /**
     *
     * JSON fragment representation of this object
     *
     * @return JSON fragment for this object. Name for outer
     * object expected to be set by calling method. This fragment
     * returns inner properties representation only
     *
     */
    protected String toJSONFragment() {
        StringBuffer json = new StringBuffer();
        boolean first = true;
        if (isSetJobFlowIds()) {
            if (!first) json.append(", ");
            json.append("\"JobFlowIds\" : [");
            java.util.List<String> jobFlowIdsList  =  getJobFlowIds();
            int jobFlowIdsListIndex  =  0;
            for (String jobFlowIds : jobFlowIdsList) {
                if (jobFlowIdsListIndex > 0) json.append(", ");
                    json.append(quoteJSON(jobFlowIds));
                ++jobFlowIdsListIndex;
            }
            json.append("]");
            first = false;
        }
        return json.toString();
    }

    /**
     *
     * Quote JSON string
     */
    private String quoteJSON(String string) {
        StringBuffer sb = new StringBuffer();
        sb.append("\"");
        int length = string.length();
        for (int i = 0; i < length; ++i) {
            char c = string.charAt(i);
            switch (c) {
            case '"':
                sb.append("\\\"");
                break;
            case '\\':
                sb.append("\\\\");
                break;
            case '/':
                sb.append("\\/");
                break;
            case '\b':
                sb.append("\\b");
                break;
            case '\f':
                sb.append("\\f");
                break;
            case '\n':
                sb.append("\\n");
                break;
            case '\r':
                sb.append("\\r");
                break;
            case '\t':
                sb.append("\\t");
                break;
            default:
                if (c <  ' ') {
                    sb.append("\\u" + String.format("%03x", Integer.valueOf(c)));
                } else {
                sb.append(c);
            }
        }
        }
        sb.append("\"");
        return sb.toString();
    }


}
