
package sk.stuba.fiit.labss2.pis.students.team076zlava.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getByNumericCondition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getByNumericCondition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="attribute_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="attribute_value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="math_condition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ids" type="{http://labss2.fiit.stuba.sk/pis/students/team076zlava/types}ArrayOfIds"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getByNumericCondition", propOrder = {
    "attributeName",
    "attributeValue",
    "mathCondition",
    "ids"
})
public class GetByNumericCondition {

    @XmlElement(name = "attribute_name", required = true)
    protected String attributeName;
    @XmlElement(name = "attribute_value", required = true)
    protected String attributeValue;
    @XmlElement(name = "math_condition", required = true)
    protected String mathCondition;
    @XmlElement(required = true)
    protected ArrayOfIds ids;

    /**
     * Gets the value of the attributeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * Sets the value of the attributeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeName(String value) {
        this.attributeName = value;
    }

    /**
     * Gets the value of the attributeValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeValue() {
        return attributeValue;
    }

    /**
     * Sets the value of the attributeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeValue(String value) {
        this.attributeValue = value;
    }

    /**
     * Gets the value of the mathCondition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMathCondition() {
        return mathCondition;
    }

    /**
     * Sets the value of the mathCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMathCondition(String value) {
        this.mathCondition = value;
    }

    /**
     * Gets the value of the ids property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIds }
     *     
     */
    public ArrayOfIds getIds() {
        return ids;
    }

    /**
     * Sets the value of the ids property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIds }
     *     
     */
    public void setIds(ArrayOfIds value) {
        this.ids = value;
    }

}
