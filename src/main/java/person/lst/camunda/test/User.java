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

/**
 * User
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty("id")
    protected long id;

    @JsonProperty("email")
    protected String email;

    @JsonProperty("first_name")
    protected String firstName;

    @JsonProperty("last_name")
    protected String lastName;

    @JsonProperty("avatar")
    protected String avatar;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
