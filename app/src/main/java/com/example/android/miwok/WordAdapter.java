package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;
    public WordAdapter(Activity context, ArrayList<Word> androidWords, int colorResourceId) {
        super(context, 0, androidWords);
        mColorResourceId=colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        Word currentWord = getItem(position);
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        TextView texto1 = (TextView) listItemView.findViewById(R.id.text_view_1);
        texto1.setText(currentWord.getmDefaultTranslation());

        TextView texto2 = (TextView) listItemView.findViewById(R.id.text_view_2);
        texto2.setText(currentWord.getmMiwokTranslation());

        ImageView imagen = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.getmImageResourceId() != 0) {
            imagen.setImageResource(currentWord.getmImageResourceId());
        } else {
            imagen.setVisibility(View.GONE);
        }

        LinearLayout textContainer = (LinearLayout) listItemView.findViewById(R.id.text_container);
        textContainer.setBackgroundResource(mColorResourceId);

        return listItemView;
    }
}
