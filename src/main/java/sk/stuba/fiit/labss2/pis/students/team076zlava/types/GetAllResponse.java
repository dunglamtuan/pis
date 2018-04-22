
package sk.stuba.fiit.labss2.pis.students.team076zlava.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAllResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAllResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zlavas" type="{http://labss2.fiit.stuba.sk/pis/students/team076zlava/types}ArrayOfZlavas"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllResponse", propOrder = {
    "zlavas"
})
public class GetAllResponse {

    @XmlElement(required = true)
    protected ArrayOfZlavas zlavas;

    /**
     * Gets the value of the zlavas property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfZlavas }
     *     
     */
    public ArrayOfZlavas getZlavas() {
        return zlavas;
    }

    /**
     * Sets the value of the zlavas property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfZlavas }
     *     
     */
    public void setZlavas(ArrayOfZlavas value) {
        this.zlavas = value;
    }

}
