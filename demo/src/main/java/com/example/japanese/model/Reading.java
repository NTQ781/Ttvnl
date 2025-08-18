package com.example.japanese.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reading {
    private String title;   // tiêu đề bài đọc
    private String content; // nội dung văn bản
}
