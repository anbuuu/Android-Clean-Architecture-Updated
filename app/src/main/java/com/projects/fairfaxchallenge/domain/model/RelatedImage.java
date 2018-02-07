
package com.projects.fairfaxchallenge.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class RelatedImage implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("categories")
    @Expose
    private List<Object> categories = null;
    @SerializedName("brands")
    @Expose
    private List<Object> brands = null;
    @SerializedName("authors")
    @Expose
    private List<Object> authors = null;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("lastModified")
    @Expose
    private Long lastModified;
    @SerializedName("sponsored")
    @Expose
    private Boolean sponsored;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("photographer")
    @Expose
    private String photographer;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("assetType")
    @Expose
    private String assetType;
    @SerializedName("timeStamp")
    @Expose
    private Long timeStamp;
    private final static long serialVersionUID = -130309223301320162L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Object> getCategories() {
        return categories;
    }

    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    public List<Object> getBrands() {
        return brands;
    }

    public void setBrands(List<Object> brands) {
        this.brands = brands;
    }

    public List<Object> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Object> authors) {
        this.authors = authors;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getLastModified() {
        return lastModified;
    }

    public void setLastModified(Long lastModified) {
        this.lastModified = lastModified;
    }

    public Boolean getSponsored() {
        return sponsored;
    }

    public void setSponsored(Boolean sponsored) {
        this.sponsored = sponsored;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotographer() {
        return photographer;
    }

    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }


}
