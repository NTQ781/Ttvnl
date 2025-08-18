package com.example.japanese.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Listening {
    private String title;    // tiêu đề audio
    private String audioUrl; // link mp3
}
