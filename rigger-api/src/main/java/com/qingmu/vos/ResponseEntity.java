package com.qingmu.vos;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
public class ResponseEntity {

    private int code;

    private String msg;
}
