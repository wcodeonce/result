package cn.codeonce.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class Book {
    @NotNull(message = "不能为空")
    private Integer id;

    @Size(min = 3, message = "书籍名称不能少于3个字符")
    @Size(max = 10, message = "书籍名称不能大于10个字符")
    private String name;

    @NotBlank(message = "类型不能为空")
    private String type;
    private String description;
}
