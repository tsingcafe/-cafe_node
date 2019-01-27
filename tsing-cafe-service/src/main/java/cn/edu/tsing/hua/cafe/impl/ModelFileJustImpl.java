package cn.edu.tsing.hua.cafe.impl;

import cn.edu.tsing.hua.cafe.dal.dao.ModelFileMapper;
import cn.edu.tsing.hua.cafe.dal.domain.ModelFile;
import cn.edu.tsing.hua.cafe.domain.Response;
import cn.edu.tsing.hua.cafe.dto.ModelFileJustDTO;
import cn.edu.tsing.hua.cafe.service.ModelFileJust;
import cn.edu.tsing.hua.cafe.util.ModelFileUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author: snn
 * @created: 2019-01-27 18:50
 */
@Service
public class ModelFileJustImpl implements ModelFileJust {

    private final static Logger log = LoggerFactory.getLogger(ModelFileJust.class);

    @Resource
    private ModelFileMapper modelFileMapper;

    @Resource
    private ModelFileUtil modelFileUtil;

    @Override
    public Response getModelFile(String model, String value) {
        Response response = new Response();
        response.setSuccess(false);
        try {
            ModelFile modelfile = buildModelFile(model, value);
            if (modelfile == null) {
                log.info("buildModelFile is null");
                response.setError("model or value null");
                return response;
            }
            List<ModelFile> listModelFile = modelFileMapper.listModelFile(modelfile);
            if (CollectionUtils.isEmpty(listModelFile)) {
                response.setError("query modelFile is empty");
                return response;
            }
            ModelFileJustDTO modelFileJustDTO = distinctModelFiles(listModelFile);
            response.setSuccess(true);
            response.setData(modelFileJustDTO);
            return response;
        } catch (Exception e) {
           response.setError("service is exception");
           return response;
        }
    }

    /**
     * 按属性组装ModelFileJustDTO
     *
     * @param listModelFile
     * @return
     */
    private ModelFileJustDTO distinctModelFiles(List<ModelFile> listModelFile) {
        ModelFileJustDTO modelFileJustDTO = new ModelFileJustDTO();
        modelFileJustDTO.setInstitute(listModelFile.stream().map(ModelFile::getInstitute).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList()));
        modelFileJustDTO.setModel(listModelFile.stream().map(ModelFile::getModel).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList()));
        modelFileJustDTO.setExperiment(listModelFile.stream().map(ModelFile::getExperiment).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList()));
        modelFileJustDTO.setFrequency(listModelFile.stream().map(ModelFile::getFrequency).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList()));
        modelFileJustDTO.setModelingRealm(listModelFile.stream().map(ModelFile::getModelingRealm).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList()));
        modelFileJustDTO.setEnsembleMember(listModelFile.stream().map(ModelFile::getEnsembleMember).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList()));
        modelFileJustDTO.setVariableName(listModelFile.stream().map(ModelFile::getVariableName).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList()));
        modelFileJustDTO.setMipTable(listModelFile.stream().map(ModelFile::getMipTable).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList()));
        return modelFileJustDTO;
    }

    /**
     * 组装ModelFile实体
     *
     * @param model
     * @param value
     */
    public ModelFile buildModelFile(String model, String value) {

        if (StringUtils.isBlank(model) || StringUtils.isBlank(value)) {
            log.info("bulidModelFile model or value is blank");
            return null;
        }
        ModelFile modelFile = new ModelFile();
        if (modelFileUtil.getModelFileUtilMap().containsKey(model)) {
            BeanWrapper modelFileBean = new BeanWrapperImpl(modelFile);
            modelFileBean.setPropertyValue(modelFileUtil.getModelFileUtilMap().get(model), value);
            return modelFile;
        }
        return null;
    }

    /**
     * 去重
     *
     * @param keyExtractor
     * @param <T>
     * @return
     */
    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}
