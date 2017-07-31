package br.edu.ufcg.partiu.event;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import br.edu.ufcg.partiu.R;
import butterknife.BindView;
import butterknife.ButterKnife;

import static android.app.Activity.RESULT_OK;

/**
 * Created by lucas on 30/07/17.
 */

public class CreateEventFragment extends Fragment implements CreateEventContract.View {
    private static int PLACE_PICKER_REQUEST = 1;

    private CreateEventContract.Presenter presenter;

    @BindView(R.id.event_local_button)
    Button localizationButton;

    @BindView(R.id.event_name)
    TextInputEditText nameEditText;

    @BindView(R.id.event_description)
    TextInputEditText descriptionEditText;

    @BindView(R.id.event_start_date)
    TextInputEditText startDateEditText;

    @BindView(R.id.event_end_date)
    TextInputEditText endDateEditText;

    @BindView(R.id.createButton)
    Button createButton;

    @Override
    public void setPresenter(CreateEventContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_event, container, false);

        ButterKnife.bind(this, view);

        localizationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

                try {
                    startActivityForResult(builder.build(getActivity()), PLACE_PICKER_REQUEST);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onCreateEvent();
            }
        });

        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.onEventNameChange(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // nothing
            }
        });

        descriptionEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.onEventDescriptionChange(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // nothing
            }
        });

        startDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onStartDateClick();
            }
        });

        endDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onEndDateClick();
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != PLACE_PICKER_REQUEST || resultCode != RESULT_OK) {
            return;
        }

        Place place = PlacePicker.getPlace(getContext(), data);

        presenter.onPlacePickerResult(place);
    }

    @Override
    public void showSuccessCreateEventToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
