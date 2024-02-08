package model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Label {
    private Integer id;
    private String name;
    private PostStatus status;
}

