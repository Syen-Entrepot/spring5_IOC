package com.cn.Service;

import com.cn.dao.ProviderDao;

/**
 * @author Syen
 * @date 2019/7/26 0026-下午 15:40
 */
public class ProviderService {
    private ProviderDao providerDao;
    public void update(){
        System.out.println("更新.........");
        providerDao.update();
    }

    public ProviderDao getProviderDao() {
        return providerDao;
    }

    public void setProviderDao(ProviderDao providerDao) {
        this.providerDao = providerDao;
    }
}
