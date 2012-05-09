
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
 *         &lt;element name="CreatedAfter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreatedBefore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="JobFlowIds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="JobFlowStates" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
    "createdAfter",
    "createdBefore",
    "jobFlowIds",
    "jobFlowStates"
})
@XmlRootElement(name = "DescribeJobFlowsRequest")
public class DescribeJobFlowsRequest {

    @XmlElement(name = "CreatedAfter")
    protected String createdAfter;
    @XmlElement(name = "CreatedBefore")
    protected String createdBefore;
    @XmlElement(name = "JobFlowIds")
    protected List<String> jobFlowIds;
    @XmlElement(name = "JobFlowStates")
    protected List<String> jobFlowStates;

    /**
     * Default constructor
     * 
     */
    public DescribeJobFlowsRequest() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public DescribeJobFlowsRequest(final String createdAfter, final String createdBefore, final List<String> jobFlowIds, final List<String> jobFlowStates) {
        this.createdAfter = createdAfter;
        this.createdBefore = createdBefore;
        this.jobFlowIds = jobFlowIds;
        this.jobFlowStates = jobFlowStates;
    }

    /**
     * Gets the value of the createdAfter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedAfter() {
        return createdAfter;
    }

    /**
     * Sets the value of the createdAfter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedAfter(String value) {
        this.createdAfter = value;
    }

    public boolean isSetCreatedAfter() {
        return (this.createdAfter!= null);
    }

    /**
     * Gets the value of the createdBefore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedBefore() {
        return createdBefore;
    }

    /**
     * Sets the value of the createdBefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedBefore(String value) {
        this.createdBefore = value;
    }

    public boolean isSetCreatedBefore() {
        return (this.createdBefore!= null);
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
     * Gets the value of the jobFlowStates property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jobFlowStates property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJobFlowStates().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getJobFlowStates() {
        if (jobFlowStates == null) {
            jobFlowStates = new ArrayList<String>();
        }
        return this.jobFlowStates;
    }

    public boolean isSetJobFlowStates() {
        return ((this.jobFlowStates!= null)&&(!this.jobFlowStates.isEmpty()));
    }

    public void unsetJobFlowStates() {
        this.jobFlowStates = null;
    }

    /**
     * Sets the value of the CreatedAfter property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public DescribeJobFlowsRequest withCreatedAfter(String value) {
        setCreatedAfter(value);
        return this;
    }

    /**
     * Sets the value of the CreatedBefore property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public DescribeJobFlowsRequest withCreatedBefore(String value) {
        setCreatedBefore(value);
        return this;
    }

    /**
     * Sets the value of the JobFlowIds property.
     * 
     * @param values
     * @return
     *     this instance
     */
    public DescribeJobFlowsRequest withJobFlowIds(String... values) {
        for (String value: values) {
            getJobFlowIds().add(value);
        }
        return this;
    }

    /**
     * Sets the value of the JobFlowStates property.
     * 
     * @param values
     * @return
     *     this instance
     */
    public DescribeJobFlowsRequest withJobFlowStates(String... values) {
        for (String value: values) {
            getJobFlowStates().add(value);
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
     * Sets the value of the jobFlowStates property.
     * 
     * @param jobFlowStates
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobFlowStates(List<String> jobFlowStates) {
        this.jobFlowStates = jobFlowStates;
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
        if (isSetCreatedAfter()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("CreatedAfter"));
            json.append(" : ");
            json.append(quoteJSON(getCreatedAfter()));
            first = false;
        }
        if (isSetCreatedBefore()) {
            if (!first) json.append(", ");
            json.append(quoteJSON("CreatedBefore"));
            json.append(" : ");
            json.append(quoteJSON(getCreatedBefore()));
            first = false;
        }
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
        if (isSetJobFlowStates()) {
            if (!first) json.append(", ");
            json.append("\"JobFlowStates\" : [");
            java.util.List<String> jobFlowStatesList  =  getJobFlowStates();
            int jobFlowStatesListIndex  =  0;
            for (String jobFlowStates : jobFlowStatesList) {
                if (jobFlowStatesListIndex > 0) json.append(", ");
                    json.append(quoteJSON(jobFlowStates));
                ++jobFlowStatesListIndex;
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