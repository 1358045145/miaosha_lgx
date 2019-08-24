package com.lgx.miaosha.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class LoignVo {

    @NotNull
    @Length(min = 11,max = 11)
    private String mobile;

    @NotNull
    @Length(min = 32)
    private String password;



}
