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

/**
 * UserClientException
 */
public class UserClientException extends Exception{
    public UserClientException(String errorMessage) {
        super(errorMessage);
    }
}
