package person.lst.camunda.test;

// Imports
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.logging.Logger;

public class UserClient {

    private static final String SERVICE_URL = "https://reqres.in/api/users";
    private static final String PROXY_HOST  = null;
    private static final String PROXY_PORT  = "8080" ;


    Logger logger = Logger.getLogger(UserClient.class.getName());

    public static void main(String[] args) throws Exception {

        UserClient userClient = new UserClient();
        Page page1 = userClient.getPage(1);
        System.out.println("------------------------------------------------------");
        System.out.println("User list ");
        System.out.println("------------------------------------------------------");
        for(int pageIndex=1; pageIndex <= page1.nbOfPages;  pageIndex++){

            List<User> userList = userClient.getUsers(pageIndex);
            for (User user: userList) {

                System.out.println(
                        "User : " + user.id +
                        ", First name : " + user.firstName +
                        ", Family name : " + user.lastName);

            }

        }
    }

    /**
     * Get User page
     * @param pageIndex
     * @return
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    public Page getPage(int pageIndex) throws Exception {
        return getPage(pageIndex, null, null);
    }

    /**
     *  Get a page using proxy
     * @param pageIndex
     * @param proxyHost
     * @param proxyPort
     * @return
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    public Page getPage(int pageIndex, String proxyHost, String proxyPort)
            throws Exception {

        Page page = null;

        HttpClient.Builder builder = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2);
        if (proxyHost != null && proxyPort != null) {
            builder.proxy(ProxySelector.of(new InetSocketAddress(proxyHost, Integer.parseInt(proxyPort))));
        }
        HttpClient client =  builder.build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(SERVICE_URL + "?page=" + pageIndex)).GET().build();


        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        logger.fine( response.body());

        if (response.statusCode()==200){

            ObjectMapper objectMapper = new ObjectMapper();
            page = objectMapper.readValue(response.body(), Page.class);

        } else {
            throw new UserClientException("Cannot get page - Check service");
        }

        logger.fine(page.toString());

        return page;
    }

    public List<User> getUsers(int pageIndex) throws Exception {
        return this.getUsers(pageIndex, null, null);
    }

    /**
     * Get Page users
     * @param pageIndex Index of the page to load
     * @return List of users for the given page
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    public List<User> getUsers(int pageIndex, String proxyHost, String proxyPort) throws Exception {

        List<User> users ;
        Page page = this.getPage(pageIndex, proxyHost, proxyPort);

        if (page!=null){

            users = page.getUsers();

            for (User user : users ) {
                logger.fine( user.toString() );
            }

        } else {
            throw new UserClientException("Cannot get users - Check service");
        }

        return users;

    }

}