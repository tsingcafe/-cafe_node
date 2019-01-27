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
    private static Map<String, String> mapModelFileMap = new HashMap<String, String>(8);

    public ModelFileUtil() {
        mapModelFileMap.put("institute", "institute");
        mapModelFileMap.put("model", "model");
        mapModelFileMap.put("experiment", "experiment");
        mapModelFileMap.put("frequency", "frequency");
        mapModelFileMap.put("modelingRealm", "modelingRealm");
        mapModelFileMap.put("ensembleMember", "ensembleMember");
        mapModelFileMap.put("variableName", "variableName");
        mapModelFileMap.put("mipTable", "mipTable");
    }

    public static Map<String, String> getModelFileUtilMap(){
        return mapModelFileMap;
    }
}
