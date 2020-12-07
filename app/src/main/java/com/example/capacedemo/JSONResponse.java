package com.example.capacedemo;

import android.location.Location;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;

@JsonPropertyOrder({
        "Success",
        "location"
})
public class JSONResponse implements Serializable {
    @JsonProperty("Success")
    private List<Datum> data = null;


    @JsonProperty("location")
    private List<LocationData> location_data = null;

    public List<LocationData> getLocation_data() {
        return location_data;
    }

    public void setLocation_data(List<LocationData> location_data) {
        this.location_data = location_data;
    }


    @JsonProperty("Success")
    public List<Datum> getData() {
        return data;
    }
    @JsonProperty("Success")
    public void setData(List<Datum> data) {
        this.data = data;
    }

    public static class Datum {
        @JsonPropertyOrder({
                "id",
                "name",
                "category",
                "categoryid",
                "address",
                "description",
                "contact",
                "empcode",
                "image",

        })
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("category")
        private String category;
        @JsonProperty("categoryid")
        private String categoryid;
        @JsonProperty("address")
        private String address;
        @JsonProperty("description")
        private String description;
        @JsonProperty("contact")
        private String contact;
        @JsonProperty("empcode")
        private String empcode;
        @JsonProperty("image")
        private String image;

        @JsonProperty("id")
        public String getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(String id) {
            this.id = id;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("category")
        public String getCategory() {
            return category;
        }

        @JsonProperty("category")
        public void setCategory(String category) {
            this.category = category;
        }

        @JsonProperty("categoryid")
        public String getCategoryid() {
            return categoryid;
        }

        @JsonProperty("categoryid")
        public void setCategoryid(String categoryid) {
            this.categoryid = categoryid;
        }

        @JsonProperty("address")
        public String getAddress() {
            return address;
        }

        @JsonProperty("address")
        public void setAddress(String address) {
            this.address = address;
        }

        @JsonProperty("description")
        public String getDescription() {
            return description;
        }

        @JsonProperty("description")
        public void setDescription(String description) {
            this.description = description;
        }

        @JsonProperty("contact")
        public String getContact() {
            return contact;
        }

        @JsonProperty("contact")
        public void setContact(String contact) {
            this.contact = contact;
        }

        @JsonProperty("empcode")
        public String getEmpcode() {
            return empcode;
        }

        @JsonProperty("empcode")
        public void setEmpcode(String empcode) {
            this.empcode = empcode;
        }

        @JsonProperty("image")
        public String getImage() {
            return image;
        }

        @JsonProperty("image")
        public void setImage(String image) {
            this.image = image;
        }
    }

    public static class LocationData {
        @JsonPropertyOrder({
                "lat",
                "longg"

        })
        @JsonProperty("lat")
        private String lat;
        @JsonProperty("longg")
        private String longg;

        @JsonProperty("lat")
        public String getLat() {
            return lat;
        }

        @JsonProperty("lat")
        public void setLat(String lat) {
            this.lat = lat;
        }

        @JsonProperty("longg")
        public String getLongg() {
            return longg;
        }

        @JsonProperty("longg")
        public void setLongg(String longg) {
            this.longg = longg;
        }
    }
}
