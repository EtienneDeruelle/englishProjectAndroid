package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.etienne.englishtoeic_application.CourseActivity;
import com.example.etienne.englishtoeic_application.CoursesActivity;
import com.example.etienne.englishtoeic_application.MenuActivity;
import com.example.etienne.englishtoeic_application.QuestionActivity;
import com.example.etienne.englishtoeic_application.R;

import java.util.List;

import buisiness.Rule;

/**
 * Created by etienne on 18/04/17.
 */

public class CourseAdapter extends ArrayAdapter<Rule>{

    private int ressource;
    private static int position;
    public CourseAdapter(Context context,int ressource, List<Rule> rules) {
        super(context, 0, rules);
        this.ressource = ressource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        this.position = position;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_one_course,parent, false);
        }

        CourseHolder viewHolder = (CourseHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new CourseHolder();
            viewHolder.tagName = (TextView) convertView.findViewById(R.id.textViewTagName);
            viewHolder.buttonTagName = (Button) convertView.findViewById(R.id.ButtonTagName);

            convertView.setTag(viewHolder);
        }
        Rule rule = getItem(position);
        viewHolder.tagName.setText(rule.getTagName());
        viewHolder.buttonTagName.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intentLesson = new Intent(view.getContext(), CourseActivity.class);
                Rule rule = getRuleNumber(position);
                intentLesson.putExtra("numberLesson",rule.getIdRule());
                view.getContext().startActivity(intentLesson);
            }
        });
        return convertView;
    }

    public Rule getRuleNumber(int position){
        return getItem(position);
    }

    private class CourseHolder{
        public TextView tagName;
        public Button buttonTagName;
    }
}