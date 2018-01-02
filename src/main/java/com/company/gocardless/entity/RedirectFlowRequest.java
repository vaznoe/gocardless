package com.company.gocardless.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RedirectFlowRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String url;
    private String redirectFlowId;
    private String sessionToken;

    @java.beans.ConstructorProperties({"id", "url", "redirectFlowId", "sessionToken"})
    public RedirectFlowRequest(long id, String url, String redirectFlowId, String sessionToken) {
        this.id = id;
        this.url = url;
        this.redirectFlowId = redirectFlowId;
        this.sessionToken = sessionToken;
    }

    public RedirectFlowRequest() {
    }

    public long getId() {
        return this.id;
    }

    public String getUrl() {
        return this.url;
    }

    public String getRedirectFlowId() {
        return this.redirectFlowId;
    }

    public String getSessionToken() {
        return this.sessionToken;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setRedirectFlowId(String redirectFlowId) {
        this.redirectFlowId = redirectFlowId;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof RedirectFlowRequest)) return false;
        final RedirectFlowRequest other = (RedirectFlowRequest) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$url = this.getUrl();
        final Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) return false;
        final Object this$redirectFlowId = this.getRedirectFlowId();
        final Object other$redirectFlowId = other.getRedirectFlowId();
        if (this$redirectFlowId == null ? other$redirectFlowId != null : !this$redirectFlowId.equals(other$redirectFlowId))
            return false;
        final Object this$sessionToken = this.getSessionToken();
        final Object other$sessionToken = other.getSessionToken();
        if (this$sessionToken == null ? other$sessionToken != null : !this$sessionToken.equals(other$sessionToken))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $url = this.getUrl();
        result = result * PRIME + ($url == null ? 43 : $url.hashCode());
        final Object $redirectFlowId = this.getRedirectFlowId();
        result = result * PRIME + ($redirectFlowId == null ? 43 : $redirectFlowId.hashCode());
        final Object $sessionToken = this.getSessionToken();
        result = result * PRIME + ($sessionToken == null ? 43 : $sessionToken.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof RedirectFlowRequest;
    }

    public String toString() {
        return "RedirectFlowRequest(id=" + this.getId() + ", url=" + this.getUrl() + ", redirectFlowId=" + this.getRedirectFlowId() + ", sessionToken=" + this.getSessionToken() + ")";
    }
}
