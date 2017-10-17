
package Entities;

import java.util.Date;

public class Request {
    private String username;
    private Date start;
    private Date end;
    private String reason;
    private String processedBy;
    private int status;

    public Request(String username, Date start, Date end, String reason, String processedBy, int status) {
        this.username = username;
        this.start = start;
        this.end = end;
        this.reason = reason;
        this.processedBy = processedBy;
        this.status = status;
    }

    public Request() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
