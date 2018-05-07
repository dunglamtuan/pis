
package sk.stuba.fiit.labss2.pis.validator.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sk.stuba.fiit.labss2.pis.validator.types package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ValidatePhone_QNAME = new QName("http://labss2.fiit.stuba.sk/pis/validator/types", "validatePhone");
    private final static QName _ValidateEmail_QNAME = new QName("http://labss2.fiit.stuba.sk/pis/validator/types", "validateEmail");
    private final static QName _ValidateEmailResponse_QNAME = new QName("http://labss2.fiit.stuba.sk/pis/validator/types", "validateEmailResponse");
    private final static QName _ValidatePhoneResponse_QNAME = new QName("http://labss2.fiit.stuba.sk/pis/validator/types", "validatePhoneResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sk.stuba.fiit.labss2.pis.validator.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidateEmail }
     * 
     */
    public ValidateEmail createValidateEmail() {
        return new ValidateEmail();
    }

    /**
     * Create an instance of {@link ValidatePhoneResponse }
     * 
     */
    public ValidatePhoneResponse createValidatePhoneResponse() {
        return new ValidatePhoneResponse();
    }

    /**
     * Create an instance of {@link ValidatePhone }
     * 
     */
    public ValidatePhone createValidatePhone() {
        return new ValidatePhone();
    }

    /**
     * Create an instance of {@link ValidateEmailResponse }
     * 
     */
    public ValidateEmailResponse createValidateEmailResponse() {
        return new ValidateEmailResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidatePhone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://labss2.fiit.stuba.sk/pis/validator/types", name = "validatePhone")
    public JAXBElement<ValidatePhone> createValidatePhone(ValidatePhone value) {
        return new JAXBElement<ValidatePhone>(_ValidatePhone_QNAME, ValidatePhone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://labss2.fiit.stuba.sk/pis/validator/types", name = "validateEmail")
    public JAXBElement<ValidateEmail> createValidateEmail(ValidateEmail value) {
        return new JAXBElement<ValidateEmail>(_ValidateEmail_QNAME, ValidateEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://labss2.fiit.stuba.sk/pis/validator/types", name = "validateEmailResponse")
    public JAXBElement<ValidateEmailResponse> createValidateEmailResponse(ValidateEmailResponse value) {
        return new JAXBElement<ValidateEmailResponse>(_ValidateEmailResponse_QNAME, ValidateEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidatePhoneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://labss2.fiit.stuba.sk/pis/validator/types", name = "validatePhoneResponse")
    public JAXBElement<ValidatePhoneResponse> createValidatePhoneResponse(ValidatePhoneResponse value) {
        return new JAXBElement<ValidatePhoneResponse>(_ValidatePhoneResponse_QNAME, ValidatePhoneResponse.class, null, value);
    }

}
