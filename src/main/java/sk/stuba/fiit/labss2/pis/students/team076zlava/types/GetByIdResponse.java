
package sk.stuba.fiit.labss2.pis.students.team076zlava.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getByIdResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getByIdResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zlava" type="{http://labss2.fiit.stuba.sk/pis/students/team076zlava/types}Zlava"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getByIdResponse", propOrder = {
    "zlava"
})
public class GetByIdResponse {

    @XmlElement(required = true)
    protected Zlava zlava;

    /**
     * Gets the value of the zlava property.
     * 
     * @return
     *     possible object is
     *     {@link Zlava }
     *     
     */
    public Zlava getZlava() {
        return zlava;
    }

    /**
     * Sets the value of the zlava property.
     * 
     * @param value
     *     allowed object is
     *     {@link Zlava }
     *     
     */
    public void setZlava(Zlava value) {
        this.zlava = value;
    }

}
