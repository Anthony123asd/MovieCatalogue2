package com.latihan.dicoding.moviecatalogue2;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TvShowFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TvShowFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TvShowFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private TvShowAdapter adapter;
    private ArrayList<TvShow> tvShows = new ArrayList<>();

    public TvShowFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TvShowFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TvShowFragment newInstance(String param1, String param2) {
        TvShowFragment fragment = new TvShowFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        if (savedInstanceState == null) {
            adapter = new TvShowAdapter(getContext());
        String[] titleData = getResources().getStringArray(R.array.tvshows_title);
        String[] dateData = getResources().getStringArray(R.array.tvshows_date);
        String[] descriptionData = getResources().getStringArray(R.array.tvshows_description);
        TypedArray posterData = getResources().obtainTypedArray(R.array.tvshows_poster);

        for (int i = 0; i < titleData.length; i++) {
            TvShow tvShow = new TvShow();
            tvShow.setPoster(posterData.getResourceId(i, -1));
            tvShow.setTitle(titleData[i]);
            tvShow.setDate(dateData[i]);
            tvShow.setDescription(descriptionData[i]);
            tvShows.add(tvShow);
        }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tvshow_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));


            adapter.setTvShows(tvShows);
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
        TvShow tvShowClicked = new TvShow();
        tvShowClicked.setTitle(tvShows.get(position).getTitle());
        tvShowClicked.setDate(tvShows.get(position).getDate());
        tvShowClicked.setDescription(tvShows.get(position).getDescription());
        tvShowClicked.setPoster(tvShows.get(position).getPoster());
        Intent moveToDetailIntent = new Intent(getContext(), TvShowDetail.class);
        moveToDetailIntent.putExtra(TvShowDetail.TVSHOW_DETAIL, tvShowClicked);
        startActivity(moveToDetailIntent);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }


    }

    @Override
    public void onResume() {
        super.onResume();

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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
