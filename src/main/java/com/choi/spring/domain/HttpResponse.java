package com.choi.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by choi on 2017. 6. 4..
 */
@Data
@AllArgsConstructor
public class HttpResponse {
    private boolean result;
    private Object message;
}
