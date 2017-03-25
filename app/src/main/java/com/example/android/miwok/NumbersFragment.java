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
public class NumbersFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    private MediaPlayer myMusic;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.words_list, container, false);
        View rootView = inflater.inflate(R.layout.words_list, container, false);
        //TextView textView = (TextView) rootView;
        //textView.setText("Fragment #" + mPage);

        final ArrayList<Word> words = new ArrayList<Word>();


        words.add(new Word("One", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("Two", "Otilko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Three", "Tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("Four", "Oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("Five", "Massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("Six", "Temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Seven", "Kenakaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("Eight", "Kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("Nine", "Nueva", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Ten", "Diaz", R.drawable.number_ten, R.raw.number_ten));

        //LinearLayout layoutView = (LinearLayout)findViewById(R.id.words_list);

        //ArrayAdapter<Word> listAdapter= new ArrayAdapter<String>(this,Word);
        WordsAdapter listAdapter = new WordsAdapter(getActivity(), words, R.color.category_numbers);
        //final MediaPlayer myMusic = MediaPlayer.create(this, R.raw.number_seven);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        //listView = (ListView) rootView.findViewById(R.id.list);

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

    /*@Override
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

