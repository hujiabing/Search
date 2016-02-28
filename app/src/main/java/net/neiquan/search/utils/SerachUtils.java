package net.neiquan.search.utils;

import com.alibaba.fastjson.JSON;

import net.neiquan.search.application.MyApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator 搜索工具
 */
public class SerachUtils {

    private static SerachUtils single = null;

    private List<String> searchHistory = new ArrayList<String>();
    ;

    private final int MAX_COUNT = 4;//搜索历史展示的最大条数

    private final String KEY = "search_history";

    // 静态工厂方法
    public static SerachUtils getInstance() {
        if (single == null) {
            single = new SerachUtils();
        }
        return single;
    }

    /**
     * 搜索历史
     *
     * @return
     */
    public List<String> getSearchList() {
        String history = SharedPreferencesUtil.get(MyApplication.getInstance(), KEY);

        if (null != history && !"".equals(history)) {
            searchHistory = JSON.parseArray(history, String.class);
        }
        return searchHistory;

    }

    /**
     * 添加搜索结果  考虑到效率不会存到到文件
     */
    public List<String> saveSearch(String str) {
        searchHistory.add(0, str);
        return searchHistory;
    }

    /**
     * 删除一个
     */
    public List<String> deleteOneSearch(String str) {
        searchHistory.remove(str);
        return searchHistory;
    }

    /**
     * 添加搜索结果  存到到文件 ondestory 调用
     */
    public void saveFile(List<String> list) {

        if (list != null && list.size() > 0) {
            String history = JSON.toJSONString(list);
            SharedPreferencesUtil.add(MyApplication.getInstance(), KEY, history);
        }
    }

    /**
     * 清空
     */
    public void clear() {
        searchHistory.clear();
        SharedPreferencesUtil.delete(MyApplication.getInstance(), KEY);
    }
}
