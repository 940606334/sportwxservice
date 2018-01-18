package cn.yearcon.sportwxservice.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author itguang
 * @create 2018-01-18 9:45
 **/
@Entity
@Table(name = "sports_wx", schema = "sports", catalog = "")
public class SportsWx {
    private int webid;
    private String appid;
    private String secret;
    private String payappid;
    private String paysecret;
    private String paymchid;
    private String paykey;
    private Integer storenumber;
    private String webname;
    private String webcode;

    @Id
    @Column(name = "webid")
    public int getWebid() {
        return webid;
    }

    public void setWebid(int webid) {
        this.webid = webid;
    }

    @Basic
    @Column(name = "appid")
    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
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
    @Column(name = "payappid")
    public String getPayappid() {
        return payappid;
    }

    public void setPayappid(String payappid) {
        this.payappid = payappid;
    }

    @Basic
    @Column(name = "paysecret")
    public String getPaysecret() {
        return paysecret;
    }

    public void setPaysecret(String paysecret) {
        this.paysecret = paysecret;
    }

    @Basic
    @Column(name = "paymchid")
    public String getPaymchid() {
        return paymchid;
    }

    public void setPaymchid(String paymchid) {
        this.paymchid = paymchid;
    }

    @Basic
    @Column(name = "paykey")
    public String getPaykey() {
        return paykey;
    }

    public void setPaykey(String paykey) {
        this.paykey = paykey;
    }

    @Basic
    @Column(name = "storenumber")
    public Integer getStorenumber() {
        return storenumber;
    }

    public void setStorenumber(Integer storenumber) {
        this.storenumber = storenumber;
    }

    @Basic
    @Column(name = "webname")
    public String getWebname() {
        return webname;
    }

    public void setWebname(String webname) {
        this.webname = webname;
    }

    @Basic
    @Column(name = "webcode")
    public String getWebcode() {
        return webcode;
    }

    public void setWebcode(String webcode) {
        this.webcode = webcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsWx sportsWx = (SportsWx) o;
        return webid == sportsWx.webid &&
                Objects.equals(appid, sportsWx.appid) &&
                Objects.equals(secret, sportsWx.secret) &&
                Objects.equals(payappid, sportsWx.payappid) &&
                Objects.equals(paysecret, sportsWx.paysecret) &&
                Objects.equals(paymchid, sportsWx.paymchid) &&
                Objects.equals(paykey, sportsWx.paykey) &&
                Objects.equals(storenumber, sportsWx.storenumber) &&
                Objects.equals(webname, sportsWx.webname) &&
                Objects.equals(webcode, sportsWx.webcode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(webid, appid, secret, payappid, paysecret, paymchid, paykey, storenumber, webname, webcode);
    }
}
