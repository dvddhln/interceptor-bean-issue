package runtime;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

@RunWith(Arquillian.class)
public class TestCircuit {

    private Client client;

    @Before
    public void setup() throws Exception {
        client = ClientBuilder.newClient();
    }

    @After
    public void tearDown() throws Exception {
        client.close();
    }


    @ArquillianResource
    protected URI baseURL;

    @Deployment(testable = false)
    public static Archive<?> createDeployment() throws Exception {
        WebArchive deployment = ShrinkWrap.create(WebArchive.class);

        deployment.addPackage(AnApplication.class.getPackage());
        deployment.addAsResource("project-defaults.yml", "project-defaults.yml");
        return deployment;
    }

    @Test
    public void testGetTest() throws Exception {

        String response = client.target(baseURL + "/rest")
                .request().get(String.class);

        Assert.assertEquals("test", response);

    }


}
