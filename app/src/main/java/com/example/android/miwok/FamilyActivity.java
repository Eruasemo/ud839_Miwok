package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Father","әpә",R.drawable.family_father, R.raw.family_father));
        words.add(new Word("Mother","әta",R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("Son","angsi",R.drawable.family_son, R.raw.family_son));
        words.add(new Word("Daughter","tune",R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("Older brother","taachi",R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("Younger brother","chalitti",R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("Older sister","tete", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("Younger sister","kolliti",R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word("Grandmother","ama",R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("Grandfather","paapa",R.drawable.family_grandfather, R.raw. family_grandfather));

        WordAdapter itemsAdapter = new WordAdapter(this, words,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            MediaPlayer mediaPlayer = MediaPlayer.create(FamilyActivity.this, words.get(i).getmAudioResourceId());
            mediaPlayer.start();
        });

    }
}