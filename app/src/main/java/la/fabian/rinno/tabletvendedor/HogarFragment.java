package la.fabian.rinno.tabletvendedor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.schibsted.spain.parallaxlayerlayout.ParallaxLayerLayout;
import com.schibsted.spain.parallaxlayerlayout.SensorTranslationUpdater;


public class HogarFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    @Override
    public void onResume() {
        super.onResume();
    }

    public HogarFragment() {
        // Required empty public constructor
    }
    public static HogarFragment newInstance(String param1, String param2) {
        HogarFragment fragment = new HogarFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hogar, container, false);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
