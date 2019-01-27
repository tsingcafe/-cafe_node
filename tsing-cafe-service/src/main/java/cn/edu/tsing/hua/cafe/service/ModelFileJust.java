package cn.edu.tsing.hua.cafe.service;

import cn.edu.tsing.hua.cafe.dal.domain.ModelFile;

/**
 * @author: snn
 * @created: 2019-01-27 18:50
 */
public interface ModelFileJust {
    ModelFile getModelFile(String model, String value);
}
