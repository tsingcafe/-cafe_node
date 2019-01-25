package cn.edu.tsing.hua.cafe.dal.dao;

import cn.edu.tsing.hua.cafe.dal.domain.ModelFile;
import cn.edu.tsing.hua.cafe.dal.domain.ModelFileExample;
import java.util.List;

public interface ModelFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ModelFile record);

    int insertSelective(ModelFile record);

    List<ModelFile> selectByExample(ModelFileExample example);

    ModelFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ModelFile record);

    int updateByPrimaryKey(ModelFile record);
}