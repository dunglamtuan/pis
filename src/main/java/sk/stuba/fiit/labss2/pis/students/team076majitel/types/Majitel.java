
package sk.stuba.fiit.labss2.pis.students.team076majitel.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Majitel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Majitel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="notifikacia" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="hodnota_notifikacie" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Majitel", propOrder = {
    "id",
    "name",
    "notifikacia",
    "hodnotaNotifikacie"
})
public class Majitel {

    protected int id;
    @XmlElement(required = true)
    protected String name;
    protected boolean notifikacia;
    @XmlElement(name = "hodnota_notifikacie")
    protected int hodnotaNotifikacie;

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
     * Gets the value of the notifikacia property.
     * 
     */
    public boolean isNotifikacia() {
        return notifikacia;
    }

    /**
     * Sets the value of the notifikacia property.
     * 
     */
    public void setNotifikacia(boolean value) {
        this.notifikacia = value;
    }

    /**
     * Gets the value of the hodnotaNotifikacie property.
     * 
     */
    public int getHodnotaNotifikacie() {
        return hodnotaNotifikacie;
    }

    /**
     * Sets the value of the hodnotaNotifikacie property.
     * 
     */
    public void setHodnotaNotifikacie(int value) {
        this.hodnotaNotifikacie = value;
    }

}
