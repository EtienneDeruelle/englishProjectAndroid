package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.etienne.englishtoeic_application.R;
import com.example.etienne.englishtoeic_application.VocabularyActivity;
import com.example.etienne.englishtoeic_application.VocabularyExamActivity;

import java.util.List;

import buisiness.Rule;
import buisiness.Theme;
import buisiness.Vocabulary;

/**
 * Created by etienne on 21/04/17.
 */

public class ThemeAdapter extends ArrayAdapter<Theme> {

    private int ressource;
    private static int position;
    public ThemeAdapter(Context context, int ressource, List<Theme> themes) {
        super(context, 0, themes);
        this.ressource = ressource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        this.position = position;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_one_vocabulary,parent, false);
        }

        ThemeAdapter.ThemeHolder viewHolder = (ThemeAdapter.ThemeHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ThemeAdapter.ThemeHolder();
            viewHolder.labelTheme = (TextView) convertView.findViewById(R.id.textTheme);
            viewHolder.buttonExam = (Button) convertView.findViewById(R.id.ButtonExam);
            viewHolder.buttonVoca = (Button) convertView.findViewById(R.id.ButtonVoca);

            convertView.setTag(viewHolder);
        }
        Theme theme = getItem(position);

        viewHolder.labelTheme.setText(theme.getLabelTheme());

        viewHolder.buttonExam.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intentLesson = new Intent(view.getContext(), VocabularyExamActivity.class);
                Theme theme = getRuleNumber(position);
                intentLesson.putExtra("idTheme",theme.getIdTheme());
                view.getContext().startActivity(intentLesson);
            }
        });

        viewHolder.buttonVoca.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intentLesson = new Intent(view.getContext(), VocabularyActivity.class);
                Theme theme = getRuleNumber(position);
                intentLesson.putExtra("idTheme",theme.getIdTheme());
                view.getContext().startActivity(intentLesson);
            }
        });
        return convertView;
    }

    public Theme getRuleNumber(int position){
        return getItem(position);
    }

    private class ThemeHolder{
        public TextView labelTheme;
        public Button buttonExam;
        public Button buttonVoca;
    }


}
