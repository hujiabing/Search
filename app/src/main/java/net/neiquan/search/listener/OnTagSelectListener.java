package net.neiquan.search.listener;

import net.neiquan.search.ui.FlowTagLayout;

import java.util.List;

/**
 * Created by HanHailong on 15/10/20.
 */
public interface OnTagSelectListener {
    void onItemSelect(FlowTagLayout parent, List<Integer> selectedList);
}
