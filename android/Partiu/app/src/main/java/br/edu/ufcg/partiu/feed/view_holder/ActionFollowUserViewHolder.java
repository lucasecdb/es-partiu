package br.edu.ufcg.partiu.feed.view_holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Map;

import br.edu.ufcg.partiu.R;
import br.edu.ufcg.partiu.model.Action;
import br.edu.ufcg.partiu.model.ActionType;
import br.edu.ufcg.partiu.util.ItemAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lucas on 31/07/17.
 */

public class ActionFollowUserViewHolder extends ItemAdapter.ItemViewHolder<ActionHolder> {

    public static final int VIEW_TYPE = ActionType.FOLLOW_USER.ordinal();

    @BindView(R.id.user_name)
    TextView userNameText;

    @BindView(R.id.second_user_name)
    TextView secondUserNameText;

    public ActionFollowUserViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(ActionHolder itemHolder) {
        Action action = itemHolder.getAction();

        userNameText.setText(action.getUser().getName());
        secondUserNameText.setText((String) ((Map<String, Object>) action.getArguments().get("user")).get("name"));
    }

    public static class Factory implements ItemAdapter.ItemViewHolder.Factory {

        private final LayoutInflater inflater;

        public Factory(LayoutInflater inflater) {
            this.inflater = inflater;
        }

        @Override
        public ItemAdapter.ItemViewHolder createViewHolder(ViewGroup parent, int viewType) {
            return new ActionFollowUserViewHolder(
                    inflater.inflate(R.layout.view_holder_action_follow_user, parent, false)
            );
        }
    }
}
