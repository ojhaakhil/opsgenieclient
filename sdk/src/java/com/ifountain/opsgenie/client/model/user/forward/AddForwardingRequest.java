package com.ifountain.opsgenie.client.model.user.forward;

import com.ifountain.opsgenie.client.model.BaseRequest;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * Container for the parameters to make an add forwarding api call.
 *
 * @see com.ifountain.opsgenie.client.IOpsGenieClient#addForwarding(AddForwardingRequest)
 */
public class AddForwardingRequest extends BaseRequest {
    private String alias;
    private String fromUser;
    private String toUser;
    private Date startDate;
    private Date endDate;
    private TimeZone timeZone;

    /**
     * Rest api uri of alert create operation.
     */
    @Override
    public String getEndPoint() {
        return "/v1/json/user/forward";
    }

    /**
     * A user defined identifier for the forwarding.
     * Provides ability to assign a known id and later use this id to perform additional actions for the same forwarding.
     * If a forwarding exists with specified alias for from user, it will update existing one.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Sets a user defined identifier for the forwarding.
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Username of user  which forwarding will be created for
     */
    public String getFromUser() {
        return fromUser;
    }

    /**
     * Sets Username of user who forwarding will be created for
     */
    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    /**
     * Username of user who forwarding will be directed to
     */
    public String getToUser() {
        return toUser;
    }

    /**
     * Sets username of user who forwarding will be directed to
     */
    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    /**
     * Start date of forwarding will be started
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets start date of forwarding will be started
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * End date of forwarding will be discarded
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets end date of forwarding will be discarded
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Timezone to determine forwarding start and end dates
     */
    public TimeZone getTimeZone() {
        return timeZone;
    }

    /**
     * Sets timezone to determine forwarding start and end dates
     */
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }
}
