package com.tutrit.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Engineer {
    private String uuid;
    private String firstName;
    private String lastName;
    private String position;
}
