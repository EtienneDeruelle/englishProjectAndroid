package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.etienne.englishtoeic_application.R;

import java.util.List;

import buisiness.Vocabulary;

/**
 * Created by etienne on 21/04/17.
 */

public class VocabularyAdapter extends ArrayAdapter<Vocabulary> {

    private int ressource;
    private static int position;
    public VocabularyAdapter(Context context, int ressource, List<Vocabulary> vocabularies) {
        super(context, 0, vocabularies);
        this.ressource = ressource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        this.position = position;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_word,parent, false);
        }

        VocabularyAdapter.VocabularyHolder viewHolder = (VocabularyAdapter.VocabularyHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new VocabularyAdapter.VocabularyHolder();
            viewHolder.englishWord = (TextView) convertView.findViewById(R.id.englishWord);
            viewHolder.frenchWord = (TextView) convertView.findViewById(R.id.frenchWord);
            convertView.setTag(viewHolder);
        }
        Vocabulary vocabulary = getItem(position);
        viewHolder.englishWord.setText(vocabulary.getEnglishWord());
        viewHolder.frenchWord.setText(vocabulary.getFrenchWord());
        return convertView;
    }

    public Vocabulary getRuleNumber(int position){
        return getItem(position);
    }

    private class VocabularyHolder{
        public TextView englishWord;
        public TextView frenchWord;
    }
}
