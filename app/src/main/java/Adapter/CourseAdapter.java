package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.etienne.englishtoeic_application.R;

import java.util.List;

import buisiness.Rule;

/**
 * Created by etienne on 18/04/17.
 */

public class CourseAdapter extends ArrayAdapter<Rule>{

    public CourseAdapter(Context context, List<Rule> rules) {
        super(context, 0, rules);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_one_course,parent, false);
        }

        CourseHolder viewHolder = (CourseHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new CourseHolder();
            viewHolder.tagName = (TextView) convertView.findViewById(R.id.textViewTagName);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Rule rule = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.tagName.setText(rule.getTagName());
        return convertView;
    }

    private class CourseHolder{
        public TextView tagName;
    }
}