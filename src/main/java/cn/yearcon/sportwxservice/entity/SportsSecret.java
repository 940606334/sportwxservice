package cn.yearcon.sportwxservice.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author itguang
 * @create 2018-01-18 9:45
 **/
@Entity
@Table(name = "sports_secret", schema = "sports", catalog = "")
public class SportsSecret {
    private String appid;
    private Timestamp addtime;
    private Timestamp edittime;
    private String accessToken;
    private Integer expiresIn;
    private String secret;
    private String jsapiTicket;

    @Id
    @Column(name = "appid")
    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    @Basic
    @Column(name = "addtime")
    public Timestamp getAddtime() {
        return addtime;
    }

    public void setAddtime(Timestamp addtime) {
        this.addtime = addtime;
    }

    @Basic
    @Column(name = "edittime")
    public Timestamp getEdittime() {
        return edittime;
    }

    public void setEdittime(Timestamp edittime) {
        this.edittime = edittime;
    }

    @Basic
    @Column(name = "access_token")
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Basic
    @Column(name = "expires_in")
    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Basic
    @Column(name = "secret")
    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Basic
    @Column(name = "jsapi_ticket")
    public String getJsapiTicket() {
        return jsapiTicket;
    }

    public void setJsapiTicket(String jsapiTicket) {
        this.jsapiTicket = jsapiTicket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsSecret that = (SportsSecret) o;
        return Objects.equals(appid, that.appid) &&
                Objects.equals(addtime, that.addtime) &&
                Objects.equals(edittime, that.edittime) &&
                Objects.equals(accessToken, that.accessToken) &&
                Objects.equals(expiresIn, that.expiresIn) &&
                Objects.equals(secret, that.secret) &&
                Objects.equals(jsapiTicket, that.jsapiTicket);
    }

    @Override
    public int hashCode() {

        return Objects.hash(appid, addtime, edittime, accessToken, expiresIn, secret, jsapiTicket);
    }
}
