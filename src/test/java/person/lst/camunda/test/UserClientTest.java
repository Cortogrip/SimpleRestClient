package person.lst.camunda.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class UserClientTest {

    static Logger logger = Logger.getLogger(UserClientTest.class.getName());

    private static UserClient userClient;

    private static Page page1;

    @BeforeAll
    static void getFirstPage() throws Exception {

        try {
            userClient = new UserClient();
            page1 = userClient.getPage(1);
            assertNotNull(page1);

        } catch (Exception ex) {
            logger.severe("Cannot get page 1 [" + ex + "]");
            throw ex;
        }
    }


    /**
     * @throws Exception
     */
    @Test
    void getUsersTest() throws Exception {

        int nbOffoundItems = 0;
        for(int pageIndex=1; pageIndex <= page1.nbOfPages;  pageIndex++){

            Page currentPage = userClient.getPage(1);
            List<User> userList = userClient.getUsers(pageIndex);
            int listSize = userList.size();

            // If this is not the last page we check that the number of users returned matches the nominal page size
            if(pageIndex < page1.nbOfPages){
                assertEquals(currentPage.nbOfUserPerPage, listSize, "Page is not complete");
            }

            nbOffoundItems = nbOffoundItems + listSize;

        }

        // Check that we found all users
        assertEquals(page1.nbOfUsers, nbOffoundItems, "Invalid number of user found");

    }

    @Test
    void getEmptyPageTest() throws Exception {

        try {
            List<User> userList = userClient.getUsers(page1.nbOfPages + 1);
            assertEquals(0, userList.size(), "Invalid data found on page " + page1.nbOfPages + 1);

        } catch (Exception ex) {
            logger.severe("Cannot get page 1 [" + ex + "]");
            throw ex;
        }

    }

    @Test
    void getFirstUser() throws Exception {
        assertEquals("George", page1.getUsers().get(0).firstName, "Invalid first user found ");

    }


}