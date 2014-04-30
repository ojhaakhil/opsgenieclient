package com.ifountain.client.opsgenie.model.alert;

import com.ifountain.client.ClientConstants;
import com.ifountain.client.ClientValidationException;

import java.util.Map;

/**
 * Container for the parameters to make a list alert logs api call.
 *
 * @author Sezgin Kucukkaraaslan
 * @version 5/31/12 4:30 PM
 * @see com.ifountain.client.opsgenie.IAlertOpsGenieClient#listAlertLogs(ListAlertLogsRequest)
 */
public class ListAlertLogsRequest extends BaseAlertRequestWithId<ListAlertLogsResponse> {
    public enum SortOrder{
        asc,
        desc
    }
    private SortOrder sortOrder =SortOrder.asc;
    private Integer limit = 100;
    private String lastKey;

    public SortOrder getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getLastKey() {
        return lastKey;
    }

    public void setLastKey(String lastKey) {
        this.lastKey = lastKey;
    }

    /**
     * Rest api uri of get alert operation.
     */
    @Override
    public String getEndPoint() {
        return "/v1/json/alert/log";
    }

    @Override
    public Map serialize() throws ClientValidationException {
        Map resp = super.serialize();
        if(!(resp.containsKey(ClientConstants.API.ID)
                || resp.containsKey(ClientConstants.API.ALERT_ID)
                ||resp.containsKey(ClientConstants.API.ALIAS)
        || resp.containsKey(ClientConstants.API.TINY_ID)) )
        {
            throw ClientValidationException.missingMandatoryProperty(ClientConstants.API.ID);
        }
        if (getLastKey() != null)
            resp.put(ClientConstants.API.LAST_KEY, getLastKey());
        if (getSortOrder() != null)
            resp.put(ClientConstants.API.ORDER, getSortOrder().name());
        if (getLimit() != null)
            resp.put(ClientConstants.API.LIMIT, getLimit());
        return resp;
    }

    @Override
    /**
     * @see com.ifountain.client.model.BaseRequest#createResponse()
     */
    public ListAlertLogsResponse createResponse() {
        return new ListAlertLogsResponse();
    }
}