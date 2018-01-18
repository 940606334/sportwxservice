package cn.yearcon.sportwxservice.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author itguang
 * @create 2018-01-18 9:45
 **/
@Entity
@Table(name = "sports_msgtemplate", schema = "sports", catalog = "")
public class SportsMsgtemplate {
    private int webid;
    private String name;
    private String templateid;
    private String first;
    private String remark;
    private String redirecturl;
    private String usable;

    @Id
    @Column(name = "webid")
    public int getWebid() {
        return webid;
    }

    public void setWebid(int webid) {
        this.webid = webid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "templateid")
    public String getTemplateid() {
        return templateid;
    }

    public void setTemplateid(String templateid) {
        this.templateid = templateid;
    }

    @Basic
    @Column(name = "first")
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "redirecturl")
    public String getRedirecturl() {
        return redirecturl;
    }

    public void setRedirecturl(String redirecturl) {
        this.redirecturl = redirecturl;
    }

    @Basic
    @Column(name = "usable")
    public String getUsable() {
        return usable;
    }

    public void setUsable(String usable) {
        this.usable = usable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsMsgtemplate that = (SportsMsgtemplate) o;
        return webid == that.webid &&
                Objects.equals(name, that.name) &&
                Objects.equals(templateid, that.templateid) &&
                Objects.equals(first, that.first) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(redirecturl, that.redirecturl) &&
                Objects.equals(usable, that.usable);
    }

    @Override
    public int hashCode() {

        return Objects.hash(webid, name, templateid, first, remark, redirecturl, usable);
    }
}
