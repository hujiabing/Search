package net.neiquan.search.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import net.neiquan.search.R;
import net.neiquan.search.inter.Contants;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SearchResurtActivity extends AppCompatActivity {

    @InjectView(R.id.text)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_resurt);
        ButterKnife.inject(this);
        String stringExtra = getIntent().getStringExtra(Contants.SEARCH_KEY);
        text.setText(stringExtra);
    }
}
