
package com.projects.fairfaxchallenge.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Source implements Serializable {

    @SerializedName("tagId")
    @Expose
    private String tagId;
    private final static long serialVersionUID = -1279334315549577038L;

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

}
