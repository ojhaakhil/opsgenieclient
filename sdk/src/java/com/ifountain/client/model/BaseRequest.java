package com.ifountain.client.model;

import com.ifountain.client.ClientConstants;
import com.ifountain.client.ClientValidationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Base class for container objects which provides request parameters for OpsGenie service calls.
 *
 * @author Sezgin Kucukkaraaslan
 * @version 5/31/12 2:03 PM
 */
public abstract class BaseRequest<T extends BaseResponse> implements Request {
    private String apiKey;

    /**
     * Api key used for authenticating API requests.
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Sets the tustomer key used for authenticating API requests.
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    //TODO: delete customer key property
    /**
     * @deprecated
     * Use getApiKey
     */
    public String getCustomerKey() {
        return apiKey;
    }

    /**
     * @deprecated
     * Use setApiKey
     */
    public void setCustomerKey(String apiKey) {
        setApiKey(apiKey);
    }

    /**
     * convertes request to map
     */
    public Map serialize() throws ClientValidationException {
        Map map = new HashMap();
        map.put(ClientConstants.API.API_KEY, apiKey);
        return map;
    }

    /**
     * Create response object
     */
    public abstract T createResponse();
}