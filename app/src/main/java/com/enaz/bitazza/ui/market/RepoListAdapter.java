//package com.enaz.bitazza.ui.market;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.lifecycle.LifecycleOwner;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.enaz.bitazza.R;
//import com.enaz.bitazza.data.model.Repo;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.RepoViewHolder>{
//
//    private final List<Repo> data = new ArrayList<>();
//
//    RepoListAdapter(MarketViewModel marketViewModel, LifecycleOwner lifecycleOwner) {
//        marketViewModel.getRepos().observe(lifecycleOwner, repos -> {
//            data.clear();
//            if (repos != null) {
//                data.addAll(repos);
//                notifyDataSetChanged();
//            }
//        });
//        setHasStableIds(true);
//    }
//
//    @NonNull
//    @Override
//    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_repo_list_item, parent, false);
//        return new RepoViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
//        holder.bind(data.get(position));
//    }
//
//    @Override
//    public int getItemCount() {
//        return data.size();
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return data.get(position).id;
//    }
//
//    static final class RepoViewHolder extends RecyclerView.ViewHolder {
//
//        @BindView(R.id.tv_repo_name)
//        TextView repoNameTextView;
//        @BindView(R.id.tv_repo_description)
//        TextView repoDescriptionTextView;
//        @BindView(R.id.tv_forks)
//        TextView forksTextView;
//        @BindView(R.id.tv_stars)
//        TextView starsTextView;
//
//        private Repo repo;
//
//        RepoViewHolder(View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
////            itemView.setOnClickListener(v -> {
////                if(repo != null) {
////                }
////            });
//        }
//
//        void bind(Repo repo) {
//            this.repo = repo;
//            repoNameTextView.setText(repo.name);
//            repoDescriptionTextView.setText(repo.description);
//            forksTextView.setText(String.valueOf(repo.forks));
//            starsTextView.setText(String.valueOf(repo.stars));
//        }
//    }
//}
