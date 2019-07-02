package com.jpa.demo.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity {

    private Date createdDate;
    private Date lastModdifiedDate;
}
