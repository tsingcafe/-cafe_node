package cn.edu.tsing.hua.cafe.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: snn
 * @created: 2019-01-26 00:24
 */
public class ModelFileUtil {

    /**
     * modelFile容器
     */
    private static Map<String, String> mapModelFileUtil = new HashMap<String, String>(8);

    public ModelFileUtil() {
        mapModelFileUtil.put("institute", "institute");
        mapModelFileUtil.put("model", "model");
        mapModelFileUtil.put("experiment", "experiment");
        mapModelFileUtil.put("frequency", "frequency");
        mapModelFileUtil.put("modelingRealm", "modelingRealm");
        mapModelFileUtil.put("ensembleMember", "ensembleMember");
        mapModelFileUtil.put("variableName", "variableName");
        mapModelFileUtil.put("mipTable", "mipTable");
    }

}
