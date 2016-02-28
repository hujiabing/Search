package net.neiquan.search.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.neiquan.search.R;
import net.neiquan.search.adapter.TagAdapter;
import net.neiquan.search.inter.Contants;
import net.neiquan.search.listener.OnTagClickListener;
import net.neiquan.search.ui.FlowTagLayout;
import net.neiquan.search.utils.KeyBoardUtils;
import net.neiquan.search.utils.SerachUtils;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.search_edit)
    EditText search_edit;
    @InjectView(R.id.flowTagLayout)
    FlowTagLayout flowTagLayout;
    private List<String> searchHistory;//搜索历史
    private TagAdapter tagAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initChildViews();
    }

    /**
     * 生成流标签
     */
    private void initChildViews() {
        //获得搜索历史
        searchHistory = SerachUtils.getInstance().getSearchList();
        tagAdapter = new TagAdapter(this);
        //设置这个模式意思是处理流标签点击事件
        flowTagLayout.setTagCheckedMode(FlowTagLayout.FLOW_TAG_CHECKED_NONE);
        flowTagLayout.setAdapter(tagAdapter);
        tagAdapter.onlyAddAll(searchHistory);
        //点击流标签让历史文字出现在EditText上,并执行搜索
        flowTagLayout.setOnTagClickListener(new OnTagClickListener() {
            @Override
            public void onItemClick(FlowTagLayout parent, View view, int position) {
                View view1 = parent.getAdapter().getView(position, null, null);
                String tag = (String) view1.getTag();
                search_edit.setText(tag);
                startActivityToResult();
            }
        });
        //这是输入法键盘下面生成的搜索键点击事件
        search_edit.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    KeyBoardUtils.hideSoftInput(search_edit);
                    if (search_edit.getText().toString().equals("")) {
                        Toast.makeText(MainActivity.this, "请输入关键字", Toast.LENGTH_SHORT).show();
                    } else {
                        SerachUtils.getInstance().saveSearch(search_edit.getText().toString());
                        startActivityToResult();
                        tagAdapter.onlyAdd(search_edit.getText().toString());
                        tagAdapter.notifyDataSetChanged();
                    }
                    return true;
                }
                return false;
            }
        });
    }

    /**
     * 去往搜索结果
     */
    private void startActivityToResult() {
        Intent intent = new Intent(MainActivity.this, SearchResurtActivity.class);
        intent.putExtra(Contants.SEARCH_KEY, search_edit.getText().toString());
        startActivity(intent);
    }

    @OnClick({R.id.act_search_cearch, R.id.clear_history})
    public void onClick(View view) {
        switch (view.getId()) {
            /**
             * 清空搜索历史
             */
            case R.id.clear_history:
                SerachUtils.getInstance().clear();
                searchHistory.clear();
                tagAdapter.clear();
                tagAdapter.notifyDataSetChanged();
                break;
            /**
             * 搜索的小图标
             */
            case R.id.act_search_cearch:
                KeyBoardUtils.hideSoftInput(search_edit);//隐藏输入法
                if (search_edit.getText() == null || search_edit.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "请输入关键字", Toast.LENGTH_SHORT).show();
                } else {
                    SerachUtils.getInstance().saveSearch(search_edit.getText().toString());//保存搜索的内容
                    startActivityToResult();
                    tagAdapter.onlyAdd(search_edit.getText().toString());
                    tagAdapter.notifyDataSetChanged();
                }
                break;
        }
    }
}
