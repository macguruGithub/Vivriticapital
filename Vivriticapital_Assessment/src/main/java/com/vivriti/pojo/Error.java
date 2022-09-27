package com.vivriti.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Error {
    private String status;
    private String reason;
}
