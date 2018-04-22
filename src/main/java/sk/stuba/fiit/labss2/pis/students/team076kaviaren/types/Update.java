
package sk.stuba.fiit.labss2.pis.students.team076kaviaren.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for update complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="update">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="team_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="team_password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="entity_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Kaviaren" type="{http://labss2.fiit.stuba.sk/pis/students/team076kaviaren/types}Kaviaren"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "update", propOrder = {
    "teamId",
    "teamPassword",
    "entityId",
    "kaviaren"
})
public class Update {

    @XmlElement(name = "team_id", required = true)
    protected String teamId;
    @XmlElement(name = "team_password", required = true)
    protected String teamPassword;
    @XmlElement(name = "entity_id")
    protected int entityId;
    @XmlElement(name = "Kaviaren", required = true)
    protected Kaviaren kaviaren;

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
     * Gets the value of the entityId property.
     * 
     */
    public int getEntityId() {
        return entityId;
    }

    /**
     * Sets the value of the entityId property.
     * 
     */
    public void setEntityId(int value) {
        this.entityId = value;
    }

    /**
     * Gets the value of the kaviaren property.
     * 
     * @return
     *     possible object is
     *     {@link Kaviaren }
     *     
     */
    public Kaviaren getKaviaren() {
        return kaviaren;
    }

    /**
     * Sets the value of the kaviaren property.
     * 
     * @param value
     *     allowed object is
     *     {@link Kaviaren }
     *     
     */
    public void setKaviaren(Kaviaren value) {
        this.kaviaren = value;
    }

}
