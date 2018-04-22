
package sk.stuba.fiit.labss2.pis.students.team076zlava.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Zlavas complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Zlavas">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hodnota" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pocet_nakupov" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Zlavas", propOrder = {
    "id",
    "name",
    "hodnota",
    "pocetNakupov"
})
public class Zlavas {

    protected int id;
    @XmlElement(required = true)
    protected String name;
    protected int hodnota;
    @XmlElement(name = "pocet_nakupov")
    protected int pocetNakupov;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the hodnota property.
     * 
     */
    public int getHodnota() {
        return hodnota;
    }

    /**
     * Sets the value of the hodnota property.
     * 
     */
    public void setHodnota(int value) {
        this.hodnota = value;
    }

    /**
     * Gets the value of the pocetNakupov property.
     * 
     */
    public int getPocetNakupov() {
        return pocetNakupov;
    }

    /**
     * Sets the value of the pocetNakupov property.
     * 
     */
    public void setPocetNakupov(int value) {
        this.pocetNakupov = value;
    }

}
