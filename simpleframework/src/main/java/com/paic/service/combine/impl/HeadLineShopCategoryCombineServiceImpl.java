package com.paic.service.combine.impl;

import com.paic.entity.bo.HeadLine;
import com.paic.entity.bo.ShopCategory;
import com.paic.entity.dto.MainPageInfoDTO;
import com.paic.entity.dto.Result;
import com.paic.service.combine.HeadLineShopCategoryCombineService;
import com.paic.service.solo.HeadLineService;
import com.paic.service.solo.ShopCategoryService;
import com.paic.service.solo.impl.HeadLineServiceImpl;
import com.paic.service.solo.impl.ShopCategoryServiceImpl;

import java.util.List;

public class HeadLineShopCategoryCombineServiceImpl implements HeadLineShopCategoryCombineService {
    private HeadLineService headLineService=new HeadLineServiceImpl();
    private ShopCategoryService shopCategoryService = new ShopCategoryServiceImpl();

    @Override
    public Result<MainPageInfoDTO> getMainPageInfo() {

        //1.获取头条列表
        HeadLine headLineCondition = new HeadLine();
        headLineCondition.setEnableStatus(1);
        Result<List<HeadLine>> headLineResult = headLineService.queryHeadLine(headLineCondition, 1, 10);
        //2.获取店铺类别列表
        ShopCategory shopCategoryCondition = new ShopCategory();
        Result<List<ShopCategory>> shopCategoryResult = shopCategoryService.queryShopCategory(shopCategoryCondition, 1, 10);
        //3.合并
        Result<MainPageInfoDTO> result = mergeMainPageInfoResult(headLineResult,shopCategoryResult);
        return result;
    }

    private Result<MainPageInfoDTO> mergeMainPageInfoResult(Result<List<HeadLine>> headLineResult, Result<List<ShopCategory>> shopCategoryResult) {
        return null;
    }
}
