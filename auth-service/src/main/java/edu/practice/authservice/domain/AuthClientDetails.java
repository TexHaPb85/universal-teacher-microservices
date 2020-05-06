package edu.practice.authservice.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.*;

@Entity
public class AuthClientDetails implements ClientDetails {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String clientId;
    private String clientSecret;
    private String grantTypes;
    private String scopes;
    private String resources;
    private String redirectUris;
    private Integer accessTokenValidity;
    private Integer refreshTokenValidity;
    private String additionalInformation;

    public AuthClientDetails() {
    }

    public AuthClientDetails(String id, String clientId, String clientSecret, String grantTypes, String scopes, String resources, String redirectUris, Integer accessTokenValidity, Integer refreshTokenValidity, String additionalInformation) {
        this.id = id;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.grantTypes = grantTypes;
        this.scopes = scopes;
        this.resources = resources;
        this.redirectUris = redirectUris;
        this.accessTokenValidity = accessTokenValidity;
        this.refreshTokenValidity = refreshTokenValidity;
        this.additionalInformation = additionalInformation;
    }

    @Override
    public String getClientId() {
        return clientId;
    }

    /**
     * The resources that this client can access. Can be ignored by callers if empty.
     * resources separated by comes, we split it to array and put into HashSet
     */
    @Override
    public Set<String> getResourceIds() {
        return resources != null ? new HashSet<>(Arrays.asList(resources.split(","))) : null;
    }

    /**
     * Whether a secret is required to authenticate this client.
     */
    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * Whether this client is limited to a specific scope.
     */
    @Override
    public boolean isScoped() {
        return false;
    }

    @Override
    public Set<String> getScope() {
        return scopes != null ? new HashSet<>(Arrays.asList(scopes.split(","))) : null;
    }

    /**
     * The grant types for which this client is authorized.
     */
    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return grantTypes != null ? new HashSet<>(Arrays.asList(grantTypes.split(","))) : null;
    }

    /**
     * The pre-defined redirect URI for this client to use during the "authorization_code" access grant.
     */
    @Override
    public Set<String> getRegisteredRedirectUri() {
        return redirectUris != null ? new HashSet<>(Arrays.asList(redirectUris.split(","))) : null;
    }

    /**
     * The access token validity period for this client.
     * Null if not set explicitly (implementations might use that fact to provide a default value for instance).
     */
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    /**
     * The refresh token validity period for this client.
     * Null for default value set by token service, and zero or negative for non-expiring tokens.
     */
    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValidity;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValidity;
    }

    /**
     * Test whether client needs user approval for a particular scope.
     * @param scope the scope to consider
     * @return true if this client does not need user approval
     */
    @Override
    public boolean isAutoApprove(String scope) {
        return true;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setGrantTypes(String grantTypes) {
        this.grantTypes = grantTypes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public void setRedirectUris(String redirectUris) {
        this.redirectUris = redirectUris;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @Override
    public String toString() {
        return "AuthClientDetails{" +
                "id='" + id + '\'' +
                ", clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", grantTypes='" + grantTypes + '\'' +
                ", scopes='" + scopes + '\'' +
                ", resources='" + resources + '\'' +
                ", redirectUris='" + redirectUris + '\'' +
                ", accessTokenValidity=" + accessTokenValidity +
                ", refreshTokenValidity=" + refreshTokenValidity +
                ", additionalInformation='" + additionalInformation + '\'' +
                '}';
    }
}
