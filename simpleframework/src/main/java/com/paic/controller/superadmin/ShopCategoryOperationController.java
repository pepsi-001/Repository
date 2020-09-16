package com.paic.controller.superadmin;

import com.paic.entity.bo.ShopCategory;
import com.paic.entity.dto.Result;
import com.paic.service.solo.ShopCategoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShopCategoryOperationController {
    private ShopCategoryService shopCategoryService;
    Result<Boolean> addHeadLine(HttpServletRequest req, HttpServletResponse resp){
        //TODO:参数校验以及请求参数转化
        return shopCategoryService.addShopCategory(new ShopCategory());
    }
    Result<Boolean> removeHeadLine(HttpServletRequest req, HttpServletResponse resp){
        //TODO:参数校验以及请求参数转化
        return shopCategoryService.removeShopCategory(1);
    }
    Result<Boolean> modifyHeadLine(HttpServletRequest req, HttpServletResponse resp){
        //TODO:参数校验以及请求参数转化
        return shopCategoryService.modifyShopCategory(new ShopCategory());
    }
    Result<ShopCategory> queryHeadLineById(HttpServletRequest req, HttpServletResponse resp){
        //TODO:参数校验以及请求参数转化
        return shopCategoryService.queryShopCategoryById(1);
    }
    Result<List<ShopCategory>> queryHeadLine(HttpServletRequest req, HttpServletResponse resp){
        //TODO:参数校验以及请求参数转化
        return shopCategoryService.queryShopCategory(new ShopCategory(),1,10);
    }
}
