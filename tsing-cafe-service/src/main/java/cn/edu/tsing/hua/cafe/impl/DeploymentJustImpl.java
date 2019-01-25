package cn.edu.tsing.hua.cafe.impl;


import cn.edu.tsing.hua.cafe.dal.dao.ModelFileMapper;
import cn.edu.tsing.hua.cafe.dal.domain.ModelFileExample;
import cn.edu.tsing.hua.cafe.service.DeploymentJust;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: snn
 * @created: 2019-01-26 00:33
 */
@Service
public class DeploymentJustImpl implements DeploymentJust {

    @Resource
    private ModelFileMapper modelFileMapper;

    public void test() {
        modelFileMapper.selectByPrimaryKey(2);
    }

    /**
     * 组装选点
     *
     * @param model
     * @param value
     */
    public void BulidModelFile(String model, String value) {
        new ModelFileExample().createCriteria().
    }
}
