
package sk.stuba.fiit.labss2.pis.students.team076hodnotenie;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "Team076HodnotenieService", targetNamespace = "http://labss2.fiit.stuba.sk/pis/students/team076hodnotenie", wsdlLocation = "http://labss2.fiit.stuba.sk/pis/ws/Students/Team076Hodnotenie?WSDL")
public class Team076HodnotenieService
    extends Service
{

    private final static URL TEAM076HODNOTENIESERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(sk.stuba.fiit.labss2.pis.students.team076hodnotenie.Team076HodnotenieService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = sk.stuba.fiit.labss2.pis.students.team076hodnotenie.Team076HodnotenieService.class.getResource(".");
            url = new URL(baseUrl, "http://labss2.fiit.stuba.sk/pis/ws/Students/Team076Hodnotenie?WSDL");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://labss2.fiit.stuba.sk/pis/ws/Students/Team076Hodnotenie?WSDL', retrying as a local file");
            logger.warning(e.getMessage());
        }
        TEAM076HODNOTENIESERVICE_WSDL_LOCATION = url;
    }

    public Team076HodnotenieService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Team076HodnotenieService() {
        super(TEAM076HODNOTENIESERVICE_WSDL_LOCATION, new QName("http://labss2.fiit.stuba.sk/pis/students/team076hodnotenie", "Team076HodnotenieService"));
    }

    /**
     * 
     * @return
     *     returns Team076HodnoteniePortType
     */
    @WebEndpoint(name = "Team076HodnoteniePort")
    public Team076HodnoteniePortType getTeam076HodnoteniePort() {
        return super.getPort(new QName("http://labss2.fiit.stuba.sk/pis/students/team076hodnotenie", "Team076HodnoteniePort"), Team076HodnoteniePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Team076HodnoteniePortType
     */
    @WebEndpoint(name = "Team076HodnoteniePort")
    public Team076HodnoteniePortType getTeam076HodnoteniePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://labss2.fiit.stuba.sk/pis/students/team076hodnotenie", "Team076HodnoteniePort"), Team076HodnoteniePortType.class, features);
    }

}
