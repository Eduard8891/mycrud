package model;

import com.google.gson.annotations.SerializedName;

public enum PostStatus {
    @SerializedName("ACTIVE")
    ACTIVE,
    @SerializedName("UNDER_REVIEW")
    UNDER_REVIEW,
    @SerializedName("DELETED")
    DELETED
}
