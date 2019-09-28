package com.orange_infinity.vkhack.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.orange_infinity.vkhack.R;
import com.orange_infinity.vkhack.model.entity.dto.EventDto;

import java.util.ArrayList;
import java.util.List;

public class EventViewerFragment extends Fragment {

    private List<EventDto> events = new ArrayList<>();
    private EventAdapter eventAdapter;
    private RecyclerView eventRecycler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_viewer, container, false);

        EventDto eventDto1 = new EventDto("Man's Party", "27.09 - 29.09", "Best party ever!");
        EventDto eventDto2 = new EventDto("Собрание гос думы", "13.11 - 29.11", "Типичный день, листай дальше");
        EventDto eventDto3 = new EventDto("Студенты МГУПи идут в курилку", "01.01 - 31.12", "Паша: да я вообще-то курить бросаю");
        EventDto eventDto4 = new EventDto("VK Hack 2019", "27.09 - 29.09", "Spoiler: Orange is winner");

        events.add(eventDto1);
        events.add(eventDto2);
        events.add(eventDto3);
        events.add(eventDto4);

        setUpRecycler(v);
        return v;
    }

    private void setUpRecycler(View v) {
        eventAdapter = new EventAdapter(events);
        eventRecycler = v.findViewById(R.id.organizationRecycler);
        eventRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        eventRecycler.setAdapter(eventAdapter);
    }

    private class EventHandler extends RecyclerView.ViewHolder {

        private View eventView;

        public EventHandler(@NonNull View eventView) {
            super(eventView);
            this.eventView = eventView;
        }

        void bindView(EventDto event) {
            TextView tvEventName = eventView.findViewById(R.id.tvEventName);
            tvEventName.setText(event.getEventName());

            TextView tvDate = eventView.findViewById(R.id.tvDate);
            tvEventName.setText(event.getEventDate());

            TextView tvDescription = eventView.findViewById(R.id.tvDescription);
            tvEventName.setText(event.getEventDescription());
        }
    }

    private class EventAdapter extends RecyclerView.Adapter<EventHandler> {

        private List<EventDto> events;

        public EventAdapter(List<EventDto> events) {
            this.events = events;
        }

        @NonNull
        @Override
        public EventHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            View view = layoutInflater.inflate(R.layout.event_viewer_item, parent, false);

            return new EventHandler(view);
        }

        @Override
        public void onBindViewHolder(@NonNull EventHandler holder, int position) {
            EventDto event = events.get(position);
            holder.bindView(event);
        }

        @Override
        public int getItemCount() {
            return events.size();
        }
    }
}
