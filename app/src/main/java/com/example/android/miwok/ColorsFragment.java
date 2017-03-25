package com.example.android.miwok;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    private MediaPlayer myMusic;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_colors2, container, false);
        View rootView = inflater.inflate(R.layout.words_list, container, false);
        //TextView textView = (TextView) rootView;
        //textView.setText("Fragment #" + mPage);


        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("red", "wetetti", R.drawable.color_red,R.raw.color_red));
        words.add(new Word("green", "chokokki", R.drawable.color_green,R.raw.color_green));
        words.add(new Word("brown", "takaakki", R.drawable.color_brown,R.raw.color_brown));
        words.add(new Word("gray", "topoppi", R.drawable.color_gray,R.raw.color_gray));
        words.add(new Word(" black", "kululli", R.drawable.color_black,R.raw.color_black));
        words.add(new Word("white", "kelelli", R.drawable.color_white,R.raw.color_white));
        words.add(new Word("dusty yellow", "topiise", R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new Word("mustard yellow", "chiwiite", R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        /*words.add("One");
        words.add("Two");
        words.add("Three");
        words.add("Four");
        words.add("Five");
        words.add("Six");
        words.add("Seven");
        words.add("Eight");
        words.add("Nine");
        words.add("Ten");*/

        //LinearLayout layoutView = (LinearLayout)findViewById(R.id.words_list);

        //ArrayAdapter<Word> listAdapter= new ArrayAdapter<String>(this,Word);
        WordsAdapter listAdapter = new WordsAdapter(getActivity(), words, R.color.category_colors);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Word wordout = words.get(position);
                releaseMediaPlayer();
                //Toast.makeText(NumbersActivity.this, "hello",Toast.LENGTH_LONG).show();
                MediaPlayer myMusic = MediaPlayer.create(getActivity(), wordout.getmAudioResourceID());
                myMusic.start();

                myMusic.setOnCompletionListener(mCompletionListener);
            }
        });
        return rootView;
    }

   /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }*/
        @Override
        public void onStop() {
            super.onStop();

            releaseMediaPlayer();
        }


            private void releaseMediaPlayer() {
                // If the media player is not null, then it may be currently playing a sound.
                if (myMusic != null) {
                    // Regardless of the current state of the media player, release its resources
                    // because we no longer need it.
                    myMusic.release();

                    // Set the media player back to null. For our code, we've decided that
                    // setting the media player to null is an easy way to tell that the media player
                    // is not configured to play an audio file at the moment.
                    myMusic = null;

                }
            }
        }

