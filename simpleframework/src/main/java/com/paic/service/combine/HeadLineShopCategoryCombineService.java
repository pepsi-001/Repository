package com.paic.service.combine;

import com.paic.entity.dto.MainPageInfoDTO;
import com.paic.entity.dto.Result;

public interface HeadLineShopCategoryCombineService {
    Result<MainPageInfoDTO> getMainPageInfo();
}
