package model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Writer {
    private Integer id;
    private String firstName;
    private String lastName;
    private List<Post> posts;
    @SerializedName("status")
    private PostStatus status;
}
