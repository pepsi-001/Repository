package com.paic.entity.bo;

import lombok.Data;
import java.util.Date;

@Data
public class ShopCategory {
    private Long shopCategoryId;
    private String shopCategoryName;
    private String shopCategoryDesc;
    private String shopCategoryImg;
    private Integer priority;
    private Date CreateTime;
    private Date lastEditTime;
    private ShopCategory parent;
}
