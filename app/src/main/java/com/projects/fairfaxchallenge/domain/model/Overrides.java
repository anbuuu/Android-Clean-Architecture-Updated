
package com.projects.fairfaxchallenge.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Overrides implements Serializable {

    @SerializedName("overrideHeadline")
    @Expose
    private String overrideHeadline;
    @SerializedName("overrideIdentifier")
    @Expose
    private String overrideIdentifier;
    @SerializedName("overrideAbstract")
    @Expose
    private String overrideAbstract;
    private final static long serialVersionUID = 9024004995122171009L;

    public String getOverrideHeadline() {
        return overrideHeadline;
    }

    public void setOverrideHeadline(String overrideHeadline) {
        this.overrideHeadline = overrideHeadline;
    }

    public String getOverrideIdentifier() {
        return overrideIdentifier;
    }

    public void setOverrideIdentifier(String overrideIdentifier) {
        this.overrideIdentifier = overrideIdentifier;
    }

    public String getOverrideAbstract() {
        return overrideAbstract;
    }

    public void setOverrideAbstract(String overrideAbstract) {
        this.overrideAbstract = overrideAbstract;
    }

}
