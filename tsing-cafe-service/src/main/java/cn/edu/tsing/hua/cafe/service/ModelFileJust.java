package cn.edu.tsing.hua.cafe.service;

import cn.edu.tsing.hua.cafe.dal.domain.ModelFile;
import cn.edu.tsing.hua.cafe.domain.Response;

/**
 * @author: snn
 * @created: 2019-01-27 18:50
 */
public interface ModelFileJust {
    Response getModelFile(String model, String value);
}
