package cn.edu.tsing.hua.cafe.dal.dao;

import cn.edu.tsing.hua.cafe.dal.domain.ModelFile;

public interface ModelFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ModelFile record);

    int insertSelective(ModelFile record);

    ModelFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ModelFile record);

    int updateByPrimaryKey(ModelFile record);
}