package cn.edu.tsing.hua.cafe.impl;


import cn.edu.tsing.hua.cafe.dal.dao.ModelFileMapper;
import cn.edu.tsing.hua.cafe.dal.domain.ModelFile;
import cn.edu.tsing.hua.cafe.domain.Response;
import cn.edu.tsing.hua.cafe.dto.ModelFileJustDTO;
import cn.edu.tsing.hua.cafe.service.DeploymentJust;
import cn.edu.tsing.hua.cafe.util.ModelFileUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: snn
 * @created: 2019-01-26 00:33
 */
@Service
public class DeploymentJustImpl implements DeploymentJust {

    private final static Logger log = LoggerFactory.getLogger(DeploymentJust.class);

    @Resource
    private ModelFileMapper modelFileMapper;

    public ModelFile getModelFile(String model, String value) {


        return null

                ;
    }

    /**
     * 组装ModelFiel实体
     *
     * @param model
     * @param value
     */
    public ModelFile buildModelFile(String model, String value) {

        ModelFile modelFile = new ModelFile();
        if (StringUtils.isBlank(model) || StringUtils.isBlank(value)) {
            log.info("bulidModelFile model or value is blank");
            return modelFile;
        }
        if (ModelFileUtil.getModelFileUtilMap().containsKey(model)) {
            BeanWrapper modelFileBean = new BeanWrapperImpl(modelFile);
            modelFileBean.setPropertyValue(ModelFileUtil.getModelFileUtilMap().get(model), value);
        }
        return modelFile;
    }

    public static void tests() {
        Response response = new Response();
        response.setSuccess(true);
        response.setError("");
        response.setData(new ModelFileJustDTO());
    }

    public static void main(String[] args) {
        ModelFileJustDTO sr = new ModelFileJustDTO();
        sr.setCreateTime(new Date());
        Response response = new Response();
        response.setSuccess(true);
        response.setError("");
        response.setData(sr);
        System.out.println(JSONObject.toJSONString(response, SerializerFeature.WriteMapNullValue));
    }

    @Override
    public void test() {

    }
}
