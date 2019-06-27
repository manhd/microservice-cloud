package utils;

import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * @ClassName JsonUtils
 * @Description TODO
 * @Author sh-manhd
 * @Date 2019/5/28 16:13
 * @Version 1.0
 **/
public class JsonUtils {

    /**
     * map 转化为java对象
     * @param map
     * @param beanClass
     * @return
     * @throws Exception
     */
    public static Object map2Bean(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null)
            return null;
        Object obj = beanClass.newInstance();
        BeanUtils.populate(obj,map);
        return obj;
    }


    /**
     * 对象转map
     * @param
     * @param object
     * @return
     * @throws Exception
     */
    public static Map<?,?> bean2Map(Object object) throws Exception {
        if (object == null)
            return null;
        return new BeanMap(object);
    }


    /**
     * json Str 转map
     * @param
     * @param jsonStr
     * @return
     * @throws Exception
     */
    public static Map<?,?> json2Map(String jsonStr) throws Exception {
        if(StringUtils.isBlank(jsonStr))
            return null;
        JSONObject jsonObject = JSONObject.fromObject(jsonStr);
        Map<Object,Object> map = (Map<Object, Object>) jsonObject;
        return map;
    }
}
