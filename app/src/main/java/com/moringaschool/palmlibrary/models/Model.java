
package com.moringaschool.palmlibrary.models;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moringaschool.palmlibrary.models.Item;

@Generated("jsonschema2pojo")
public class Model {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("totalItems")
    @Expose
    private Integer totalItems;
    @SerializedName("items")
    @Expose
    public static List<Item> items = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Model() {
    }

    /**
     * 
     * @param totalItems
     * @param kind
     * @param items
     */
    public Model(String kind, Integer totalItems, List<Item> items) {
        super();
        this.kind = kind;
        this.totalItems = totalItems;
        this.items = items;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
