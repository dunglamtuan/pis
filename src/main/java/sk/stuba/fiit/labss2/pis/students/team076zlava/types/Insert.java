
package sk.stuba.fiit.labss2.pis.students.team076zlava.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for insert complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="insert">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="team_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="team_password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Zlava" type="{http://labss2.fiit.stuba.sk/pis/students/team076zlava/types}Zlava"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insert", propOrder = {
    "teamId",
    "teamPassword",
    "zlava"
})
public class Insert {

    @XmlElement(name = "team_id", required = true)
    protected String teamId;
    @XmlElement(name = "team_password", required = true)
    protected String teamPassword;
    @XmlElement(name = "Zlava", required = true)
    protected Zlava zlava;

    /**
     * Gets the value of the teamId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeamId() {
        return teamId;
    }

    /**
     * Sets the value of the teamId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeamId(String value) {
        this.teamId = value;
    }

    /**
     * Gets the value of the teamPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeamPassword() {
        return teamPassword;
    }

    /**
     * Sets the value of the teamPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeamPassword(String value) {
        this.teamPassword = value;
    }

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
