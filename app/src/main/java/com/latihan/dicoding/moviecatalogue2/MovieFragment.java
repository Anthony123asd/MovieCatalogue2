package com.latihan.dicoding.moviecatalogue2;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import java.util.ArrayList;


/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class MovieFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    private MovieAdapter adapter;
    private ArrayList<Movie> movies = new ArrayList<>();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MovieFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MovieFragment newInstance(int columnCount) {
        MovieFragment fragment = new MovieFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

        if (savedInstanceState == null) {
            adapter = new MovieAdapter(getContext());
            String[] titleData = getResources().getStringArray(R.array.movies_title);
            String[] dateData = getResources().getStringArray(R.array.movies_date);
            String[] descriptionData = getResources().getStringArray(R.array.movies_description);
            TypedArray posterData = getResources().obtainTypedArray(R.array.movies_poster);

            for (int i = 0; i < titleData.length; i++) {
                Movie movie = new Movie();
                movie.setPoster(posterData.getResourceId(i, -1));
                movie.setTitle(titleData[i]);
                movie.setDate(dateData[i]);
                movie.setDescription(descriptionData[i]);
                movies.add(movie);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            final Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            adapter.setMovies(movies);
            recyclerView.setAdapter(adapter);

            ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                @Override
                public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                    GoToDetails(position);
                }
            });
        }
        return view;
    }

    private void GoToDetails(int position){
        Movie movieClicked = new Movie();
        movieClicked.setTitle(movies.get(position).getTitle());
        movieClicked.setDate(movies.get(position).getDate());
        movieClicked.setDescription(movies.get(position).getDescription());
        movieClicked.setPoster(movies.get(position).getPoster());
        Intent moveToDetailIntent = new Intent(getContext(), MovieDetail.class);
        moveToDetailIntent.putExtra(MovieDetail.MOVIE_DETAIL, movieClicked);
        startActivity(moveToDetailIntent);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction();
    }
}
