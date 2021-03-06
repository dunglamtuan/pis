
package sk.stuba.fiit.labss2.pis.students.team076zakaznik.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getByAttributeValueResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getByAttributeValueResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zakazniks" type="{http://labss2.fiit.stuba.sk/pis/students/team076zakaznik/types}ArrayOfZakazniks"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getByAttributeValueResponse", propOrder = {
    "zakazniks"
})
public class GetByAttributeValueResponse {

    @XmlElement(required = true)
    protected ArrayOfZakazniks zakazniks;

    /**
     * Gets the value of the zakazniks property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfZakazniks }
     *     
     */
    public ArrayOfZakazniks getZakazniks() {
        return zakazniks;
    }

    /**
     * Sets the value of the zakazniks property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfZakazniks }
     *     
     */
    public void setZakazniks(ArrayOfZakazniks value) {
        this.zakazniks = value;
    }

}
