/*----------------------------------------------------------------------------------------------------------------------
 * Copyright 2023 - Sopra Steria
 * NOTICE:  All information  contained herein is, and  remains  the property  of Soptra Steria  and  its suppliers,  if
 * any.  The  intellectual  and technical  concepts contained herein are proprietary to Soptra Steria and its suppliers
 * and may  be covered  by European  and  Foreign Patents, and are protected  by trade secret or copyright law.
 * Dissemination  of  this information  or reproduction of  this  material is strictly forbidden unless  prior  written
 * permission  is  obtained   from Sopra Steria.
 * ---------------------------------------------------------------------------------------------------------------------
 * Created by Sopra Steria on 26/07/2023
 *
 * ------------------------------------------------------------------------------------------------------------------ */
package person.lst.camunda.test;

// Imports

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Page
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Page {

    @JsonProperty("page")
    protected int pageIndex;

    @JsonProperty("per_page")
    protected int nbOfUserPerPage;

    @JsonProperty("total")
    protected int nbOfUsers;

    @JsonProperty("total_pages")
    protected int nbOfPages;

    @JsonProperty("data")
    protected User [] users;

    /**
     * Get page users as List
     * @return List of page users
     */
    public List<User> getUsers(){

        return  new ArrayList<>(Arrays.asList(users));
    }


    @Override
    public String toString() {
        return "Page{" +
                "pageIndex=" + pageIndex +
                ", nbOfUserPerPage=" + nbOfUserPerPage +
                ", nbOfUsers=" + nbOfUsers +
                ", nbOfPages=" + nbOfPages +
                '}';
    }
}
