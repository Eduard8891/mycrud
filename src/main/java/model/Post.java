package model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.crypto.Data;
import java.util.List;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Integer id;
    private String content;
    private Data created;
    private Data updated;
    private List<Label> labels;
    @SerializedName("status")
    private PostStatus status;
}
