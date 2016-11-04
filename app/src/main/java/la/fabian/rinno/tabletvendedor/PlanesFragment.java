package la.fabian.rinno.tabletvendedor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.zip.Inflater;



public class PlanesFragment extends Fragment {

    LinearLayout linearBuscardorPlanes, contentPlanes;


    private OnFragmentInteractionListener mListener;

    public PlanesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_planes, container, false);
        linearBuscardorPlanes = (LinearLayout) v.findViewById(R.id.linear_buscador_planes);
        contentPlanes = (LinearLayout) v.findViewById(R.id.content_planes);
        return v;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
