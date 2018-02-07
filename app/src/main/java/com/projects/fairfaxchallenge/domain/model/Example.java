
package com.projects.fairfaxchallenge.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Example implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("categories")
    @Expose
    private List<Object> categories = null;
    @SerializedName("authors")
    @Expose
    private List<Object> authors = null;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("lastModified")
    @Expose
    private Long lastModified;
    @SerializedName("onTime")
    @Expose
    private Long onTime;
    @SerializedName("sponsored")
    @Expose
    private Boolean sponsored;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("assets")
    @Expose
    private List<Asset> assets = null;
    @SerializedName("relatedAssets")
    @Expose
    private List<Object> relatedAssets = null;
    @SerializedName("relatedImages")
    @Expose
    private List<RelatedImage> relatedImages = null;
    @SerializedName("assetType")
    @Expose
    private String assetType;
    @SerializedName("timeStamp")
    @Expose
    private Long timeStamp;
    private final static long serialVersionUID = -2243955718535720321L;

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

    public Long getOnTime() {
        return onTime;
    }

    public void setOnTime(Long onTime) {
        this.onTime = onTime;
    }

    public Boolean getSponsored() {
        return sponsored;
    }

    public void setSponsored(Boolean sponsored) {
        this.sponsored = sponsored;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public List<Object> getRelatedAssets() {
        return relatedAssets;
    }

    public void setRelatedAssets(List<Object> relatedAssets) {
        this.relatedAssets = relatedAssets;
    }

    public List<RelatedImage> getRelatedImages() {
        return relatedImages;
    }

    public void setRelatedImages(List<RelatedImage> relatedImages) {
        this.relatedImages = relatedImages;
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
