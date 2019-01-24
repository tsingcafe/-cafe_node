package cn.edu.tsing.hua.cafe.impl;


import cn.edu.tsing.hua.cafe.dal.dao.ModelFileMapper;
import cn.edu.tsing.hua.cafe.service.DeploymentJust;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DeploymentJustImpl implements DeploymentJust {

    @Resource
    private ModelFileMapper modelFileMapper;

    public void test() {
        modelFileMapper.selectByPrimaryKey(2);
    }
}
