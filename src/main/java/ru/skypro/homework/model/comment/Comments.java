package ru.skypro.homework.model.comment;

import java.util.List;

import lombok.Data;
import ru.skypro.homework.entity.Comment;

@Data
public class Comments {

    private int count;
    private List<Comment> results;

}
