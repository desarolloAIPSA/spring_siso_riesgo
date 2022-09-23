package com.paramonga.ssff.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {
    private String fileName;
    private String downloadURL;
    private String fileType;
    private long fileSize;
}
