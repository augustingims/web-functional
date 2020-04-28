package com.teamdevsolution.webfunctional.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Document(collection = "countries")
public class Country extends BaseEntity {

    @NotBlank
    @TextIndexed
    private String name;

    @Size(max = 3)
    @TextIndexed
    private String code;

    private String flag;

}
