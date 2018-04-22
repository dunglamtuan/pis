
package sk.stuba.fiit.labss2.pis.students.team076hodnotenie.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Hodnotenies complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Hodnotenies">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zakaznik_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="kaviaren_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="hodnota" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="datum_pridania" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="bolo_videne" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Hodnotenies", propOrder = {
    "id",
    "name",
    "zakaznikId",
    "kaviarenId",
    "hodnota",
    "datumPridania",
    "boloVidene"
})
public class Hodnotenies {

    protected int id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(name = "zakaznik_id")
    protected int zakaznikId;
    @XmlElement(name = "kaviaren_id")
    protected int kaviarenId;
    protected int hodnota;
    @XmlElement(name = "datum_pridania", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumPridania;
    @XmlElement(name = "bolo_videne")
    protected boolean boloVidene;

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
     * Gets the value of the datumPridania property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumPridania() {
        return datumPridania;
    }

    /**
     * Sets the value of the datumPridania property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumPridania(XMLGregorianCalendar value) {
        this.datumPridania = value;
    }

    /**
     * Gets the value of the boloVidene property.
     * 
     */
    public boolean isBoloVidene() {
        return boloVidene;
    }

    /**
     * Sets the value of the boloVidene property.
     * 
     */
    public void setBoloVidene(boolean value) {
        this.boloVidene = value;
    }

}
