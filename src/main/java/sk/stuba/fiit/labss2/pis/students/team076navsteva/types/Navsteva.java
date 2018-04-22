
package sk.stuba.fiit.labss2.pis.students.team076navsteva.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Navsteva complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Navsteva">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zakaznik_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="kaviaren_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pocet_navstev" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Navsteva", propOrder = {
    "id",
    "name",
    "zakaznikId",
    "kaviarenId",
    "pocetNavstev"
})
public class Navsteva {

    protected int id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(name = "zakaznik_id")
    protected int zakaznikId;
    @XmlElement(name = "kaviaren_id")
    protected int kaviarenId;
    @XmlElement(name = "pocet_navstev")
    protected int pocetNavstev;

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
     * Gets the value of the zakaznikId property.
     * 
     */
    public int getZakaznikId() {
        return zakaznikId;
    }

    /**
     * Sets the value of the zakaznikId property.
     * 
     */
    public void setZakaznikId(int value) {
        this.zakaznikId = value;
    }

    /**
     * Gets the value of the kaviarenId property.
     * 
     */
    public int getKaviarenId() {
        return kaviarenId;
    }

    /**
     * Sets the value of the kaviarenId property.
     * 
     */
    public void setKaviarenId(int value) {
        this.kaviarenId = value;
    }

    /**
     * Gets the value of the pocetNavstev property.
     * 
     */
    public int getPocetNavstev() {
        return pocetNavstev;
    }

    /**
     * Sets the value of the pocetNavstev property.
     * 
     */
    public void setPocetNavstev(int value) {
        this.pocetNavstev = value;
    }

}
